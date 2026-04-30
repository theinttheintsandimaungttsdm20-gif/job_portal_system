package com.jobportal.controller;

import java.util.List;

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

import com.jobportal.entity.JobCategory;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.service.JobCategoryService;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.LoginService;
import com.jobportal.util.JobSeekerId;

@Controller
@Transactional
public class JobSeekerController {
	
	@Autowired
	private JobSeekerService myJobSeekerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginService myLoginService;
	
	@RequestMapping(value="/regJobSeekerPath",method=RequestMethod.GET)
	public String dispatchLoadRegister(ModelMap modelMap){
		System.out.println("Load Job Seeker Register");
		RegisterJobSeekerForm js=new RegisterJobSeekerForm();
		this.myJobSeekerService.prepareJobSeekerRegister(js);
		System.out.println("JOB SEEKER CONTROLLER------>"+js.getJobSeekerModel().getFrmJobSeekerId());
		modelMap.addAttribute("registerJobSeekerForm",js);
		return "jobSeeker/job_seeker_register";
	}
	
	@RequestMapping(value="/saveJobSeekerPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="registerJobSeekerForm")RegisterJobSeekerForm registerJobSeekerForm,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Post Mapping");
		String save=req.getParameter("save");
		if(save!=null){
			JobSeekerModel jsm=registerJobSeekerForm.getJobSeekerModel();
			LoginModel lm=registerJobSeekerForm.getLoginModel();
			lm.setFrmLoginId(jsm.getFrmJobSeekerId());
			lm.setFrmUserName(jsm.getFrmName());
			lm.setFrmEmail(jsm.getFrmEmail());
			lm.setFrmPassword(passwordEncoder.encode(lm.getFrmPassword()));
			System.out.println("JOB SEEKER CONTROLLER TRACE--->"+jsm.getFrmName()+":"+lm.getFrmPassword());
//		    HttpSession session=req.getSession(true);	
//		    session.setAttribute("jobSeekerId",lm.getFrmLoginId());
			this.myJobSeekerService.registerJobSeeker(jsm);
			this.myLoginService.registerLoginInfo(lm);;
		}
		//return "redirect:../jobPath/logOutPath";
		return "redirect:/";
	}
	
	@RequestMapping(value="/getAllJobSeekerPath",method=RequestMethod.GET)
	public String LoadAllJobSeekers(ModelMap modelMap,HttpServletRequest req){
		System.out.println("Load  Get All Job Seeker");
		String role=req.getParameter("frmRole");

		JobSeekerModel model=new JobSeekerModel();
		if(role.equals("recruiter")){
			this.myJobSeekerService.getAllActivateJobSeekers(model);
			modelMap.addAttribute("jobSeekerModel",model);
			modelMap.addAttribute("role",role);

			return "recruiter/view_all_job_seekers";
		}
		this.myJobSeekerService.getAllJobSeekers(model);
		modelMap.addAttribute("jobSeekerModel",model);
		modelMap.addAttribute("role",role);

		return "recruiter/view_all_job_seekers";
		
	}
	
	@RequestMapping(value="/getJobSeekerPath",method=RequestMethod.GET)
	public String LoadJobSeeker(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load  Get Job Seeker");
		
		HttpSession session=req.getSession(true);
		String strId=(String)session.getAttribute("loginId");
//		session.setAttribute("frmSeekerId", strId);
		JobSeekerModel model=new JobSeekerModel();
		LoginModel loginModel=new LoginModel();
		RegisterJobSeekerForm form=new RegisterJobSeekerForm();
		
		model.setFrmJobSeekerId(strId);
		form.setJobSeekerModel(model);
		
		this.myJobSeekerService.getJobSeekerById(model);
		this.myJobSeekerService.prepareUpdateSeekerCategoryJoin(form);
		this.myJobSeekerService.prepareJobSeekerRegister(form);
		modelMap.addAttribute("jobSeekerModel",model);
		modelMap.addAttribute("loginModel",loginModel);
		modelMap.addAttribute("registerJobSeekerForm",form);
		return "jobSeeker/view_job_seeker";
	}
	
	@RequestMapping(value="/updateJobSeekerPath",method=RequestMethod.POST)
	public String dispatchSaveOrUpdateSeeker(@ModelAttribute(name="jobSeekerModel")JobSeekerModel seekerModel,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Update Mapping");
			String sid=req.getParameter("frmJobSeekerId");
			System.out.println("Update For "+sid);
			seekerModel.setFrmJobSeekerId(sid);
			this.myJobSeekerService.saveOrUpdateJobSeeker(seekerModel);
		return "redirect:getJobSeekerPath";
	}
	
	@RequestMapping(value="/updateFavCategoryPath",method=RequestMethod.POST)
	public String dispatchSaveOrUpdateFavCategory(@ModelAttribute(name="registerJobSeekerForm")RegisterJobSeekerForm myForm,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Update fav cat Mapping");
		JobSeekerModel jsm=myForm.getJobSeekerModel();

			String sid=req.getParameter("frmJobSeekerId");
			System.out.println("Update For "+sid);
			jsm.setFrmJobSeekerId(sid);
			this.myJobSeekerService.saveOrUpdateFavCategory(jsm);
		return "redirect:getJobSeekerPath";
	}
	
	@RequestMapping(value="/deleteFavCategoryPath",method=RequestMethod.GET)
	public String dispatchDeleteFavCategory(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Update fav cat Mapping");
			JobSeekerModel model=new JobSeekerModel();
			String catId=req.getParameter("frmCatId");
			String seekerId=req.getParameter("frmJobSeekerId");
			model.setFrmJobSeekerId(seekerId);
			model.setFrmCatId(catId);
			
			System.out.println("Delete For catid"+catId);
			System.out.println("Delete For seekerId"+seekerId);

			this.myJobSeekerService.deleteFavCategory(model);
		return "redirect:getJobSeekerPath";
	}
	@RequestMapping(value="/deleteSeekerPath",method=RequestMethod.GET)
	public String dispatchDeleteSeeker(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Delete Job Seeker Mapping");
		JobSeekerModel model=new JobSeekerModel();
			String id=req.getParameter("frmId");
			model.setFrmJobSeekerId(id);
			this.myJobSeekerService.deleteJobSeeker(model);
			System.out.println("Job seeker controller for delete: ");

			
				return "redirect:/getAllJobSeekerPath"+"?frmRole=admin";
			
		
	}
	@RequestMapping(value="/viewSeekerProfilePath",method=RequestMethod.GET)
	public String viewSeekerProfile(ModelMap map,HttpServletRequest req,HttpServletResponse resp){
		System.out.println("View Seeker Profile Path");
		JobSeekerModel model=new JobSeekerModel();
			String id=req.getParameter("frmSeekerId");
			model.setFrmJobSeekerId(id);
			this.myJobSeekerService.getJobSeekerById(model);
			map.addAttribute("jobSeekerModel",model);
			System.out.println("Model testing dob "+model.getJobSeeker().getDob());
			return "jobSeeker/view_job_seeker_profile";
		
	}

}
