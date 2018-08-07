package com.cse.domain.dto;

import com.cse.domain.Location;
import com.cse.domain.Subarea;
import com.cse.domain.Type;

public class PropertySearchDto {
	
	private Location location;
	
	private Subarea subarea;
	
	private Type type;
	
	private int nbBedrooms;
	
	private int nbBathrooms;
	
	private int minPrice;
	
	private int maxPrice;
	
	private String ref;

	public PropertySearchDto() {
		super();
	}

	public PropertySearchDto(Location location, Subarea subarea, Type type, int nbBedrooms, int nbBathrooms,
			int minPrice, int maxPrice, String ref) {
		super();
		this.location = location;
		this.subarea = subarea;
		this.type = type;
		this.nbBedrooms = nbBedrooms;
		this.nbBathrooms = nbBathrooms;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.ref = ref;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Subarea getSubarea() {
		return subarea;
	}

	public void setSubarea(Subarea subarea) {
		this.subarea = subarea;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
	
}
