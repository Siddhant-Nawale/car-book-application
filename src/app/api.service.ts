import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cab } from './entity/Cab';
import { Booking } from './entity/Booking';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private API_URL = environment.API_URL;

  constructor(private http: HttpClient) { }

  fetchAllCabs(): Observable<Cab[]> {
    return this.http.get<Cab[]>(`${this.API_URL}/cab/cabs`);
  }

  fetchBookedCabs(): Observable<Cab[]> {
    return this.http.get<Cab[]>(`${this.API_URL}/cab/booked`);
  }
  fetchAvailableCabs(): Observable<Cab[]> {
    return this.http.get<Cab[]>(`${this.API_URL}/cab/available`);
  }

  fetchCab(cabNo: number): Observable<Cab> {
    return this.http.get<Cab>(`${this.API_URL}/cab/${cabNo}`);
  }

  fetchCabsWithPlace(placeName: string): Observable<Cab[]> {
    return this.http.get<Cab[]>(`${this.API_URL}/cab/place/${placeName}`);
  }

  deleteCabWithId(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/cab/${id}`);
  }

  updateCab(cab: Cab): Observable<Cab> {
    return this.http.put<Cab>(`${this.API_URL}/cab`, cab);
  }

  bookCab(cabNo: number, numOfSeats: number, EmployeeNumbers:number[]): Observable<Booking> {
    return this.http.post<Booking>(`${this.API_URL}/cab/book/${cabNo}/${numOfSeats}`, {"empNos":EmployeeNumbers});
  }

  addCab(cab: Cab): Observable<Cab> {
    return this.http.post<Cab>(`${this.API_URL}/cab`, cab);
  }
}
