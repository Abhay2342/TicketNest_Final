import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import axios from 'axios';

@Component({
  selector: 'app-view-bookings',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-show.component.html',
  styleUrls: ['./view-show.component.scss']
})
export class ViewShowComponent implements OnInit {
  showTimings: any[] = [];

  async ngOnInit() {
    const merchantData = sessionStorage.getItem('userData');
    if (!merchantData) {
      console.error('Merchant data not found in sessionStorage');
      return;
    }

    const merchant = JSON.parse(merchantData);
    const merchantId = merchant.id;

    try {
      const response = await axios.get(`http://localhost:8081/showtiming-service/api/show-timings/merchant/${merchantId}`);
      this.showTimings = response.data;
      console.log('Show Timings:', this.showTimings);
    } catch (error) {
      console.error('Failed to fetch bookings:', error);
    }
  }
}
