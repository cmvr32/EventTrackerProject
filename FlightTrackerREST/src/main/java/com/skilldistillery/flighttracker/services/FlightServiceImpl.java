package com.skilldistillery.flighttracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;
	
	@Override
	public List<Flight> index() {
		return flightRepo.findAll();
	}

}
