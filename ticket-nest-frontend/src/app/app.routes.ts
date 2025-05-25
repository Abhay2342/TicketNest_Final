import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { ClientMovieListComponent } from './pages/client-movie-list/client-movie-list.component';
import { SelectCinemaComponent } from './pages/select-cinema/select-cinema.component';
import { SeatSelectionComponent } from './components/seat-selection/seat-selection.component';
import { BookingSummaryComponent } from './components/booking-summary/booking-summary.component';
import { SelectShowComponent } from './components/select-show/select-show.component';
import { MyBookingsComponent } from './pages/my-bookings/my-bookings.component';
export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'movies', component: ClientMovieListComponent },
  { path: 'select-cinema', component: SelectCinemaComponent },
  { path: 'select-seats', component: SeatSelectionComponent },
  { path: 'booking-summary', component: BookingSummaryComponent },
  { path: 'select-show', component: SelectShowComponent },
  { path: 'my-bookings', component: MyBookingsComponent },
  {
    path: 'merchant',
    loadComponent: () =>
      import('./merchant/dashboard/merchant-dashboard.component').then(m => m.MerchantDashboardComponent),
    children: [
      {
        path: 'add-cinema',
        loadComponent: () =>
          import('./merchant/add-cinema/add-cinema.component').then(m => m.AddCinemaComponent)
      },
      {
        path: 'add-movie',
        loadComponent: () =>
          import('./merchant/add-movie/add-movie.component').then(m => m.AddMovieComponent)
      },
      {
        path: 'add-show',
        loadComponent: () =>
          import('./merchant/add-show/add-show.component').then(m => m.AddShowComponent)
      },
      {
        path: 'view-show',
        loadComponent: () =>
          import('./merchant/view-show/view-show.component').then(m => m.ViewShowComponent)
      },
      {
        path: 'bookings',
        loadComponent: () =>
          import('./merchant/view-bookings/view-bookings.component').then(m => m.ViewBookingsComponent)
      },
      {
        path: '', redirectTo: 'add-cinema', pathMatch: 'full'
      }
    ]
  }
  
];
