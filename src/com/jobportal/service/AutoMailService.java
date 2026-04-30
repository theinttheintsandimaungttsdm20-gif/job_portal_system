package com.jobportal.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.RecruiterDao;
import com.jobportal.dao.SeekerCategoryJoinDao;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.model.JobModel;
import com.jobportal.model.MailForm;
import com.jobportal.util.DateFormat;

@Service
@Repository("autoMailService")
public class AutoMailService {

	@Autowired
	private JobDao jobDao;
	@Autowired
	private JobService jobService;
	@Autowired
	private GeneralService generalService;
	@Autowired
	private JobCategoryDao myJobCategoryDao;
	@Autowired
	private SeekerCategoryJoinDao mySeekerCategoryJoinDao;
	@Autowired
	private JobSeekerDao jobSeekerDao;
	@Autowired
	private RecruiterDao recruiterDao;

	@Scheduled(fixedDelay = 86400000)
	public void autoMail() throws IOException, ParseException {
		System.out.println("@Scheduled process");
		Date date = DateFormat.subDays(+1);
		String strDate = DateFormat.dateToString_DB_Format(date);
		List<Job> jobs = this.jobDao.getAllJobs();
		List<Job> newJob = new ArrayList<Job>();
		for (Job job : jobs) {
			Date date2 = job.getJobOpenDate();
			String strDate1 = DateFormat.dateToString_DB_Format(date2);
			if (strDate.equals(strDate1)) {
				newJob.add(job);
			}
		}
		System.out.println("new job size " + newJob.size());
		if (newJob.size() != 0) {
			for (Job job : newJob) {
				List<JobSeeker> jobSeekerList = this.jobSeekerDao.getAllJobSeekerLists();
//				List<JobSeeker> newJobSeekerList = new ArrayList<JobSeeker>();
//				List<JobCategory> catList = new ArrayList<JobCategory>();
				for (JobSeeker jobSeeker : jobSeekerList) {
					String seekerId = jobSeeker.getJobSeekerId();
					List<SeekerCategoryJoin> l = this.mySeekerCategoryJoinDao.getJoinListbySeekerId(seekerId);
					for (SeekerCategoryJoin obj : l) {
						JobCategory jobCategory = this.myJobCategoryDao
								.getJobCategoryById(obj.getSeekerCategoryJoinId().getId());
						if (jobCategory.getId() == job.getCatId()) {
							MailForm mailForm=new MailForm();
							mailForm.setContent("Dear "+jobSeeker.getName());
							mailForm.setToMail(jobSeeker.getEmail());
							String service = "";
							String subject="";
							subject += "Recommend job for  " + job.getJobCategoryName();
							service+="Dear "+jobSeeker.getName()+",";
							service+="\n"+job.getRecruiter().getCompanyName()+" provides the follwing  job vacancy :";
							service += "\n Job Title is " + job.getJobTitle();
							service +=".\n Minimum age is "+job.getAge();
							service +=".\n Job role is "+job.getJobRole();
							service +=".\n Required Skills for job is "+job.getSkillsRequired();
							service +=" and must be "+job.getJobQualification();
							service +=".\n Job Post are "+job.getJobPost();
							service +=".\n Job Location is "+job.getJobLocation();
							service += ".\n Job Open Date is " + job.getJobOpenDate();
							System.out.println(service);
							System.out.println("--------------------------------------------");
							mailForm.setSubject(subject);
							mailForm.setContent(service);
							System.out.println("Send Mail");
						    generalService.processSendMail(mailForm);

						}

					}

				}

			}

		}
	}
}
