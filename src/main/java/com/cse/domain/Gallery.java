package com.cse.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gallery {
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PropertyImage> images;
	
	public Gallery() {
		
	}

	public Gallery(List<PropertyImage> images) {
		super();
		this.images = images;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PropertyImage> getImages() {
		return images;
	}

	public void setImages(List<PropertyImage> images) {
		this.images = images;
	}

}
