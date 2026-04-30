package com.jobportal.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="job_seeker_profile")
public class JobSeeker{
	@Id
	@Column(name="jobseeker_id")
	private String jobSeekerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	private int postalCode;
	
	@Column(name="status")
	private String status;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "jobSeeker",cascade = CascadeType.ALL)
	private Set<SeekerCategoryJoin> seekerCategoryJoin=new HashSet<SeekerCategoryJoin>(0);

	@OneToMany(mappedBy="jobSeeker",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<JobSeekerWorkExp> jobSeekerWorkExp;
	
	@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<JobSeekerEducation> jobSeekerEducation;
	
	@OneToMany(mappedBy="jobSeeker",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Application> application;
	
	public JobSeeker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobSeeker(String jobSeekerId, String name, String email, String phone, String skills, String gender,
			Date dob, String address, String state, int postalCode, Set<SeekerCategoryJoin> seekerCategoryJoin,
			Set<JobSeekerWorkExp> jobSeekerWorkExp, Set<JobSeekerEducation> jobSeekerEducation,
			Set<Application> application) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.state = state;
		this.postalCode = postalCode;
		this.seekerCategoryJoin = seekerCategoryJoin;
		this.jobSeekerWorkExp = jobSeekerWorkExp;
		this.jobSeekerEducation = jobSeekerEducation;
		this.application = application;
	}

	public JobSeeker(String jobSeekerId, String name, String email, String phone, String skills, String gender,
			Date dob, String address, String state, int postalCode, Set<SeekerCategoryJoin> seekerCategoryJoin,
			Set<JobSeekerWorkExp> jobSeekerWorkExp, Set<JobSeekerEducation> jobSeekerEducation) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.state = state;
		this.postalCode = postalCode;
		this.seekerCategoryJoin = seekerCategoryJoin;
		this.jobSeekerWorkExp = jobSeekerWorkExp;
		this.jobSeekerEducation = jobSeekerEducation;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public Set<SeekerCategoryJoin> getSeekerCategoryJoin() {
		return seekerCategoryJoin;
	}

	public void setSeekerCategoryJoin(Set<SeekerCategoryJoin> seekerCategoryJoin) {
		this.seekerCategoryJoin = seekerCategoryJoin;
	}

	public Set<JobSeekerWorkExp> getJobSeekerWorkExp() {
		return jobSeekerWorkExp;
	}

	public void setJobSeekerWorkExp(Set<JobSeekerWorkExp> jobSeekerWorkExp) {
		this.jobSeekerWorkExp = jobSeekerWorkExp;
	}

	public Set<JobSeekerEducation> getJobSeekerEducation() {
		return jobSeekerEducation;
	}

	public void setJobSeekerEducation(Set<JobSeekerEducation> jobSeekerEducation) {
		this.jobSeekerEducation = jobSeekerEducation;
	}

	public Set<Application> getApplication() {
		return application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}

	
	
}
