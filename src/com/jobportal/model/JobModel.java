package com.jobportal.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jobportal.entity.Job;

public class JobModel {
	private String frmJobId;
	private String frmJobTitle;
	private String frmJobCategory;
	private String frmGender;
	private String frmAge;
	private String frmJobRole;
	private String frmSkillsRequired;
	private String frmJobQualification;
	private String frmJobExperience;
	private String frmJobPost;
	private String frmExpectedSalary;
	private String frmJobLocation;
	private String frmJobPostDate;
	private String frmJobOpenDate;
	private String frmJobCloseDate;
	private String frmDescription;
	private String frmRecruiterId;
	private String frmCatId;
	private Job job;
	private List<Job> jobList;
	public String getFrmCatId() {
		return frmCatId;
	}
	public void setFrmCatId(String frmCatId) {
		this.frmCatId = frmCatId;
	}
	
	public String getFrmRecruiterId() {
		return frmRecruiterId;
	}
	public void setFrmRecruiterId(String frmRecruiterId) {
		this.frmRecruiterId = frmRecruiterId;
	}
	
	public String getFrmJobTitle() {
		return frmJobTitle;
	}
	public void setFrmJobTitle(String frmJobTitle) {
		this.frmJobTitle = frmJobTitle;
	}
	public String getFrmJobCategory() {
		return frmJobCategory;
	}
	public void setFrmJobCategory(String frmJobCategory) {
		this.frmJobCategory = frmJobCategory;
	}
	public String getFrmGender() {
		return frmGender;
	}
	public void setFrmGender(String frmGender) {
		this.frmGender = frmGender;
	}
	public String getFrmAge() {
		return frmAge;
	}
	public void setFrmAge(String frmAge) {
		this.frmAge = frmAge;
	}
	public String getFrmJobRole() {
		return frmJobRole;
	}
	public void setFrmJobRole(String frmJobRole) {
		this.frmJobRole = frmJobRole;
	}
	public String getFrmSkillsRequired() {
		return frmSkillsRequired;
	}
	public void setFrmSkillsRequired(String frmSkillsRequired) {
		this.frmSkillsRequired = frmSkillsRequired;
	}
	public String getFrmJobQualification() {
		return frmJobQualification;
	}
	public void setFrmJobQualification(String frmJobQualification) {
		this.frmJobQualification = frmJobQualification;
	}
	public String getFrmJobExperience() {
		return frmJobExperience;
	}
	public void setFrmJobExperience(String frmJobExperience) {
		this.frmJobExperience = frmJobExperience;
	}
	public String getFrmJobPost() {
		return frmJobPost;
	}
	public void setFrmJobPost(String frmJobPost) {
		this.frmJobPost = frmJobPost;
	}
	public String getFrmExpectedSalary() {
		return frmExpectedSalary;
	}
	public void setFrmExpectedSalary(String frmExpectedSalary) {
		this.frmExpectedSalary = frmExpectedSalary;
	}
	public String getFrmJobLocation() {
		return frmJobLocation;
	}
	public void setFrmJobLocation(String frmJobLocation) {
		this.frmJobLocation = frmJobLocation;
	}
	public String getFrmJobPostDate() {
		return frmJobPostDate;
	}
	public String getFrmDescription() {
		return frmDescription;
	}
	public void setFrmDescription(String frmDescription) {
		this.frmDescription = frmDescription;
	}
	public void setFrmJobPostDate(String frmJobPostDate) {
		this.frmJobPostDate = frmJobPostDate;
	}
	public String getFrmJobCloseDate() {
		return frmJobCloseDate;
	}
	public void setFrmJobCloseDate(String frmJobCloseDate) {
		this.frmJobCloseDate = frmJobCloseDate;
	}
	
	public String getFrmJobOpenDate() {
		return frmJobOpenDate;
	}
	public void setFrmJobOpenDate(String frmJobOpenDate) {
		this.frmJobOpenDate = frmJobOpenDate;
	}
	public List<Job> getJobList() {
		return jobList;
	}
	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}
	public String getFrmJobId() {
		return frmJobId;
	}
	public void setFrmJobId(String frmJobId) {
		this.frmJobId = frmJobId;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
}
