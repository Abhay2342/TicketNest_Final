import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { BookingService } from 'src/app/services/booking/booking.service';
import { TicketService } from 'src/app/services/ticket/ticket.service';
import { ClientHeaderComponent } from "../client-header/client-header.component";
import { loadStripe } from '@stripe/stripe-js';

@Component({
  imports: [CommonModule,ClientHeaderComponent], // Removed unnecessary imports
  selector: 'app-booking-summary',
  templateUrl: './booking-summary.component.html',
  styleUrls: ['./booking-summary.component.scss']
})


export class BookingSummaryComponent {
  ticket: any = null; // Holds the ticket returned from backend
  paymentCompleted = false;
ngOnInit() {
  const storedData = sessionStorage.getItem('bookingData');
  if (storedData) {
    const bookingData = JSON.parse(storedData);
    this.ticket = bookingData;
    this.paymentCompleted = true;
    sessionStorage.removeItem('bookingData'); // Clear it after use
      setTimeout(() => {
      this.bookTicket();
    }, 3000); // Optional: Clear ticket after 5 seconds
  }
  
}

mergeObjectsUnique<T, U>(original: T, updates: U): T & U {
  return { ...updates, ...original };
}


  constructor(public bookingService: BookingService, private ticketService: TicketService) {}

  async makePayment() {
  const stripe = await loadStripe('pk_test_51RSJPVSIFehX5VYL92C2V0qN4miblRP8A7p1Tgo35zJGBBIamoA0NUQjjzkD4wHDDLRGD8lyXfuS8UGsp8Ilz7Zk00vCmmuf9F');

  if (!stripe) {
    console.error('Stripe failed to load');
    return;
  }

  

  // Save booking details before redirecting
  sessionStorage.setItem('bookingData', JSON.stringify({
    seatsBooked: this.bookingService.selectedSeats.length,
    seatNumbers: this.bookingService.selectedSeats.join(', '),
    showId: this.bookingService.getShow().id,
    showDate: this.bookingService.getShow()?.showDate,
    showTime: this.bookingService.getShow()?.showTime,
    userId: JSON.parse(sessionStorage.getItem('userData') || '{}').id
  }));

  const { error } = await stripe.redirectToCheckout({
    lineItems: [{ price: 'price_1RSJQuSIFehX5VYLLeYBs08E', quantity: 1 }],
    mode: 'payment',
    successUrl: window.location.href, // The same page reloads, but we can restore data
    cancelUrl: 'http://localhost:4200/cancel',
  });

  if (error) {
    console.error(error);
    window.location.href = 'http://localhost:4200/cancel'; // Redirecting only on failed payment
  }

  // Call bookTicket after successful payment

}

  bookTicket() {
    console.log("Booking Ticket...");
    console.log(this.ticket)
    const ticketPayload = {
      seatsBooked: this.ticket.seatsBooked,
      seatNumbers: this.ticket.seatNumbers || this.bookingService.selectedSeats.join(', '),
      showId: this.ticket.showId || this.bookingService.getShow().id, // Use ticket showId if available
      showDate: this.ticket.showDate || this.bookingService.getShow().showDate,
      showTime: this.ticket.showTime || this.bookingService.getShow().showTime,
      status: 'CONFIRMED',
      userId: JSON.parse(sessionStorage.getItem('userData') || '{}').id
    };

    this.ticketService.bookTicket(ticketPayload).subscribe(response => {
      console.log("Ticket booked successfully:", response);
     this.ticket = this.mergeObjectsUnique(this.ticket, response); // Merge ticket details
     console.log("Merged Ticket:", this.ticket);
      this.paymentCompleted = true;
      
      alert('Payment successful and ticket booked!');
    });
  }
}