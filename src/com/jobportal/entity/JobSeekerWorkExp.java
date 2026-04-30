package com.jobportal.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="job_seeker_work_exp")
public class JobSeekerWorkExp{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_id")
	private int expId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name="duration")
	private String duration;

	@Column(name="jobseeker_id")
	private String jobSeekerId;
	
	@MapsId(value="jobseeker_id")
	@ManyToOne
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSeeker;

	public JobSeekerWorkExp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JobSeekerWorkExp(int expId, String companyName, String role, Date startDate, Date endDate, String duration,
			String jobSeekerId, JobSeeker jobSeeker) {
		super();
		this.expId = expId;
		this.companyName = companyName;
		this.role = role;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.jobSeekerId = jobSeekerId;
		this.jobSeeker = jobSeeker;
	}
	
	public JobSeekerWorkExp(int expId, String companyName, String role, Date startDate, Date endDate,
			String jobSeekerId, JobSeeker jobSeeker) {
		super();
		this.expId = expId;
		this.companyName = companyName;
		this.role = role;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobSeekerId = jobSeekerId;
		this.jobSeeker = jobSeeker;
	}

	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	


}
