package com.jobportal.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobportal.entity.Payment;
import com.jobportal.entity.Recruiter;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.PaymentModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.model.RegisterJobForm;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.model.RegisterPaymentForm;
import com.jobportal.service.JobCategoryService;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.JobSeekerWorkExpService;
import com.jobportal.service.JobService;
import com.jobportal.service.LoginService;
import com.jobportal.service.PaymentDaoService;
import com.jobportal.util.JobSeekerId;

@Controller
@Transactional
public class JobController {	

	@Autowired
	private JobService myJobService;
	
	@Autowired
	private PaymentDaoService myPaymentDaoService;
	@RequestMapping(value="/regJobPath",method=RequestMethod.GET)
	public String dispatchLoadRegister(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load Job Form");
		
		RegisterJobForm model=new RegisterJobForm();
		HttpSession session=req.getSession(true);
		String strRecruiterId=(String)session.getAttribute("loginId");
		session.setAttribute("frmRecruiterId", strRecruiterId);
		System.out.println("Job Controller for check payment:"+strRecruiterId);
		PaymentModel pModel=new PaymentModel();
		pModel.setFrmRecruiterId(strRecruiterId);
		//System.out.println("Job Controller for check payment1:"+pModel.getFrmRecruiterId());
		System.out.println("Job Controller for check payment2:"+strRecruiterId);

		Boolean b=this.myPaymentDaoService.checkPaymentByRecruiterId(pModel);
		
		if(b==true){
			return "redirect:/regPaymentPath";	
		}else{
			this.myJobService.prepareJobRegister(model);
			modelMap.addAttribute("registerJobForm",model);
			
			System.out.println("Job Controller :"+model.getMapAllCategory().size());
			return "recruiter/job_register";
		}
	}
	
	@RequestMapping(value="/saveJobPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="registerJobForm")RegisterJobForm registerJobForm,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		System.out.println("Post Mapping");	
		String strId=req.getParameter("frmRecruiterId");
		JobModel model=registerJobForm.getJobModel();
		model.setFrmRecruiterId(strId);
		this.myJobService.registerJob(model);
		return "redirect:/loginSuccessPath";
	}
	
	@RequestMapping(value="/viewJobPath",method=RequestMethod.GET)
	public String dispathGetAllJobs(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		JobModel model=new JobModel();

		this.myJobService.getAllActivateJobs(model);
		modelMap.addAttribute("jobModelList",model);
		return "jobSeeker/view_all_jobs";
	}
	@RequestMapping(value="/viewJobByRecruiterPath",method=RequestMethod.GET)
	public String dispathGetAllJobsByRecruiter(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		JobModel model=new JobModel();
		HttpSession session=req.getSession(true);
		String rid=(String)session.getAttribute("loginId");
		session.setAttribute("frmRecruiterId", rid);
		String action=req.getParameter("action");
		if(action.equals("update")){
			model.setFrmRecruiterId(rid);
			modelMap.addAttribute(model);
			this.myJobService.getAllJobsByRecruiterId(model);
			modelMap.addAttribute("jobModelList",model);
			
			modelMap.addAttribute("action",action);
			return "recruiter/view_jobs_by_recruiter";
		}else if(action.equals("view")){
			model.setFrmRecruiterId(rid);
			modelMap.addAttribute(model);
			this.myJobService.getAllJobsByRecruiterId(model);
			modelMap.addAttribute("jobModelList",model);
			modelMap.addAttribute("action",action);

			return "recruiter/view_jobs_by_recruiter";
		}else{
			
			String recruiterId=req.getParameter("frmRecruiterId");
			model.setFrmRecruiterId(recruiterId);
			modelMap.addAttribute(model);
			this.myJobService.getAllJobsByRecruiterId(model);
			modelMap.addAttribute("jobModelList",model);
			modelMap.addAttribute("action",action);

			return "admin/view_jobs_by_admin";
		}
	}
	
	@RequestMapping(value="/viewJobForUpdatePath",method=RequestMethod.GET)
	public String prepareUpdateJob(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		String jobId=req.getParameter("frmJobId");
		RegisterJobForm form=new RegisterJobForm();
		JobModel model=new JobModel();
		model.setFrmJobId(jobId);
		
		this.myJobService.prepareUpdateJob(model);
		this.myJobService.prepareJobRegister(form);
		modelMap.addAttribute("registerJobForm",form);
		modelMap.addAttribute("jobModel",model);
		return "recruiter/update_job";
		}
	@RequestMapping(value="/updateJobPath",method=RequestMethod.POST)
	public String dispatchSaveOrUpdateJob(@ModelAttribute(name="jobModel")JobModel jobModel,
			HttpServletRequest req,HttpServletResponse resp) throws IOException, ParseException{
		System.out.println("Update Job Mapping");
			String jobId=req.getParameter("frmJobId");
			System.out.println("Update For Job Id"+jobId);
			jobModel.setFrmJobId(jobId);
			this.myJobService.updateJob(jobModel);
		return "redirect:viewJobByRecruiterPath?action=update";
	}
	@RequestMapping(value="/deleteJobPath",method=RequestMethod.GET)
	public String dispatchDeleteJob(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Delete Job Mapping");
		JobModel model=new JobModel();
		String id=req.getParameter("frmJobId");
		model.setFrmJobId(id);
		this.myJobService.deleteJob(model);
		
		return  "redirect:/viewJobByRecruiterPath?action=view";		
		
	}
	@RequestMapping(value="/viewJobDetailPath",method=RequestMethod.GET)
	public String viewJobDetail(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		String jobId=req.getParameter("frmJobId");
		JobModel model=new JobModel();
		model.setFrmJobId(jobId);
		
		this.myJobService.prepareUpdateJob(model);
		modelMap.addAttribute("jobModel",model);
		String role=req.getParameter("frmRole");
		modelMap.addAttribute("role",role);
		return "recruiter/view_job_detail";
	}
}
	

