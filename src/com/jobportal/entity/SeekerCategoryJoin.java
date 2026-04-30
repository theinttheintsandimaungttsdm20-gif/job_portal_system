package com.jobportal.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="seeker_category_join")
public class SeekerCategoryJoin{
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "jobSeekerId", column = @Column(name = "jobseeker_id", nullable = false)),
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)) })
	private SeekerCategoryJoinId seekerCategoryJoinId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	private JobCategory jobCategory;
	
	@MapsId(value="jobseeker_id")
	@ManyToOne(cascade=CascadeType.ALL)
	//@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "jobseeker_id", nullable = false, insertable = false, updatable = false)
	private JobSeeker jobSeeker;
	
	@Column(name="jobseeker_id", nullable = false, insertable = false, updatable = false)
	private String jobSeekerId;
	
	
	public SeekerCategoryJoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeekerCategoryJoin(SeekerCategoryJoinId seekerCategoryJoinId, JobCategory jobCategory, JobSeeker jobSeeker,
			String jobSeekerId) {
		super();
		this.seekerCategoryJoinId = seekerCategoryJoinId;
		this.jobCategory = jobCategory;
		this.jobSeeker = jobSeeker;
		this.jobSeekerId = jobSeekerId;
	}
	public SeekerCategoryJoin(SeekerCategoryJoinId seekerCategoryJoinId, JobCategory jobCategory, JobSeeker jobSeeker) {
		super();
		this.seekerCategoryJoinId = seekerCategoryJoinId;
		this.jobCategory = jobCategory;
		this.jobSeeker = jobSeeker;
	}

	public SeekerCategoryJoinId getSeekerCategoryJoinId() {
		return seekerCategoryJoinId;
	}
	public void setSeekerCategoryJoinId(SeekerCategoryJoinId seekerCategoryJoinId) {
		this.seekerCategoryJoinId = seekerCategoryJoinId;
	}
	public JobCategory getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	public String getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	
	
	
}
