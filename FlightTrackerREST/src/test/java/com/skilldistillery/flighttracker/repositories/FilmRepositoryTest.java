package com.skilldistillery.flighttracker.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.flighttracker.entities.Flight;

@SpringBootTest
class FilmRepositoryTest {

@Autowired
private FlightRepository flightRepo;
//
//@Autowired
//private Flight Service flightServ;
//
//@Test
//void test_find_flight_by_id() {
//	List<Flight> flights = flightRepo.findById(id);
//	assertEquals(1, flights.get(0).getId());
//	
//	
}
//	List<Film> films = repo.findByTitle("ACADEMY DINOSAUR");
//	assertEquals(1, films.get(0).getId());
//	films = repo.findByTitle("iugiuyg");
//	assertEquals(0, films.size());
//
//}

