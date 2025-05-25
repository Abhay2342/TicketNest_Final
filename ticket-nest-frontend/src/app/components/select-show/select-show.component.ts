import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/services/booking/booking.service';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ClientHeaderComponent } from "../client-header/client-header.component";

@Component({
  imports: [CommonModule, ClientHeaderComponent], // No imports needed for this component
  selector: 'app-select-show',
  templateUrl: './select-show.component.html',
  styleUrls: ['./select-show.component.scss']
})
export class SelectShowComponent implements OnInit {
  showTimings: any[] = [];
  movieId!: number;
  cinemaId!: number;

  constructor(
    private router: Router,
    private bookingService: BookingService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    const movie = this.bookingService.getMovie();
    const cinema = this.bookingService.getCinema();

    if (!movie || !cinema) {
      alert('Incomplete booking data. Please start again.');
      this.router.navigate(['/movies']);
      return;
    }

    this.movieId = movie.id;
    this.cinemaId = cinema.id;

    this.fetchShowTimings();
  }

  fetchShowTimings(): void {
    const url = `http://localhost:8081/showtiming-service/api/show-timings/movie-cinema?movieId=${this.movieId}&cinemaId=${this.cinemaId}`;
    this.http.get<any[]>(url).subscribe(
      (data) => {
        this.showTimings = data;
      },
      (error) => {
        console.error('Error fetching show timings:', error);
      }
    );
  }

  selectShow(show: any): void {
    this.bookingService.setShow(show);
    this.router.navigate(['/select-seats']);
  }
}
