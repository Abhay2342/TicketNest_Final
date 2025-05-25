import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import axios from 'axios';

@Component({
  selector: 'app-view-bookings',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-bookings.component.html',
  styleUrls: ['./view-bookings.component.scss']
})
export class ViewBookingsComponent implements OnInit {
  bookings: any[] = [];

  async ngOnInit() {
    const merchantData = sessionStorage.getItem('userData');
    if (!merchantData) {
      console.error('Merchant data not found in sessionStorage');
      return;
    }

    const merchant = JSON.parse(merchantData);
    const merchantId = merchant.id;

    try {
      const response = await axios.get(`http://localhost:8081/ticket-service/api/ticket/merchant/${merchantId}/tickets`);
      this.bookings = response.data;
      console.log('Bookings:', this.bookings);
    } catch (error) {
      console.error('Failed to fetch bookings:', error);
    }
  }
}
