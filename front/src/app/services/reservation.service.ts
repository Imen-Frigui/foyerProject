import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { chamber } from '../models/chambre';
import { universite } from '../models/universite';
import { foyer } from '../models/foyer';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private baseUrl = 'http://localhost:8089/foyerProject/reservation'

  constructor(private http: HttpClient) { }

  addReservation(reservation: Reservation, idChambre: number): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.baseUrl}/addReservationAndAssignToChambre/${idChambre}`, reservation);
  }

  getAllReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.baseUrl}/get`);
  }

  getReservation(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.baseUrl}/get/${id}`);
  }

  getReservationsByUser(id: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.baseUrl}/getReservationByetudiant/${id}`);
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

  getAlluniversities(): Observable<universite[]> {
    return this.http.get<universite[]>("http://localhost:8089/foyerProject/universite/get");
  }

  getfoyerbyuniversite(idUniversite: number): Observable<foyer> {
    return this.http.get<foyer>("http://localhost:8089/foyerProject/foyer/getbyUniversite/"+idUniversite);
  }

}
