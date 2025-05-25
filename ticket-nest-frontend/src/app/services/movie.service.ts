import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseUrl = 'http://localhost:8081/movie-service/api';

  constructor(private http: HttpClient) { }

  // Get JWT token from session storage
  private getAuthToken(): string | null {
    return sessionStorage.getItem('authToken');
  }

  // Set Authorization header
  private getHeaders(): HttpHeaders {
    const token = this.getAuthToken();
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': token ? `Bearer ${token}` : ''
    });
  }

  // Get all movies
  getAllMovies(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/movies`, { headers: this.getHeaders() });
  }

  // Get movie by ID
  getMovieById(movieId: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/movies/${movieId}`, { headers: this.getHeaders() });
  }
}