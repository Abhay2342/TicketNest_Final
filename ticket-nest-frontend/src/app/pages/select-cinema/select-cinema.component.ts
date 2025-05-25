import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/services/booking/booking.service';
import { CinemaService } from '../../services/cinema.service';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClientHeaderComponent } from "../../components/client-header/client-header.component";

@Component({
  selector: 'app-select-cinema',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, ClientHeaderComponent],
  templateUrl: './select-cinema.component.html',
  styleUrls: ['./select-cinema.component.scss'],
})
export class SelectCinemaComponent implements OnInit {
  cinemas: any[] = [];
  filteredCinemas: any[] = [];
  searchLocation: string = '';

  constructor(
    private bookingService: BookingService,
    private cinemaService: CinemaService,
    private router: Router
  ) {}

  ngOnInit(): void {
  this.checkUserAuthentication(); // Ensure user is logged in
  this.loadCinemas();
}

checkUserAuthentication(): void {
  const authToken = sessionStorage.getItem('authToken');

  if (!authToken) {
    alert('Please login to continue.');
    this.router.navigate(['/login']); // Redirect to login page
    return;
  }
}

loadCinemas(): void {
  const movie = this.bookingService.getMovie();

  if (!movie || !movie.id) {
    alert('Movie not selected. Redirecting to movie list.');
    this.router.navigate(['/movies']);
    return;
  }

  this.cinemaService.getCinemasByMovie(movie.id).subscribe(
    (data: any[]) => {
      this.cinemas = data;
      this.filteredCinemas = data;
    },
    (error) => {
      console.error('Error fetching cinemas:', error);
    }
  );
}

  filterCinemas(): void {
    const search = this.searchLocation.toLowerCase();
    this.filteredCinemas = this.cinemas.filter((cinema) =>
      cinema.location.toLowerCase().includes(search)
    );
  }

  selectCinema(cinema: any): void {
    this.bookingService.setCinema(cinema);
    this.router.navigate(['/select-show']);
  }
}
