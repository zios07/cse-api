package com.cse.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PropertyImage {

	@Id @GeneratedValue
	private Long id;
	
	private byte[] content;

	private Date creationDate;
	
	private Date updateDate;
	
	private Date activeDate;
	
	private Date inactiveDate;
	
	@ManyToOne
	private User author;

	public PropertyImage() {
		super();
	}

	public PropertyImage(byte[] content, Date creationDate, Date updateDate, Date activeDate,
			Date inactiveDate, User author) {
		super();
		this.content = content;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.activeDate = activeDate;
		this.inactiveDate = inactiveDate;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
}
