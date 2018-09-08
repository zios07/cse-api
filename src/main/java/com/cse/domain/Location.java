package com.cse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCATION")
public class Location {

	@Id
	@GeneratedValue
	private long id;

	private String code;

	private String name;
	
	private byte[] pictureOfArea;

	public Location() {

	}

	public Location(long id, String code, String name, byte[] pictureOfArea) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.pictureOfArea = pictureOfArea;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPictureOfArea() {
		return pictureOfArea;
	}

	public void setPictureOfArea(byte[] pictureOfArea) {
		this.pictureOfArea = pictureOfArea;
	}

}
