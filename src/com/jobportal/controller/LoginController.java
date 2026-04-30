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
public class LoginController {

	@Autowired
	private LoginService myLoginService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JobSeekerService myJobSeekerService;

	@Autowired
	private RecruiterService myRecrutierService;
	@RequestMapping("/")
	public String dispatchLoadRegister(ModelMap modelMap) {
		System.out.println("Load Login Form");
		LoginModel lm = new LoginModel();
		modelMap.addAttribute("loginModel", lm);

		return "login";
	}

	@RequestMapping(value = "/loginPath")
	public String dispatchSaveRegister(@ModelAttribute(name = "loginModel") LoginModel lm, BindingResult result,
			HttpServletRequest req, HttpServletResponse resp, ModelMap modelMap) {
		System.out.println("Post Mapping");

		String strEmail = lm.getFrmEmail();
		String strPassword = lm.getFrmPassword();
		System.out.println("LOGIN CONTROLLER---->" + strEmail + ":" + strPassword);
		Login user = this.myLoginService.CheckUserLogin(strEmail);
		if(user!=null){
		String strId = user.getLoginId();
		String dbPassword = user.getPassword();
		boolean isPasswordMatch = passwordEncoder.matches(lm.getFrmPassword(), dbPassword);
		System.out.println("LOGIN CONTROLLER---->" + isPasswordMatch);
		HttpSession session = req.getSession(true);

		if (isPasswordMatch == true || dbPassword.equals(lm.getFrmPassword())) {
			session.setAttribute("userLogin", user);
			session.setAttribute("loginId", user.getLoginId());

			return "login_success";
		}
		else{
			return "login";
		}
		}
		return "login";

	}

	@RequestMapping(value = "/loginSuccessPath")
	public String dispatchLoginSuccess(HttpServletRequest req, HttpServletResponse resp, ModelMap modelMap)
			throws IOException {
		System.out.println("Post Mapping");
		HttpSession session = req.getSession(true);

		if (session.getAttribute("loginId").toString().startsWith("uid")) {
			System.out.println("LOGIN SUCCESS-->" + session.getAttribute("loginId").toString());

			JobSeekerModel model = new JobSeekerModel();
			model.setFrmJobSeekerId(session.getAttribute("loginId").toString());
			this.myJobSeekerService.activateJobSeekerById(model);
			modelMap.addAttribute("myJobSeekerModel", model);
			return "jobSeeker/job_seeker_home";
		} else if (session.getAttribute("loginId").toString().startsWith("rid")) {
			RecruiterModel model=new RecruiterModel();
			model.setFrmRecruiterId(session.getAttribute("loginId").toString());
			this.myRecrutierService.activateRecruiterById(model);

			System.out.println("LOGIN SUCCESS-->" + session.getAttribute("loginId").toString());
			return "recruiter/recruiter_home";
		} else if (session.getAttribute("loginId").toString().startsWith("id")) {
			System.out.println("LOGIN SUCCESS-->" + session.getAttribute("loginId").toString());

			return "admin/admin_home";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/updatePasswordPath", method = RequestMethod.POST)
	public String dispatchSaveOrUpdatePassword(@ModelAttribute(name = "loginModel") LoginModel loginModel,
			HttpServletRequest req, HttpServletResponse resp, ModelMap modelMap) {
		System.out.println("Update Password Mapping");
		String lid = req.getParameter("frmLoginId");
		System.out.println("Update For " + lid);
		loginModel.setFrmLoginId(lid);
		this.myLoginService.updatePassword(loginModel);
		// modelMap.addAttribute("loginModel",loginModel);
		return "redirect:loginSuccessPath";
	}

	@RequestMapping(value="logOutPath")
	public String logOutDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  
		HttpSession session=req.getSession(false);
			session.removeAttribute("userLogin");
			session.removeAttribute("loginId");
			if(session==null ||session.getAttribute("userLogin")==null || session.getAttribute("loginId")==null){
				req.setAttribute("loginError","Session Time Out");
				return "redirect:/";
			}
		return "redirect:/";
	}
}
