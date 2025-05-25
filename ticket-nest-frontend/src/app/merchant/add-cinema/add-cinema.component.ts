import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import axios from 'axios';

@Component({
  selector: 'app-add-cinema',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-cinema.component.html',
  styleUrls: ['./add-cinema.component.scss']
})
export class AddCinemaComponent implements OnInit {
  cinemaForm!: FormGroup;
  merchantId: string = '';
  cinemas: any[] = [];

  constructor(private fb: FormBuilder) {

  }

  ngOnInit(): void {
    this.merchantId = JSON.parse(sessionStorage.getItem('userData') || '{}').id;

    this.cinemaForm = this.fb.group({
      name: ['', Validators.required],
      location: ['', Validators.required],
      description: ['', Validators.required]
    });

    this.fetchCinemas(); // fetch on load
  }

  
  

  async onSubmit() {
    const merchant = JSON.parse(sessionStorage.getItem('userData')!);
    if (this.cinemaForm.valid) {
      const payload = {
        ...this.cinemaForm.value,
        merchantId: merchant?.id || 1 
      };

      try {
        await axios.post('http://localhost:8081/cinema-service/api/cinemas', payload);
        alert('Cinema added successfully!');
        this.cinemaForm.reset();
        this.fetchCinemas(); // refresh list after add
      } catch (error) {
        console.error('Error adding cinema:', error);
        alert('Failed to add cinema. Please try again.');
      }
    } else {
      this.cinemaForm.markAllAsTouched();
    }
  }

  async fetchCinemas() {
    try {
        const response = await axios.get(`http://localhost:8081/cinema-service/api/cinemas/${this.merchantId}`);
        let result = response.data;
        this.cinemas = Array.isArray(result) ? result : [result];
        console.log('Cinemas:', this.cinemas);
    } catch (error) {
        if (axios.isAxiosError(error)) {
            console.error(`Error fetching cinemas: ${error.response?.status} - ${error.response?.data?.message || 'Unknown error'}`);
            console.error(`Path: ${error.response?.data?.path}`);
            console.error(`Timestamp: ${error.response?.data?.timestamp}`);
        } else {
            console.error("Unexpected error:", (error as Error).message);
        }
        this.cinemas = [];
    }
}
}
