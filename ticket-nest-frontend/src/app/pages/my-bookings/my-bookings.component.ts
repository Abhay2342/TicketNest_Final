import { Component, OnInit } from '@angular/core';
import { TicketService } from '../../services/ticket/ticket.service';
import {  Router } from '@angular/router';
import { ClientHeaderComponent } from "../../components/client-header/client-header.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-bookings',
  templateUrl: './my-bookings.component.html',
  imports: [CommonModule,ClientHeaderComponent],
})
export class MyBookingsComponent implements OnInit {
  tickets: any[] = [];
  userId: number = 1; // Change this to dynamically fetch logged-in user's ID

  constructor(private ticketService: TicketService, private router: Router) {}

  ngOnInit(): void {
  this.getUserData();
  this.getMyBookings();
}

getUserData(): void {
  const userString = sessionStorage.getItem('userData');
  
  if (userString) {
    const user = JSON.parse(userString);
    this.userId = user.id;
  } else {
    console.error('User data not found in session storage.');
    this.router.navigate(['/login']); // Redirect to login if not found
  }
}

  getMyBookings(): void {
  if (!this.userId) {
    console.error('User ID missing');
    return;
  }

  this.ticketService.getTicketsByUserId(this.userId).subscribe({
    next: (data) => {
      this.tickets = data;
      console.log("Tickets fetched successfully:", this.tickets);
    },
    error: (err) => {
      console.error("Error fetching tickets:", err);
      this.tickets = [];
    },
  });
}

  cancelBooking(ticketId: number): void {
    this.ticketService.cancelBooking(ticketId).subscribe(() => {
      this.tickets = this.tickets.filter(ticket => ticket.id !== ticketId);
    });
  }

  browseMovies(): void {
  this.router.navigate(['/movies']);
  }
}