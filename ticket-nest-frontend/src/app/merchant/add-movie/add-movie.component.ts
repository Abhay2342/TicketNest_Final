import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import axios from 'axios';

@Component({
  selector: 'app-add-movie',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.scss']
})
export class AddMovieComponent implements OnInit {
  movieForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.movieForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      durationMinutes: [0, Validators.required],
      genre: ['', Validators.required],
      language: ['', Validators.required],
      releaseDate: ['', Validators.required],
      imageUrl: ['', Validators.required]  // New field for image URL
    });
    
  }

  async onSubmit() {
  if (this.movieForm.valid) {
    try {
      // Retrieve JWT token from session storage
      const authToken = sessionStorage.getItem('authToken');
      
      // Configure headers with authorization token
      const headers = {
        Authorization: `Bearer ${authToken}`,
        'Content-Type': 'application/json'
      };

      // Send request with headers
      const response = await axios.post(
        'http://localhost:8081/movie-service/api/movies',
        this.movieForm.value,
        { headers }
      );

      alert('Movie added successfully!');
      console.log('Response:', response.data);
      this.movieForm.reset();
    } catch (error) {
      if (axios.isAxiosError(error)) {
        console.error(`Error adding movie: ${error.response?.status} - ${error.response?.data?.message || 'Unknown error'}`);
      } else {
        console.error("Unexpected error:", error);
      }
      alert('Failed to add movie. Please try again.');
    }
  } else {
    this.movieForm.markAllAsTouched();
  }
}
}
