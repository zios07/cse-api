package com.cse.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_PROPERTY")
public class Property {

	@Id
	@GeneratedValue
	private Long id;

	private String ref;
	
	private String uuid;

	private String title;

	private String description;
	
	private Date creationDate;
	
	private Date updateDate;
	
	private Date activeDate;
	
	private Date inactiveDate;
	
	private double surface;
	
	private boolean main;

	@Transient
	private Gallery gallery;
	
	@ManyToOne
	private User author;
	
	@ManyToOne
	private User updatedBy;
	
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


	public Property(String ref, String uuid, String title, String description, Date creationDate, Date updateDate,
			Date activeDate, Date inactiveDate, double surface, boolean main, Gallery gallery, User author,
			User updatedBy, Type type, Subarea subarea, int nbBedrooms, int nbBathrooms, double price) {
		super();
		this.ref = ref;
		this.uuid = uuid;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.activeDate = activeDate;
		this.inactiveDate = inactiveDate;
		this.surface = surface;
		this.main = main;
		this.gallery = gallery;
		this.author = author;
		this.updatedBy = updatedBy;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
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


	public boolean isMain() {
		return main;
	}


	public void setMain(boolean main) {
		this.main = main;
	}

}
