import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ClientHeaderComponent } from '../../components/client-header/client-header.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ClientHeaderComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  isLoggedIn = false;

  constructor(private router: Router) {
    // Check login status whenever this component is initialized
    this.checkLoginStatus();
  }

  // Function to check if user is logged in
  checkLoginStatus() {
    this.isLoggedIn = !!sessionStorage.getItem('authToken');
  }

  logout() {
    // Clear sessionStorage to log out
    sessionStorage.clear();
    // Check login status again after logging out
    this.checkLoginStatus();
    // Navigate to login page
    this.router.navigate(['/login']);
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }

  browseMovies() {
    this.router.navigate(['/movies']);
  }
}
