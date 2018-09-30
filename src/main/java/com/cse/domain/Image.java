	package com.cse.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_IMAGE")
public class Image {

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] content;
	
	private String entityName;

	private Date creationDate;

	private Date updateDate;

	private Date activeDate;

	private Date inactiveDate;

	@ManyToOne
	private User author;

	public Image() {
		super();
	}

	public Image(byte[] content, String entityName, Date creationDate, Date updateDate, Date activeDate,
			Date inactiveDate, User author) {
		super();
		this.content = content;
		this.entityName = entityName;
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
