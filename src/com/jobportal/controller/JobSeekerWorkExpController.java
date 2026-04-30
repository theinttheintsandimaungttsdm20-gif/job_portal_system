package com.jobportal.controller;

import java.io.IOException;

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

import com.jobportal.model.FileBucket;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.service.JobCategoryService;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.JobSeekerWorkExpService;
import com.jobportal.service.LoginService;
import com.jobportal.util.JobSeekerId;

@Controller
@Transactional
public class JobSeekerWorkExpController {	

	@Autowired
	private JobSeekerWorkExpService myJobSeekerWorkExpService;
	
	@RequestMapping(value="/regWorkExpPath",method=RequestMethod.GET)
	public ModelAndView dispatchLoadRegister(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load Work Exp Form");
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession(true);
		String strId=(String)session.getAttribute("loginId");
		session.setAttribute("frmSeekerId", strId);
		modelMap.addAttribute("jobSeekerWorkExpModel",new JobSeekerWorkExpModel());
		mv.addAllObjects(modelMap);
		mv.setViewName("jobSeeker/work_exp_register");
		return mv;
	}
	
	@RequestMapping(value="/saveExpPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="jobSeekerWorkExpModel")JobSeekerWorkExpModel jobSeekerWorkExpModel,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Post Mapping");	
		String strId=req.getParameter("frmSeekerId");
		jobSeekerWorkExpModel.setJobSeekerId(strId);
		System.out.println("Job Work Exp Controller-->"+strId);
		this.myJobSeekerWorkExpService.registerWorkExp(jobSeekerWorkExpModel);
		return "redirect:/loginSuccessPath";
	}
	
	@RequestMapping(value="/getExpPath",method=RequestMethod.GET)
	public String LoadAllEducation(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load Exp");
		JobSeekerWorkExpModel model=new JobSeekerWorkExpModel();
		String strId=req.getParameter("frmId");
		String role=req.getParameter("frmRole");
		model.setJobSeekerId(strId);
		System.out.println("Seeker Id-->"+strId);
		ModelAndView mv=new ModelAndView();
		
		this.myJobSeekerWorkExpService.getAllExp(model);
		modelMap.addAttribute("expModel",model);
		mv.addAllObjects(modelMap);
		if(role.equals("seeker")){
			return "jobSeeker/view_all_exp";
		}else{
			return "recruiter/view_exp";
		}
	}
	@RequestMapping(value="/prepareUpdateExpPath",method=RequestMethod.GET)
	public String dispatchSaveOrUpdateSeeker(HttpServletRequest req,HttpServletResponse resp,ModelMap map){
		System.out.println("Get exp Mapping");
			String sid=req.getParameter("frmJobSeekerId");
			String eid=req.getParameter("frmExpId");
			System.out.println("Update For SeekerId"+sid);
			System.out.println("Update For Edu Id"+eid);
			JobSeekerWorkExpModel model=new JobSeekerWorkExpModel();
			model.setJobSeekerId(sid);
			model.setFrmExpId(eid);
			map.addAttribute("frmJobSeekerId",sid);
			map.addAttribute("frmExpId",eid);
			this.myJobSeekerWorkExpService.prepareUpdateJobSeekerExp(model);
			map.addAttribute("expModel",model);
		return "jobSeeker/update_exp";
	}
	
	@RequestMapping(value="/updateExpPath",method=RequestMethod.POST)
	public String dispatchSaveOrUpdateSeeker(@ModelAttribute(name="expModel")JobSeekerWorkExpModel expModel,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Update exp Mapping");
			String sid=req.getParameter("frmJobSeekerId");
			String eid=req.getParameter("frmExpId");
			System.out.println("Update For SeekerId"+sid);
			System.out.println("Update For Edu Id"+eid);
			expModel.setJobSeekerId(sid);
			expModel.setFrmExpId(eid);
			
			this.myJobSeekerWorkExpService.updateWorkExp(expModel);
		return "redirect:/getExpPath?frmId="+sid;
	}
	
	@RequestMapping(value="/deleteExpPath",method=RequestMethod.GET)
	public String dispatchDeleteFavCategory(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Delete Edu Mapping");
		JobSeekerWorkExpModel expModel=new JobSeekerWorkExpModel();
			String expId=req.getParameter("frmExpId");
			String jobseekerId=req.getParameter("frmJobSeekerId");
			expModel.setFrmExpId(expId);
			
			this.myJobSeekerWorkExpService.deleteWorkExp(expModel);
		return "redirect:getExpPath?frmId="+jobseekerId;
	}
	
}
