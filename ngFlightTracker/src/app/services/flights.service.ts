import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Flight } from '../models/flight';

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  private url = environment.baseUrl + 'api/flights';

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Flight[]>{
    return this.http.get<Flight[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('FlightService.index(): error retrieving flight: ' + err)
        );
      })
    );
  }

  show(id: number): Observable<Flight> {
    return this.http.get<Flight>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('FlightService.index(): error retrieving flight: ' + err)
        );
      })
    );
  }

  generateId(): void {

  }

  create(todo: Flight): Observable<Flight> {
    return this.http.post<Flight>(this.url, todo).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('FlightService.create(): error creating flight: ' + err)
        );
      })
    );
  }

  update(id: number, flight: Flight): Observable<Flight> {
    // if(flight.completed){
    //   flight.completeDate = this.datePipe.transform(Date.now(), 'shortDate');
    // } else {
    //   flight.completeDate = "";
    // }
    return this.http.put<Flight>(this.url + '/' + id, flight).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'FlightService.update(): error updating Toedo: ' + err
          )
        );
      })
    )


  }

  destroy(id: number) {
  return this.http.delete<void>(`${this.url}/${id}`).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error ('FlightService.delete(); error deleteing tosdo: ' + err)
      );
    })
  );
}
}
