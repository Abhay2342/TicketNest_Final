import { Component } from '@angular/core';
import { BookingService } from 'src/app/services/booking/booking.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ClientHeaderComponent } from "../client-header/client-header.component";

@Component({
  selector: 'app-seat-selection',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, ClientHeaderComponent],
  templateUrl: './seat-selection.component.html',
  styleUrls: ['./seat-selection.component.scss']
})
export class SeatSelectionComponent {
  rows = ['A', 'B', 'C', 'D'];
  cols = [1, 2, 3, 4, 5, 6, 7, 8];
  selected: string[] = [];

  constructor(private bookingService: BookingService, private router: Router) {}

  isSelected(seat: string): boolean {
    return this.selected.includes(seat);
  }

  toggleSeat(seat: string): void {
    const index = this.selected.indexOf(seat);
    if (index > -1) {
      this.selected.splice(index, 1);
    } else {
      this.selected.push(seat);
    }
  }

  confirmSeats(): void {
    this.bookingService.setSeats(this.selected);
    this.router.navigate(['/booking-summary']);
  }
}
