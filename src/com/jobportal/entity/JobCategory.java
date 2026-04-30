package com.jobportal.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="job_category")
public class JobCategory{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "jobCategory")
	private Set<SeekerCategoryJoin> seekerCategoryJoin=new HashSet<SeekerCategoryJoin>(0);

	@OneToMany(mappedBy="jobCategory",fetch=FetchType.EAGER)
	private Set<Job> jobs;
	
	public JobCategory(int id, String jobTitle) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
	}

	public JobCategory(int id, String jobTitle, Set<SeekerCategoryJoin> seekerCategoryJoin) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.seekerCategoryJoin = seekerCategoryJoin;
	}

	public JobCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public Set<SeekerCategoryJoin> getSeekerCategoryJoin() {
		return seekerCategoryJoin;
	}

	public void setSeekerCategoryJoin(Set<SeekerCategoryJoin> seekerCategoryJoin) {
		this.seekerCategoryJoin = seekerCategoryJoin;
	}



}
