package com.skilldistillery.flighttracker.services;

import java.util.List;

import com.skilldistillery.flighttracker.entities.Flight;



public interface FlightService {
	List<Flight> getAllFlights();
	Flight findById(int flightId);
	Flight createFlight(Flight flight);
	Flight updateFlight(Flight flight, int flightId);
	Boolean deleteFlight(int flightId);
}
