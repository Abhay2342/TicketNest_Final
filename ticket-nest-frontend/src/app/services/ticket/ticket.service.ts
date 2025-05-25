import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class TicketService {
  private baseUrl = 'http://localhost:8081/ticket-service/api/ticket';

  constructor(private http: HttpClient) {}

  bookTicket(payload: any) {
    return this.http.post('http://localhost:8081/ticket-service/api/ticket', payload);
  }

  getMyBookings(payload: any) {
    return this.http.post('http://localhost:8081/ticket-service/api/ticket', payload);
  }

  getTicketsByUserId(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/user/${userId}`);
  }

  cancelBooking(ticketId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/cancel/${ticketId}`);
  }

}

