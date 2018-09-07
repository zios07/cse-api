package com.cse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROPERTY")
public class Property {

	@Id
	@GeneratedValue
	private Long id;

	private String ref;

	private String title;

	private String description;

	@ManyToOne
	private Type type;

	@OneToOne
	private Subarea subarea;

	private int nbBedrooms;

	private int nbBathrooms;

	private double price;

	public Property() {
		super();
	}

	public Property(Long id, String ref, String title, String description, Type type, Subarea subarea, int nbBedrooms,
			int nbBathrooms, double price) {
		super();
		this.id = id;
		this.ref = ref;
		this.title = title;
		this.description = description;
		this.type = type;
		this.subarea = subarea;
		this.nbBedrooms = nbBedrooms;
		this.nbBathrooms = nbBathrooms;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
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

	public Subarea getSubarea() {
		return subarea;
	}

	public void setSubarea(Subarea subarea) {
		this.subarea = subarea;
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
