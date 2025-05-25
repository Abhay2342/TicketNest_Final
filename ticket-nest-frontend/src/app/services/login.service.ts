import { firstValueFrom, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { LoginApiResponse } from '../models/login-response.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) {}

  loginUser(credentials: { username: string; password: string }): Promise<LoginApiResponse> {
    return firstValueFrom(
      this.http.post<LoginApiResponse>(`${environment.apiBaseUrl}/login-service/api/login`, credentials).pipe(
        catchError((error) => {
          return of({
            data: {
              message: error?.error?.message || 'Something went wrong',
              statusCode: error.status || 500
            }
          } as LoginApiResponse);
        })
      )
    );
  }
}
