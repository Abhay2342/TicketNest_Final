import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-merchant-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule], // 👈 Add RouterModule here
  templateUrl: './merchant-dashboard.component.html',
  styleUrls: ['./merchant-dashboard.component.scss']
})
export class MerchantDashboardComponent implements OnInit {
  user: any;

  constructor(private router: Router) {}


  ngOnInit(): void {
    const storedUser = sessionStorage.getItem('userData');
    this.user = storedUser ? JSON.parse(storedUser) : null;
  }

  logout() {
    // Clear token or session
    sessionStorage.clear();
    // Navigate to login
    this.router.navigate(['/login']);
  }
}
