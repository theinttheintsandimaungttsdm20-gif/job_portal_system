package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobportal.dao.ApplicationDao;
import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.JobSeekerEducationDao;
import com.jobportal.dao.JobSeekerWorkExpDao;
import com.jobportal.dao.LoginDao;
import com.jobportal.dao.SeekerCategoryJoinDao;
import com.jobportal.entity.Application;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.Login;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.util.DateFormat;

@Service
@Repository("JobSeekerService")
public class JobSeekerService {
	@Autowired
	private JobSeekerDao myJobSeekerDao;
	
	@Autowired
	private JobCategoryDao myJobCategoryDao;
	
	@Autowired
	private SeekerCategoryJoinDao mySeekerCategoryJoinDao;
	
	@Autowired
	private LoginDao myLoginDao;
	
	@Autowired
	private ApplicationDao myAppDao;
	
	@Autowired
	private JobSeekerWorkExpDao myExpDao;
	
	@Autowired
	private JobSeekerEducationDao myEduDao;
	
	public void prepareJobSeekerRegister(RegisterJobSeekerForm registerJobSeekerForm){
		String strJobSeekerId=this.myJobSeekerDao.getJobSeekerId();
		System.out.println("AUTO GENERATED JOB SEEKER ID-->"+strJobSeekerId);
		JobSeekerModel jsm=new JobSeekerModel();
		LoginModel lm=new LoginModel();
		registerJobSeekerForm.setLoginModel(lm);
		registerJobSeekerForm.setJobSeekerModel(jsm);
		jsm.setFrmJobSeekerId(strJobSeekerId);

		List<JobCategory> catList=this.myJobCategoryDao.getAllCategory();
		for(JobCategory c:catList){
			registerJobSeekerForm.getMapAllCategory().put(""+c.getId(), c.getJobTitle());
			System.out.println("HASH MAP JOB SEEKER SEIVICE------>"+c.getId()+c.getJobTitle());
		
	}
	System.out.println("HASH MAP JOB SEEKER SEIVICE------>"+registerJobSeekerForm.getMapAllCategory().size());
	}
	
	
	public void registerJobSeeker(JobSeekerModel jsm){
		JobSeeker js=new JobSeeker();
		js.setJobSeekerId(jsm.getFrmJobSeekerId());
		js.setName(jsm.getFrmName());
		js.setEmail(jsm.getFrmEmail());
		js.setPhone(jsm.getFrmPhone());
		js.setSkills(jsm.getFrmSkills());
		js.setGender(jsm.getFrmGender());
		js.setDob(DateFormat.stringToDateFormat_dd_mm_yyyy1(jsm.getFrmDob()));
		js.setAddress(jsm.getFrmAddress());
		js.setState(jsm.getFrmState());
		js.setPostalCode((Integer.parseInt(jsm.getFrmPostalCode())));
		js.setStatus("activate");
		this.myJobSeekerDao.saveJobSeeker(js);
		for(String id:jsm.getSelectJobCategory()){
			JobCategory  jobCategory=this.myJobCategoryDao.getJobCategoryById(Integer.parseInt(id));
			SeekerCategoryJoinId seekerCategoryJoinId=new SeekerCategoryJoinId();
			seekerCategoryJoinId.setJobSeekerId(jsm.getFrmJobSeekerId());
			seekerCategoryJoinId.setId(jobCategory.getId());
			SeekerCategoryJoin joinEntity=new SeekerCategoryJoin();
			
			joinEntity.setSeekerCategoryJoinId(seekerCategoryJoinId);
			this.mySeekerCategoryJoinDao.saveSeekerCategoryJoin(joinEntity);
		}	
	}
	public void getAllJobSeekers(JobSeekerModel model){
		List<JobSeeker> l=this.myJobSeekerDao.getAllJobSeekerLists();
		model.setSeekerList(l);		
	}
	
	public void getAllActivateJobSeekers(JobSeekerModel model){
		List<JobSeeker> l=this.myJobSeekerDao.getAllJobSeekerLists();
		List<JobSeeker> list1=new ArrayList<JobSeeker>();
		for(JobSeeker j:l){
			if(j.getStatus().equals("activate")){
				list1.add(j);
			}
		}
		model.setSeekerList(list1);		
	}
	
	public void getJobSeekerById(JobSeekerModel model){
		String id=model.getFrmJobSeekerId();
		System.out.println("JOB SEEKER ID IN JOB SEEKER SERVICE -->"+id);
		JobSeeker s=this.myJobSeekerDao.getJobSeekerbyId(id);
		System.out.println("Get Job Seeker By Id -->"+s.getName()+" "+s.getEmail());
		model.setJobSeeker(s);
	}
	
	public void activateJobSeekerById(JobSeekerModel model){
		String id=model.getFrmJobSeekerId();
		System.out.println("JOB SEEKER ID IN JOB SEEKER SERVICE -->"+id);
		JobSeeker s=this.myJobSeekerDao.getJobSeekerbyId(id);
		String status=s.getStatus();
		
		if(status.equals("deactivate")){
			s.setStatus("activate");
			this.myJobSeekerDao.saveOrUpdateJobSeeker(s);
			model.setJobSeeker(s);
		}
		System.out.println("JOB SEEKER OBJECT IN JOB SEEKER SERVICE -->"+s);

		model.setJobSeeker(s);
	}
	
	public void saveOrUpdateJobSeeker(JobSeekerModel jsm){
		JobSeeker js=new JobSeeker();
		Login lm=new Login();
		
		js.setJobSeekerId(jsm.getFrmJobSeekerId());
		JobSeeker obj=this.myJobSeekerDao.getJobSeekerbyId(jsm.getFrmJobSeekerId());
		System.out.println("Save or Update for Login :"+lm.getLoginId());
		js.setName(jsm.getFrmName());
		
		js.setEmail(jsm.getFrmEmail());
		
		js.setPhone(jsm.getFrmPhone());
		js.setSkills(jsm.getFrmSkills());
		js.setGender(jsm.getFrmGender());
		js.setDob(DateFormat.stringToDateFormat_dd_mm_yyyy1(jsm.getFrmDob()));
		js.setAddress(jsm.getFrmAddress());
		js.setState(jsm.getFrmState());
		js.setPostalCode((Integer.parseInt(jsm.getFrmPostalCode())));
		js.setStatus("activate");
		System.out.println("BEFORE DATE FORMAT-->"+jsm.getFrmDob());
		System.out.println("AFTER DATE FORMAT-->"+js.getDob());
		this.myJobSeekerDao.saveOrUpdateJobSeeker(js);
		lm=this.myLoginDao.CheckUserLogin1(obj.getEmail());
		lm.setUsername(jsm.getFrmName());
		lm.setLoginId(jsm.getFrmJobSeekerId());
		lm.setEmail(jsm.getFrmEmail());
		this.myLoginDao.saveOrUpdateLoginInfo(lm);
	}
	
	public void prepareUpdateSeekerCategoryJoin(RegisterJobSeekerForm myForm){
		String strId=myForm.getJobSeekerModel().getFrmJobSeekerId();
		System.out.println("prepareUpdateSeekerCategoryJoin--->"+strId);
		List<SeekerCategoryJoin> l=this.mySeekerCategoryJoinDao.getJoinListbySeekerId(strId);
		if(l!=null){
			List<JobCategory> catList=new ArrayList<JobCategory>();
			for(SeekerCategoryJoin obj:l){
				JobCategory  jobCategory=this.myJobCategoryDao.getJobCategoryById(obj.getSeekerCategoryJoinId().getId());
				catList.add(jobCategory);
			}	
			for(JobCategory c:catList){
				myForm.getMapFavCategory().put(""+c.getId(), c.getJobTitle());
				System.out.println("HASH MAP JOB SEEKER SEIVICE------>"+c.getId()+c.getJobTitle());
			}    
		}
	}
	
	public void saveOrUpdateFavCategory(JobSeekerModel jsm){
		System.out.println("Job Seeker service saveOrUpdateFavCategory->"
				+ jsm.getSelectJobCategory().length);
//		JobSeeker js=this.myJobSeekerDao.getJobSeekerbyId(jsm.getFrmJobSeekerId());
//		this.myJobSeekerDao.SaveOrUpdate(js);
		for(String id:jsm.getSelectJobCategory()){
			//JobCategory  jobCategory=this.myJobCategoryDao.getJobCategoryById(Integer.parseInt(id));
			SeekerCategoryJoinId seekerCategoryJoinId=new SeekerCategoryJoinId();
			seekerCategoryJoinId.setJobSeekerId(jsm.getFrmJobSeekerId());
			seekerCategoryJoinId.setId(Integer.parseInt(id));
			SeekerCategoryJoin joinEntity=new SeekerCategoryJoin();
			
			joinEntity.setSeekerCategoryJoinId(seekerCategoryJoinId);
			this.mySeekerCategoryJoinDao.saveOrUpdateCategory(joinEntity);
		}	
	}
	
		public void deleteFavCategory(JobSeekerModel jsm){
			SeekerCategoryJoinId seekerCategoryJoinId=new SeekerCategoryJoinId();
			seekerCategoryJoinId.setJobSeekerId(jsm.getFrmJobSeekerId());
			seekerCategoryJoinId.setId(Integer.parseInt(jsm.getFrmCatId()));
			SeekerCategoryJoin joinEntity=new SeekerCategoryJoin();
			
			joinEntity.setSeekerCategoryJoinId(seekerCategoryJoinId);
			this.mySeekerCategoryJoinDao.deleteSeekerCategoryJoin(joinEntity);
		}
	
		public void deactivateJobSeeker(JobSeekerModel model){
			String id=model.getFrmJobSeekerId();
			JobSeeker jobSeeker=this.myJobSeekerDao.getJobSeekerbyId(id);
			jobSeeker.setStatus("deactivate");
			this.myJobSeekerDao.saveOrUpdateJobSeeker(jobSeeker);
		}
		public void deleteJobSeeker(JobSeekerModel model){
			Boolean b=false;
			String id=model.getFrmJobSeekerId();
			JobSeeker seeker=this.myJobSeekerDao.getJobSeekerbyId(id);
			System.out.println("Deactivated Job Seeker "+seeker.getName()+" "+seeker.getStatus());
			Set<JobSeekerEducation> listEdu=seeker.getJobSeekerEducation();
			List<JobSeekerWorkExp> listExp=this.myExpDao.getAllExpById(id);
			List<Application> listApp=this.myAppDao.getAllApplicationBySeekerId(id);
			List<SeekerCategoryJoin> listJoin=this.mySeekerCategoryJoinDao.getJoinListbySeekerId(id);
			System.out.println("deleteJobSeeker : SeekerCategoryJoin "+listJoin.size());
//			if(listEdu!=null){
//				for(JobSeekerEducation edu:listEdu){
//					this.myEduDao.deleteEducationById(edu);
//				}
//			}
//			if(listExp!=null){
//				for(JobSeekerWorkExp exp:listExp){
//					this.myExpDao.deleteExpById(exp);
//				}
//			}
//			if(listApp!=null){
//				for(Application app:listApp){
//					this.myAppDao.delete(app);
//				}
//			}
//			if(listJoin!=null){
//				for(SeekerCategoryJoin join:listJoin){
//					this.mySeekerCategoryJoinDao.deleteSeekerCategoryJoin(join);
//				}
//				//this.myJobSeekerDao.deleteJobSeeker(seeker);
//			}
			this.myJobSeekerDao.deleteJobSeeker(seeker);
			Login user=this.myLoginDao.getOneLogin(id);
			if(user!=null)
			this.myLoginDao.deleteLogin(user);	
		}
}
