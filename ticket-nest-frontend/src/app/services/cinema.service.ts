// cinema.service.ts
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root',
})
export class CinemaService {

  constructor(private http: HttpClient) {}

  getCinemasByMovie(movieId: number): Observable<any[]> {
    const params = new HttpParams().set('movieId', movieId.toString());
    return this.http.get<any[]>(`${environment.apiBaseUrl}/cinema-service/api/cinemas/by-movie`, { params });
  }
}
