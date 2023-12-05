import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { chamber } from '../models/chambre';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private baseUrl = 'http://localhost:8089/foyerProject/reservation'

  constructor(private http: HttpClient) { }


  getAllReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.baseUrl}/get`);
  }

  getReservations(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.baseUrl}/get/${id}`);
  }

  deleteReservation(id: number): Observable<void> {
    const url = `${this.baseUrl}/delete/${id}`;
    return this.http.delete<void>(url);
  }

  getChambre(idReservaion: number): Observable<chamber> {
    return this.http.get<chamber>(`${this.baseUrl}/findByReservation/${idReservaion}`);
  }

  updateState(reservation: Reservation, state: string): Observable<Reservation> {
    return this.http.put<Reservation>(`${this.baseUrl}/updateState/${state}`, reservation);
  }

  getNumberEtudiantForChambre(idReservaion: number): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/findNumberEtudiantInCHambre/${idReservaion}`);
  }

}
