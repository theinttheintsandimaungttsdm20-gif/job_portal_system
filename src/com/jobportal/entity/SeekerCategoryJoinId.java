package com.jobportal.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Embeddable
public class SeekerCategoryJoinId implements java.io.Serializable{

	 @Column(name="jobseeker_id")
	 private String jobSeekerId;
	 
	
	 @Column(name="id")
	 private int id;

	public SeekerCategoryJoinId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeekerCategoryJoinId(String jobSeekerId, int id) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.id = id;
	}

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((jobSeekerId == null) ? 0 : jobSeekerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeekerCategoryJoinId other = (SeekerCategoryJoinId) obj;
		if (id != other.id)
			return false;
		if (jobSeekerId == null) {
			if (other.jobSeekerId != null)
				return false;
		} else if (!jobSeekerId.equals(other.jobSeekerId))
			return false;
		return true;
	}
}
