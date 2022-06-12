package com.skilldistillery.flighttracker.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	private String date;
	
	@Column(name="aircraft_number")
	private String acftNumber;
	
	@Column(name="flight_type")
	private String flightType;
	
	@Column(name="mission_type")
	private String missionType;
	
	@Column(name = "day_in_hours")
	private double dayInHours;
	
	@Column(name = "night_in_hours")
	private double nightInHours;
	
	@Column(name = "night_vision_goggles")
	private double nightVisionGoggles;
	
	@Column(name = "duration_in_hours")
	private double durationInHours;
	
	@Column(name = "pc_crew_member_id")
	private Integer pcId;
	
	@Column(name = "pi_crew_member_id")
	private Integer piId;
	
	@Column(name = "ce_crew_member_id")
	private Integer ceId;
	
	@Column(name = "mo_crew_member_id")
	private Integer moId;
	
	@Column(name = "fi_crew_member_id")
	private Integer fiId;
	
//	@ManyToOne
//	@JoinColumn(name="pc_crew_member_id")
//	private CrewMember pcCrewMember;
//	
//	@ManyToOne
//	@JoinColumn(name="pi_crew_member_id")
//	private CrewMember piCrewMember;
//	
//	@ManyToOne
//	@JoinColumn(name="ce_crew_member_id")
//	private CrewMember ceCrewMember;
//	
//	@ManyToOne
//	@JoinColumn(name="me_crew_member_id")
//	private CrewMember meCrewMember;

	
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



	public String getAcftNumber() {
		return acftNumber;
	}



	public void setAcftNumber(String acftNumber) {
		this.acftNumber = acftNumber;
	}



	public String getFlightType() {
		return flightType;
	}



	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}



	public String getMissionType() {
		return missionType;
	}



	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}



	public double getDayInHours() {
		return dayInHours;
	}



	public void setDayInHours(double dayInHours) {
		this.dayInHours = dayInHours;
	}



	public double getNightInHours() {
		return nightInHours;
	}



	public void setNightInHours(double nightInHours) {
		this.nightInHours = nightInHours;
	}



	public double getNightVisionGoggles() {
		return nightVisionGoggles;
	}



	public void setNightVisionGoggles(double nightVisionGoggles) {
		this.nightVisionGoggles = nightVisionGoggles;
	}



	public double getDurationInHours() {
		return durationInHours;
	}



	public void setDurationInHours(double durationInHours) {
		this.durationInHours = durationInHours;
	}



	public Integer getPcId() {
		return pcId;
	}



	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}



	public Integer getPiId() {
		return piId;
	}



	public void setPiId(Integer piId) {
		this.piId = piId;
	}



	public Integer getCeId() {
		return ceId;
	}



	public void setCeId(Integer ceId) {
		this.ceId = ceId;
	}



	public Integer getMoId() {
		return moId;
	}



	public void setMoId(Integer moId) {
		this.moId = moId;
	}



	public Integer getFiId() {
		return fiId;
	}



	public void setFiId(Integer fiId) {
		this.fiId = fiId;
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
		return "Flight [id=" + id + ", location=" + location + ", date=" + date + ", acftNumber=" + acftNumber
				+ ", flightType=" + flightType + ", missionType=" + missionType + ", dayInHours=" + dayInHours
				+ ", nightInHours=" + nightInHours + ", nightVisionGoggles=" + nightVisionGoggles + ", durationInHours="
				+ durationInHours + ", pcId=" + pcId + ", piId=" + piId + ", ceId=" + ceId + ", moId=" + moId
				+ ", fiId=" + fiId + "]";
	}

}
