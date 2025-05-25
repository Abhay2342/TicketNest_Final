import { Injectable } from '@angular/core';

// booking.service.ts

@Injectable({ providedIn: 'root' })
export class BookingService {
  private selectedMovie: any;
  private selectedCinema: any;
  private selectedShow: any;
  public selectedSeats: string[] = [];

  // Getter methods
  getMovie() {
    return this.selectedMovie;
  }

  getCinema() {
    return this.selectedCinema;
  }

  getShow() {
    return this.selectedShow;
  }

  setMovie(movie: any) {
    this.selectedMovie = movie;
  }

  setCinema(cinema: any) {
    this.selectedCinema = cinema;
  }

  setShow(show: any) {
    this.selectedShow = show;
  }

  setSeats(seats: string[]) {
    this.selectedSeats = seats;
  }

  resetBooking() {
    this.selectedMovie = null;
    this.selectedCinema = null;
    this.selectedShow = null;
    this.selectedSeats = [];
  }
}
