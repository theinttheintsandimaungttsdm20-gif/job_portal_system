package com.jobportal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobportal.entity.Application;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.model.ApplicationModel;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.PaymentModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.model.RegisterPaymentForm;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.JobCategoryService;
import com.jobportal.service.JobSeekerEduService;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.JobSeekerWorkExpService;
import com.jobportal.service.LoginService;
import com.jobportal.service.PaymentDaoService;
import com.jobportal.util.JobSeekerId;
import com.jobportal.util.FileValidator;
import com.jobportal.util.FileValidator2;

@Controller
@Transactional
public class PaymentDaoController {	

	@Autowired
	private PaymentDaoService myPaymentDaoService;
	
	
	
	@RequestMapping(value="/getPaymentByRecruiter",method=RequestMethod.GET)
	public String dispathGetAllAppBySeekerId(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		PaymentModel paymentModel=new PaymentModel();
		HttpSession session=req.getSession(true);
		String recruiterId=(String)session.getAttribute("loginId");
		session.setAttribute("recruiterId", recruiterId);
		
		paymentModel.setFrmRecruiterId(recruiterId);
		this.myPaymentDaoService.getPaymentByRecruiterId(paymentModel);
		modelMap.addAttribute("paymentModel",paymentModel);
		return "recruiter/view_payment_by_recruiter";
	}
	@RequestMapping(value="/getAllPayments",method=RequestMethod.GET)
	public String dispathGetAllPayments(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		RegisterPaymentForm model=new RegisterPaymentForm();
		
		this.myPaymentDaoService.getAllPayments(model);
		modelMap.addAttribute("registerPaymentForm",model);
		return "admin/view_all_payments";
	}
}
	

