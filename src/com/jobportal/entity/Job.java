package com.jobportal.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="job")
public class Job {
	@Id
	@Column(name="job_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobId;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_category")
	private String jobCategoryName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private String age;
	
	@Column(name="job_role")
	private String jobRole;
	
	@Column(name="skills_required")
	private String skillsRequired;
	
	@Column(name="job_qualification")
	private String jobQualification;
	
	@Column(name="job_experience")
	private int jobExperience;
	
	@Column(name="job_post")
	private int jobPost;
	
	@Column(name="salary")
	private int expectedSalary;
	
	@Column(name="job_location")
	private String jobLocation;
	
	@Column(name="job_post_date")
	@Temporal(TemporalType.DATE)
	private Date jobPostDate;
	
	@Column(name="job_open_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date jobOpenDate;
	
	
	@Column(name="job_close_date")
	@Temporal(TemporalType.DATE)
	private Date jobCloseDate;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="recruiter_id")
	private String recruiterId;

	@MapsId(value="recruiter_id")
	@ManyToOne
	@JoinColumn(name="recruiter_id")
	private Recruiter recruiter;
	
	@Column(name="id")
	private int catId;
	
	@MapsId(value="id")
	@ManyToOne
	@JoinColumn(name="id",nullable=false)
	private JobCategory jobCategory;

	@OneToMany(mappedBy="job",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Application> application;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Job(int jobId, String jobTitle, String jobCategoryName, String gender, String age, String jobRole,
			String skillsRequired, String jobQualification, int jobExperience, int jobPost, int expectedSalary,
			String jobLocation, Date jobPostDate, Date jobOpenDate, Date jobCloseDate, String jobDescription,
			String recruiterId, Recruiter recruiter, int catId, JobCategory jobCategory, Set<Application> application) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobCategoryName = jobCategoryName;
		this.gender = gender;
		this.age = age;
		this.jobRole = jobRole;
		this.skillsRequired = skillsRequired;
		this.jobQualification = jobQualification;
		this.jobExperience = jobExperience;
		this.jobPost = jobPost;
		this.expectedSalary = expectedSalary;
		this.jobLocation = jobLocation;
		this.jobPostDate = jobPostDate;
		this.jobOpenDate = jobOpenDate;
		this.jobCloseDate = jobCloseDate;
		this.jobDescription = jobDescription;
		this.recruiterId = recruiterId;
		this.recruiter = recruiter;
		this.catId = catId;
		this.jobCategory = jobCategory;
		this.application = application;
	}

	public Job(int jobId, String jobTitle, String jobCategoryName, String gender, String age, String jobRole,
			String skillsRequired, String jobQualification, int jobExperience, int jobPost, int expectedSalary,
			String jobLocation, Date jobPostDate, Date jobOpenDate, Date jobCloseDate, String jobDescription,
			String recruiterId, Recruiter recruiter, JobCategory jobCategory, Set<Application> application) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobCategoryName = jobCategoryName;
		this.gender = gender;
		this.age = age;
		this.jobRole = jobRole;
		this.skillsRequired = skillsRequired;
		this.jobQualification = jobQualification;
		this.jobExperience = jobExperience;
		this.jobPost = jobPost;
		this.expectedSalary = expectedSalary;
		this.jobLocation = jobLocation;
		this.jobPostDate = jobPostDate;
		this.jobOpenDate = jobOpenDate;
		this.jobCloseDate = jobCloseDate;
		this.jobDescription = jobDescription;
		this.recruiterId = recruiterId;
		this.recruiter = recruiter;
		this.jobCategory = jobCategory;
		this.application = application;
	}
	public Job(int jobId, String jobTitle, String jobCategoryName, String gender, String age, String jobRole,
			String skillsRequired, String jobQualification, int jobExperience, int jobPost, int expectedSalary,
			String jobLocation, Date jobPostDate, Date jobOpenDate, Date jobCloseDate, String jobDescription,
			Recruiter recruiter, JobCategory jobCategory, Set<Application> application) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobCategoryName = jobCategoryName;
		this.gender = gender;
		this.age = age;
		this.jobRole = jobRole;
		this.skillsRequired = skillsRequired;
		this.jobQualification = jobQualification;
		this.jobExperience = jobExperience;
		this.jobPost = jobPost;
		this.expectedSalary = expectedSalary;
		this.jobLocation = jobLocation;
		this.jobPostDate = jobPostDate;
		this.jobOpenDate = jobOpenDate;
		this.jobCloseDate = jobCloseDate;
		this.jobDescription = jobDescription;
		this.recruiter = recruiter;
		this.jobCategory = jobCategory;
		this.application = application;
	}


	public Job(int jobId, String jobTitle, String jobCategoryName, String gender, String age, String jobRole,
			String skillsRequired, String jobQualification, int jobExperience, int jobPost, int expectedSalary,
			String jobLocation, Date jobPostDate, Date jobOpenDate, Date jobCloseDate, String jobDescription,
			Recruiter recruiter, JobCategory jobCategory) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobCategoryName = jobCategoryName;
		this.gender = gender;
		this.age = age;
		this.jobRole = jobRole;
		this.skillsRequired = skillsRequired;
		this.jobQualification = jobQualification;
		this.jobExperience = jobExperience;
		this.jobPost = jobPost;
		this.expectedSalary = expectedSalary;
		this.jobLocation = jobLocation;
		this.jobPostDate = jobPostDate;
		this.jobOpenDate = jobOpenDate;
		this.jobCloseDate = jobCloseDate;
		this.jobDescription = jobDescription;
		this.recruiter = recruiter;
		this.jobCategory = jobCategory;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getJobCategoryName() {
		return jobCategoryName;
	}


	public void setJobCategoryName(String jobCategoryName) {
		this.jobCategoryName = jobCategoryName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getJobRole() {
		return jobRole;
	}


	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}


	public String getSkillsRequired() {
		return skillsRequired;
	}


	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}


	public String getJobQualification() {
		return jobQualification;
	}


	public void setJobQualification(String jobQualification) {
		this.jobQualification = jobQualification;
	}


	public int getJobExperience() {
		return jobExperience;
	}


	public void setJobExperience(int jobExperience) {
		this.jobExperience = jobExperience;
	}


	public int getJobPost() {
		return jobPost;
	}


	public void setJobPost(int jobPost) {
		this.jobPost = jobPost;
	}


	public int getExpectedSalary() {
		return expectedSalary;
	}


	public void setExpectedSalary(int expectedSalary) {
		this.expectedSalary = expectedSalary;
	}


	public String getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getJobLocation() {
		return jobLocation;
	}


	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}


	public Date getJobPostDate() {
		return jobPostDate;
	}


	public void setJobPostDate(Date jobPostDate) {
		this.jobPostDate = jobPostDate;
	}


	public Date getJobOpenDate() {
		return jobOpenDate;
	}


	public void setJobOpenDate(Date jobOpenDate) {
		this.jobOpenDate = jobOpenDate;
	}


	public Date getJobCloseDate() {
		return jobCloseDate;
	}


	public void setJobCloseDate(Date jobCloseDate) {
		this.jobCloseDate = jobCloseDate;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public Recruiter getRecruiter() {
		return recruiter;
	}


	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}


	public JobCategory getJobCategory() {
		return jobCategory;
	}


	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	public Set<Application> getApplication() {
		return application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	
	
	
}
