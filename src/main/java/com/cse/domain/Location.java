package com.cse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_LOCATION")
public class Location {

	@Id
	@GeneratedValue
	private long id;

	private String code;

	private String name;

	@Transient
	private Gallery gallery;

	private boolean main;

	private String uuid;

	public Location() {

	}

	public Location(String code, String name, Gallery gallery, boolean main, String uuid) {
		super();
		this.code = code;
		this.name = name;
		this.gallery = gallery;
		this.main = main;
		this.uuid = uuid;
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

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
