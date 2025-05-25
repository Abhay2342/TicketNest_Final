import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ClientHeaderComponent } from "../../components/client-header/client-header.component";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, ClientHeaderComponent],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  async onSubmit() {
    if (this.loginForm.valid) {
      const formData = this.loginForm.value;
      try {
        const response: any = await this.loginService.loginUser(formData); // You can type this better if needed
        console.log('Response:', response);
        if (response?.statusCode === 200 && response.userData) {
          const userData = response.userData;
          const token = response.token;

          sessionStorage.setItem('userData', JSON.stringify(userData));
          if (token) {
            sessionStorage.setItem('authToken', token);
          }

          console.log('Login Success:', userData);
          alert('Login successful!');

          // Navigate based on user role
          const role = userData.role?.toUpperCase();
          if (role === 'MERCHANT') {
            this.router.navigate(['/merchant']);
          } else {
            this.router.navigate(['/movies']);
          }

        } else if (response?.statusCode === 401) {
          alert('Invalid credentials. Please try again.');
        } else if (response?.statusCode === 404) {
          alert('User Not Found. Please try again.');
        } else {
          alert('Unexpected response. Please try again later.');
        }
      } catch (error) {
        console.error('Login Failed:', error);
        alert('Something went wrong. Please try again later.');
      }
    } else {
      this.loginForm.markAllAsTouched();
    }
  }
}
