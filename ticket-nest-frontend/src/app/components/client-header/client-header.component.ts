import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-client-header',
  templateUrl: './client-header.component.html',
  imports: [CommonModule, RouterModule],
  styleUrls: ['./client-header.component.scss']
})
export class ClientHeaderComponent {
  isLoggedIn = false;
  isMenuOpen = false;

  constructor(private router: Router) {
    // Check login status whenever the header is loaded
    this.checkLoginStatus();
  }

  checkLoginStatus() {
    this.isLoggedIn = !!sessionStorage.getItem('authToken');
  }

  logout() {
    // Clear sessionStorage to log out
    sessionStorage.clear();
    // Check login status again after logging out
    this.checkLoginStatus();
    // Redirect to home page or login page
    this.router.navigate(['/home']);
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }

  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen;
  }
}
