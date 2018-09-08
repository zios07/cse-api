package com.cse.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Gallery {
	
	private Long id;
	
	private List<PropertyImage> images;
	
	public Gallery() {
		
	}

	public Gallery(Long id, List<PropertyImage> images) {
		super();
		this.id = id;
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
