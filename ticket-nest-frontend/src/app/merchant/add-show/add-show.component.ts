import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-show-timing',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-show.component.html',
  styleUrls: ['./add-show.component.scss']
})
export class AddShowComponent implements OnInit {
  cinemas: any[] = [];
  movies: any[] = [];
  selectedCinemaId: number | null = null;
  selectedMovieId: number | null = null;
  showForm!: FormGroup;
  step = 1;

  constructor(private fb: FormBuilder, private http: HttpClient) {}
  

  ngOnInit(): void {
    const merchantId = JSON.parse(sessionStorage.getItem('userData') || '{}')?.id;
    this.fetchCinemas(merchantId);

    this.showForm = this.fb.group({
      showDate: ['', Validators.required],
      showTime: ['', Validators.required],
      ticketPrice: ['', Validators.required],
      totalSeats: ['', Validators.required]
    });
  }

  // Get JWT token from session storage
  private getAuthToken(): string | null {
    return sessionStorage.getItem('authToken');
  }

  // Set Authorization header
  private getHeaders(): HttpHeaders {
    const token = this.getAuthToken();
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': token ? `Bearer ${token}` : ''
    });
  }

  fetchCinemas(merchantId: number) {
    this.http.get(`http://localhost:8081/cinema-service/api/cinemas/${merchantId}`, {}).subscribe((res: any) => {
      this.cinemas = Array.isArray(res) ? res : [res];
    });
  }

  onCinemaSelect(cinemaId: number) {
    this.selectedCinemaId = cinemaId;
    this.step = 2;
    this.fetchMovies();
  }

  fetchMovies() {
    this.http.get('http://localhost:8081/movie-service/api/movies', { headers: this.getHeaders() }).subscribe((res: any) => {
      this.movies = res;
    });
  }

  onMovieSelect(movieId: number) {
    this.selectedMovieId = movieId;
    this.step = 3;
  }

  onSubmit() {
    if (this.showForm.valid && this.selectedCinemaId && this.selectedMovieId) {
      const formData = this.showForm.value;

      const payload = {
        cinemaId: this.selectedCinemaId,
        movieId: this.selectedMovieId,
        showDate: formData.showDate,
        showTime: formData.showTime,
        ticketPrice: formData.ticketPrice,
        totalSeats: formData.totalSeats
      };

      this.http.post('http://localhost:8081/showtiming-service/api/show-timings', payload).subscribe(
        () => alert('Show Timing Added!'),
        err => alert('Failed to add show timing')
      );
    }
  }
}
