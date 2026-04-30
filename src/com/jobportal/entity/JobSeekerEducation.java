package com.jobportal.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_education")
public class JobSeekerEducation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;
	
	@Column(name="institution_attended")
	private String institutionAttended;
	
	@Column(name="completion_date")
	private String completionDate;
	
	@Column(name="certification")
	private String certification;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="certification_file", nullable=false)
	private byte[] certificationFile;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker jobSeeker;

	@Column(name="content_type")
	private String contentType;
	
	@Column(name="file_name")
	private String fileName;
	
	public JobSeekerEducation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobSeekerEducation(int educationId, String institutionAttended, String completionDate, String certification,
			byte[] certificationFile, JobSeeker jobSeeker, String contentType, String fileName) {
		super();
		this.educationId = educationId;
		this.institutionAttended = institutionAttended;
		this.completionDate = completionDate;
		this.certification = certification;
		this.certificationFile = certificationFile;
		this.jobSeeker = jobSeeker;
		this.contentType = contentType;
		this.fileName = fileName;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getInstitutionAttended() {
		return institutionAttended;
	}

	public void setInstitutionAttended(String institutionAttended) {
		this.institutionAttended = institutionAttended;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public byte[] getCertificationFile() {
		return certificationFile;
	}

	public void setCertificationFile(byte[] certificationFile) {
		this.certificationFile = certificationFile;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



}
