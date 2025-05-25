import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from '../../services/registration.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ClientHeaderComponent } from "../../components/client-header/client-header.component"; // <-- Import here
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, ClientHeaderComponent], // <-- Add here
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private regService: RegistrationService,private router: Router) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required]],
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['CLIENT', [Validators.required]]
    });
  }

  async onSubmit() {
    if (this.registerForm.valid) {
      const formData = this.registerForm.value;
      try {
        const response = await this.regService.registerUser(formData);
        console.log('Registration Success:', response);
        alert('Registration successful!');
        this.registerForm.reset();
        this.router.navigate(['/login']);
      } catch (error) {
        console.error('Registration Failed:', error);
        alert('Registration failed. Please try again.');
      }
    } else {
      this.registerForm.markAllAsTouched();
    }
  }
}
