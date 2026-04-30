package com.jobportal.controller;

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

import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.model.RegisterRecruiterForm;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.LoginService;
import com.jobportal.service.RecruiterService;
import com.jobportal.util.JobSeekerId;

@Controller
@Transactional
public class RecruiterController {
	
	@Autowired
	private RecruiterService myRecruiterService;
	
	@Autowired
	private JobSeekerService myJobSeekerService;
	
	@Autowired
	private LoginService myLoginService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/regRecruiterPath",method=RequestMethod.GET)
	public ModelAndView dispatchLoadRegister(ModelMap modelMap){
		System.out.println("Load Recruiter Register");
		ModelAndView mv=new ModelAndView();
		RegisterRecruiterForm r=new RegisterRecruiterForm();
		modelMap.addAttribute("id",this.myRecruiterService.GetRecruiterId());
		modelMap.addAttribute("registerRecruiterForm",new RegisterRecruiterForm());
		mv.addAllObjects(modelMap);
		mv.setViewName("recruiter/recruiter_register");
		return mv;
	}
	
	@RequestMapping(value="/saveRecruiterPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="registerRecruiterForm")RegisterRecruiterForm registerRecruiterForm){
		System.out.println("Post Mapping");
		RecruiterModel rm=registerRecruiterForm.getRecruiterModel();
		LoginModel lm=registerRecruiterForm.getLoginModel();

		lm.setFrmLoginId(rm.getFrmRecruiterId());
		lm.setFrmUserName(rm.getFrmRecruiterName());
		lm.setFrmEmail(rm.getFrmEmail());
		lm.setFrmPassword(passwordEncoder.encode(lm.getFrmPassword()));
		System.out.println("Recruiter CONTROLLER TRACE--->"+rm.getFrmRecruiterName()+":"+lm.getFrmPassword());
		this.myRecruiterService.registerRecruiter(rm);
		this.myLoginService.registerLoginInfo(lm);;
		//return "redirect:../jobPath/logOutPath";
		return "redirect:/";
	}
	
	@RequestMapping(value="/getAllRecruitersPath",method=RequestMethod.GET)
	public String LoadJobSeeker(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load  Get All Recruiters");
		String role=req.getParameter("frmRole");
		if(role.equals("jobSeeker")){
			RecruiterModel model=new RecruiterModel();
			this.myRecruiterService.getAllActivateRecruiters(model);
			modelMap.addAttribute("recruiterModel",model);
			modelMap.addAttribute("role",role);
			return "jobSeeker/view_all_recruiters";
		}
		RecruiterModel model=new RecruiterModel();
		this.myRecruiterService.getAllRecruiters(model);
		modelMap.addAttribute("recruiterModel",model);
		modelMap.addAttribute("role",role);
		return "jobSeeker/view_all_recruiters";
		
	}
	
	@RequestMapping(value="/viewRecruiterPath",method=RequestMethod.GET)
	public String LoadRecruiterProfile(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load  Get Recruiter");
		String action=req.getParameter("action");
		String recruiterId=req.getParameter("frmRecruiterId");
		if(action.equals("view")){
			RecruiterModel model=new RecruiterModel();
			model.setFrmRecruiterId(recruiterId);
			
			this.myRecruiterService.getRecruiterbyId(model);
			modelMap.addAttribute("recruiterModel",model);
			return "recruiter/view_recruiter_profile";
		}
		HttpSession session=req.getSession(true);
		String strId=(String)session.getAttribute("loginId");
//		session.setAttribute("frmSeekerId", strId);

		RecruiterModel model=new RecruiterModel();

		
		model.setFrmRecruiterId(strId);
		
		this.myRecruiterService.getRecruiterbyId(model);
		modelMap.addAttribute("recruiterModel",model);
		modelMap.addAttribute("loginModel",new LoginModel());
		return "recruiter/view_and_update_recruiter";
	}
	
	@RequestMapping(value="/updateRecruiterPath",method=RequestMethod.POST)
	public String dispatchSaveOrUpdateSeeker(@ModelAttribute(name="recruiterModel")RecruiterModel recruiterModel,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Update Mapping");
			String rid=req.getParameter("frmRecruiterId");
			System.out.println("Update For "+rid);
			recruiterModel.setFrmRecruiterId(rid);
			
			this.myRecruiterService.saveOrUpdateRecruiter(recruiterModel);
		return "redirect:viewRecruiterPath?action=update";
	}
	
	@RequestMapping(value="/deleteRecruiterPath",method=RequestMethod.GET)
	public String dispatchDeleteRecruiter(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Delete Recruiter Mapping");
		RecruiterModel model=new RecruiterModel();
		String id=req.getParameter("frmRecruiterId");
		model.setFrmRecruiterId(id);
		this.myRecruiterService.deleteRecruiter(model);
		
		return  "redirect:/getAllRecruitersPath"+"?frmRole=admin";		
		
	}
}
