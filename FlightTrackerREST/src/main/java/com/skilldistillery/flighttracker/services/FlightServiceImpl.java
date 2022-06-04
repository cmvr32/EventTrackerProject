package com.skilldistillery.flighttracker.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	
	@Override
	public List<Flight> getAllFlights() {
		return flightRepo.findAll();
	}

	@Override
	public Flight findById(int flightId) {
		Optional<Flight> op = flightRepo.findById(flightId);
		if(op.isPresent()) {
			Flight flight = op.get();
			return flight;
		}
		return null;
	}
	
	@Override
	public Flight createFlight(Flight flight) {
		
		Flight newFlight = new Flight();
		newFlight.setLocation(flight.getLocation());
		newFlight.setDate(flight.getDate());
		newFlight.setDurationInHours(flight.getDurationInHours());
		newFlight.setMission(flight.getMission());
		newFlight.setPcId(flight.getPcId());
		newFlight.setPiId(flight.getPiId());
		newFlight.setCeId(flight.getCeId());
		newFlight.setMeId(flight.getMeId());
	
		return flightRepo.saveAndFlush(flight);
	}

	@Override
	public Flight updateFlight(Flight flight, int flightId) {
		Flight existing = findById(flightId);
		existing.setLocation(flight.getLocation());
		existing.setDate(flight.getDate());
		existing.setDurationInHours(flight.getDurationInHours());
		existing.setMission(flight.getMission());
		existing.setPcId(flight.getPcId());
		existing.setPiId(flight.getPiId());
		existing.setCeId(flight.getCeId());
		existing.setMeId(flight.getMeId());
		return flightRepo.save(existing);
	}

	@Override
	public Boolean deleteFlight(int flightId) {
		flightRepo.deleteById(flightId);
		return !flightRepo.existsById(flightId);
	}

}
