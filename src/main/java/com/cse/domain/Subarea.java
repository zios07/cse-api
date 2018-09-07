package com.cse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SUBAREA")
public class Subarea {

	@Id
	@GeneratedValue
	private long id;

	private String label;

	private double latitude;

	private double longitude;

	@OneToOne
	private Location location;

	public Subarea() {

	}

	public Subarea(String label, double latitude, double longitude, Location location) {
		super();
		this.label = label;
		this.latitude = latitude;
		this.longitude = longitude;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
