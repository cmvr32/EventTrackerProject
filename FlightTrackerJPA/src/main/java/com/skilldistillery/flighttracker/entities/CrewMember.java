package com.skilldistillery.flighttracker.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CrewMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String rank;
	
	@Column(name = "flight_crew_position")
	private String flightCrewPosition;

	
//	@OneToMany(mappedBy = "crew_member")
//	private List<Flight> crewMemberFlights;
	
	
	
	public CrewMember() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getFlightCrewPosition() {
		return flightCrewPosition;
	}

	public void setFlightCrewPosition(String flightCrewPosition) {
		this.flightCrewPosition = flightCrewPosition;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrewMember other = (CrewMember) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "CrewMember [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rank=" + rank
				+ ", flightCrewPosition=" + flightCrewPosition + "]";
	}
	
	
}
