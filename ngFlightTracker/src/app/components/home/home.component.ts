import { FlightsService } from './../../services/flights.service';
import { Component, OnInit } from '@angular/core';
import { Flight } from 'src/app/models/flight';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

})
export class HomeComponent implements OnInit {

  flightList: Flight[] = [];
  selected: Flight | null = null;
  newFlight: Flight | null = new Flight();
  editFlight: Flight | null = null;

  constructor(
    private flightSvc: FlightsService
  ) { }

  ngOnInit(): void {

  }


  }


