package com.jobportal.model;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;

public class FileBucket {

	MultipartFile file;
	
	String institutionAttended;
	
	String completionDate;
	
	String certification;
	
	String jobSeekerId;
	
	String contentType;
	
	String eduId;
	
	JobSeekerEducation jobSeekerEdu;
	
	private List<JobSeekerEducation> eduList;
	
	
	public List<JobSeekerEducation> getEduList() {
		return eduList;
	}

	public void setEduList(List<JobSeekerEducation> eduList) {
		this.eduList = eduList;
	}

	public String getInstitutionAttended() {
		return institutionAttended;
	}

	public void setInstitutionAttended(String institutionAttended) {
		this.institutionAttended = institutionAttended;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescription() {
		return certification;
	}

	public void setDescription(String certification) {
		this.certification = certification;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public JobSeekerEducation getJobSeekerEdu() {
		return jobSeekerEdu;
	}

	public void setJobSeekerEdu(JobSeekerEducation jobSeekerEdu) {
		this.jobSeekerEdu = jobSeekerEdu;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEduId() {
		return eduId;
	}

	public void setEduId(String eduId) {
		this.eduId = eduId;
	}

	
}