package com.skilldistillery.flighttracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.flighttracker.entities.Flight;
import com.skilldistillery.flighttracker.services.FlightService;

@RequestMapping("api")
@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightServ;
	
	@GetMapping("flights")
	public List<Flight> getAllFlights() {
		return flightServ.getAllFlights();
	}
	
	@RequestMapping(path = "flights/{id}", method =  RequestMethod.GET)
	public Flight getFlight(@PathVariable int id, HttpServletResponse resp) {
		Flight flight = flightServ.findById(id);
		if (flight == null) {
			resp.setStatus(404);
		}
		return flight;
	}
	
	@PostMapping("flights")
	public Flight createFlight(@RequestBody Flight flight, HttpServletResponse resp) {
		Flight created = null;
		
		try {
			created = flightServ.createFlight(flight);
			resp.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return created;
	}
	@PutMapping("flights/{id}")
	public Flight updateFlight(@RequestBody Flight flight, @PathVariable int id, HttpServletResponse resp) {
		Flight updated = null;
		
		try {
			updated = flightServ.updateFlight(flight, id);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return updated;
	}
	
	@DeleteMapping("flights/{id}")
	public Boolean deleteFlight(@PathVariable int id, HttpServletResponse resp) {
		Boolean deleted = false;
		try {
			deleted = flightServ.deleteFlight(id);
			if(deleted) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			resp.setStatus(500);
		}
		return deleted;
	}

}
