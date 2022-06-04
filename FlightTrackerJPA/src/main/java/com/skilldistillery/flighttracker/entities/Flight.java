package com.skilldistillery.flighttracker.entities;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	private String date;
	
	@Column(name = "duration_in_hours")
	private double durationInHours;
	
	
	private String mission;
	
	@Column(name = "pc_crew_member_id")
	private int pcId;
	
	@Column(name = "pi_crew_member_id")
	private int piId;
	
	@Column(name = "ce_crew_member_id")
	private int ceId;
	
	@Column(name = "me_crew_member_id")
	private int meId;

	
	public Flight() {
		super();
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public double getDurationInHours() {
		return durationInHours;
	}



	public void setDurationInHours(double durationInHours) {
		this.durationInHours = durationInHours;
	}



	public String getMission() {
		return mission;
	}



	public void setMission(String mission) {
		this.mission = mission;
	}



	public int getPcId() {
		return pcId;
	}



	public void setPcId(int pcId) {
		this.pcId = pcId;
	}



	public int getPiId() {
		return piId;
	}



	public void setPiId(int piId) {
		this.piId = piId;
	}



	public int getCeId() {
		return ceId;
	}



	public void setCeId(int ceId) {
		this.ceId = ceId;
	}



	public int getMeId() {
		return meId;
	}



	public void setMeId(int meId) {
		this.meId = meId;
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
		Flight other = (Flight) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Flight [id=" + id + ", location=" + location + ", date=" + date + ", durationInHours=" + durationInHours
				+ ", mission=" + mission + ", pcId=" + pcId + ", piId=" + piId + ", ceId=" + ceId + ", meId=" + meId
				+ "]";
	}


	

}
