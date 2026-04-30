package com.jobportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobportal.entity.Login;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.LoginService;
import com.jobportal.service.RecruiterService;

@Controller
@Transactional
public class DeactivateController {

	@Autowired
	private JobSeekerService myJobSeekerService;

	@Autowired
	private RecruiterService myRecruiterService;

	@RequestMapping(value="deactivatePath")
	public String deactivateOperation(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  
		HttpSession session=req.getSession(true);
		String strId=(String)session.getAttribute("loginId");
		
		if(strId.startsWith("uid")){
			JobSeekerModel model=new JobSeekerModel();
			model.setFrmJobSeekerId(strId);
			this.myJobSeekerService.deactivateJobSeeker(model);
		}else if(strId.startsWith("rid")){
			RecruiterModel model=new RecruiterModel();
			model.setFrmRecruiterId(strId);
			this.myRecruiterService.deactivateRecruiter(model);
		}
		
		
		session=req.getSession(false);
			session.removeAttribute("userLogin");
			session.removeAttribute("loginId");
			if(session==null ||session.getAttribute("userLogin")==null || session.getAttribute("loginId")==null){
				req.setAttribute("loginError","Session Time Out");
				return "redirect:/";
			}
		return "redirect:/";
	}
	

}
