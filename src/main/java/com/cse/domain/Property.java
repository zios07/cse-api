package com.cse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	@GeneratedValue
	private long id;

	private String title;

	private String description;

	private Type type;

	private Location location;

	private int nbBedrooms;

	private int nbBathrooms;

	private double price;

	public Property() {
		super();
	}

	public Property(long id, String title, String description, Type type, Location location, int nbBedrooms,
			int nbBathrooms, double price) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.location = location;
		this.nbBedrooms = nbBedrooms;
		this.nbBathrooms = nbBathrooms;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getNbBedrooms() {
		return nbBedrooms;
	}

	public void setNbBedrooms(int nbBedrooms) {
		this.nbBedrooms = nbBedrooms;
	}

	public int getNbBathrooms() {
		return nbBathrooms;
	}

	public void setNbBathrooms(int nbBathrooms) {
		this.nbBathrooms = nbBathrooms;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
