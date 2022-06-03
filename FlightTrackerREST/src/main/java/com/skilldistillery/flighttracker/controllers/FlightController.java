package com.skilldistillery.flighttracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.services.FlightService;

@RequestMapping("api")
@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightServ;
	
	@GetMapping("flights")
public List<Flight> index() {
		return flightServ.index();
	}
}
