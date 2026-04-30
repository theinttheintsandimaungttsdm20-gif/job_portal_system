package com.jobportal.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="application")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="application_id")
	private int applicationId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="resume")
	private String resume;
	
	@Column(name="date_applied")
	@Temporal(TemporalType.DATE)
	private Date dateApplied;
	
	@Column(name="cv_form")
	private byte[] cvForm;
	
	@Column(name="content_type")
	private String contentType;

	@Column(name="file_name")
	private String fileName;
	
	@MapsId(value="jobseeker_id")
	@ManyToOne
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name="jobseeker_id")
	private String jobSeekerId;
	
	@MapsId(value="job_id")
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	
	@Column(name="job_id")
	private int jobId;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="application",cascade=CascadeType.ALL)
	private Selection selection;
	
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(int applicationId, String status, String resume, Date dateApplied, byte[] cvForm,
			String contentType, String fileName, JobSeeker jobSeeker, Job job, int jobId,
			String jobSeekerId, Selection selection) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.resume = resume;
		this.dateApplied = dateApplied;
		this.cvForm = cvForm;
		this.contentType = contentType;
		this.fileName = fileName;
		this.jobSeeker = jobSeeker;
		this.job = job;
		this.jobId = jobId;
		this.jobSeekerId = jobSeekerId;
		this.selection = selection;
	}

	public Application(int applicationId, String status, String resume, Date dateApplied, byte[] cvForm,
			String contentType, String fileName, JobSeeker jobSeeker,Job job, int jobId,
			Selection selection) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.resume = resume;
		this.dateApplied = dateApplied;
		this.cvForm = cvForm;
		this.contentType = contentType;
		this.fileName = fileName;
		this.jobSeeker = jobSeeker;
		this.job = job;
		this.jobId = jobId;
		this.selection = selection;
	}

	public Application(int applicationId, String status, String resume, Date dateApplied, byte[] cvForm,
			String contentType, String fileName, JobSeeker jobSeeker, Job job) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.resume = resume;
		this.dateApplied = dateApplied;
		this.cvForm = cvForm;
		this.contentType = contentType;
		this.fileName = fileName;
		this.jobSeeker = jobSeeker;
		this.job = job;
	}


	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public byte[] getCvForm() {
		return cvForm;
	}

	public void setCvForm(byte[] cvForm) {
		this.cvForm = cvForm;
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

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public Application(int applicationId, String status, String resume, Date dateApplied, byte[] cvForm,
			String contentType, String fileName, JobSeeker jobSeeker, Job job, int jobId) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.resume = resume;
		this.dateApplied = dateApplied;
		this.cvForm = cvForm;
		this.contentType = contentType;
		this.fileName = fileName;
		this.jobSeeker = jobSeeker;
		this.job = job;
		this.jobId = jobId;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
}
