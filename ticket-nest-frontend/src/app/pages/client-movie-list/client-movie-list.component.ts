import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/services/booking/booking.service';
import { Router } from '@angular/router';
import { MovieService } from '../../services/movie.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClientHeaderComponent } from 'src/app/components/client-header/client-header.component';

@Component({
  imports: [CommonModule, ReactiveFormsModule, FormsModule, ClientHeaderComponent], // <-- Add here
  selector: 'app-client-movie-list',
  templateUrl: './client-movie-list.component.html',
  styleUrls: ['./client-movie-list.component.scss']
})
export class ClientMovieListComponent implements OnInit {
  movies: any[] = [];
  searchTerm = '';

  constructor(private movieService: MovieService, private bookingService: BookingService, private router: Router) {}

  ngOnInit(): void {
    this.movieService.getAllMovies().subscribe(data => {
      this.movies = data;
    });
  }

  filteredMovies() {
    return this.movies.filter(movie =>
      movie.title.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }

  selectMovie(movie: any) {
    this.bookingService.setMovie(movie);
    this.router.navigate(['/select-cinema']);
  }
}
