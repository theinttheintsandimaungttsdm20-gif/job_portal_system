package com.jobportal.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recruiter")
public class Recruiter {
	@Id
	@Column(name="recruiter_id")
	private String recruiterId;
	
	@Column(name="recruiter_name")
	private String recruiterName;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_license")
	private String companyLicense;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	private int postalCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(mappedBy="recruiter",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Job> jobs;
	

	public Recruiter(String recruiterId, String recruiterName, String companyName, String companyLicense, String email,
			String address, String state, int postalCode, String description) {
		super();
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.companyName = companyName;
		this.companyLicense = companyLicense;
		this.email = email;
		this.address = address;
		this.state = state;
		this.postalCode = postalCode;
		this.description = description;
	}

	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}


	public Recruiter(String recruiterId, String recruiterName, String companyName, String companyLicense, String email,
			String address, String state, int postalCode, String description, String status, Set<Job> jobs) {
		super();
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.companyName = companyName;
		this.companyLicense = companyLicense;
		this.email = email;
		this.address = address;
		this.state = state;
		this.postalCode = postalCode;
		this.description = description;
		this.status = status;
		this.jobs = jobs;
	}

	public String getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLicense() {
		return companyLicense;
	}

	public void setCompanyLicense(String companyLicense) {
		this.companyLicense = companyLicense;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
