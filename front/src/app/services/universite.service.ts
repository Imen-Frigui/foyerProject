import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Observable  } from 'rxjs';
import { Universite } from '../models/universite.model';

@Injectable({
  providedIn: 'root'
})
export class UniversiteService {
  private baseUrl = 'http://localhost:8089/foyerProject/universite'

  constructor(private htpp: HttpClient) { }


  getAllUniversities(): Observable<Universite[]> {
    return this.htpp.get<Universite[]>(`${this.baseUrl}/get`);
  }


}
