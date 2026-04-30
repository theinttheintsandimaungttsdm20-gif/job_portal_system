package com.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="selection")
public class Selection {
	@GenericGenerator(
			name="appIdGen",strategy="foreign",
			parameters=@Parameter(
					name="property",value="application")
			)
	@Id
	@GeneratedValue(generator="appIdGen")
	@Column(name="application_id")
	private int selectionId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Application application;
	
	@Column(name="status")
	private String status;

	public Selection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Selection(int selectionId, Application application, String status) {
		super();
		this.selectionId = selectionId;
		this.application = application;
		this.status = status;
	}


	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public int getSelectionId() {
		return selectionId;
	}


	public void setSelectionId(int selectionId) {
		this.selectionId = selectionId;
	}
	

}
