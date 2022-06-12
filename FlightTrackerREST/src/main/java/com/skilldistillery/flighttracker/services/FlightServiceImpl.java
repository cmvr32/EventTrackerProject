package com.skilldistillery.flighttracker.services;

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
		newFlight.setAcftNumber(flight.getAcftNumber());
		newFlight.setFlightType(flight.getFlightType());
		newFlight.setMissionType(flight.getMissionType());
		newFlight.setDayInHours(flight.getDayInHours());
		newFlight.setNightInHours(flight.getNightInHours());
		newFlight.setNightVisionGoggles(flight.getNightVisionGoggles());
		newFlight.setDurationInHours(flight.getDurationInHours());
		newFlight.setPcId(flight.getPcId());
		newFlight.setPiId(flight.getPiId());
		newFlight.setCeId(flight.getCeId());
		newFlight.setMoId(flight.getMoId());
		newFlight.setFiId(flight.getFiId());
	
		return flightRepo.saveAndFlush(flight);
	}

	@Override
	public Flight updateFlight(Flight flight, int flightId) {
		Flight existing = findById(flightId);
		existing.setLocation(flight.getLocation());
		existing.setDate(flight.getDate());
		existing.setAcftNumber(flight.getAcftNumber());
		existing.setFlightType(flight.getFlightType());
		existing.setMissionType(flight.getMissionType());
		existing.setDayInHours(flight.getDayInHours());
		existing.setNightInHours(flight.getNightInHours());
		existing.setNightVisionGoggles(flight.getNightVisionGoggles());
		existing.setDurationInHours(flight.getDurationInHours());
		existing.setPcId(flight.getPcId());
		existing.setPiId(flight.getPiId());
		existing.setCeId(flight.getCeId());
		existing.setMoId(flight.getMoId());
		existing.setFiId(flight.getFiId());
		return flightRepo.save(existing);
	}

	@Override
	public Boolean deleteFlight(int flightId) {
		flightRepo.deleteById(flightId);
		return !flightRepo.existsById(flightId);
	}

}
