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
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.JobCategoryService;
import com.jobportal.service.JobSeekerEduService;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.JobSeekerWorkExpService;
import com.jobportal.service.LoginService;
import com.jobportal.util.JobSeekerId;
import com.jobportal.util.FileValidator;
import com.jobportal.util.FileValidator2;

@Controller
@Transactional
public class ApplicationController {	

	@Autowired
	private ApplicationService myAppService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	FileValidator2 fileValidator;
	
	@InitBinder("applicationModel")
	protected void initBinder(WebDataBinder binder) {
	   binder.setValidator(fileValidator);
	}
	
	@RequestMapping(value="/regAppPath",method=RequestMethod.GET)
	public ModelAndView dispatchLoadRegister(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Load App Form");
		ModelAndView mv=new ModelAndView();
		String sid=req.getParameter("frmJobSeekerId");
		String rid=req.getParameter("frmRecruiterId");
		String jid=req.getParameter("frmJobId");
		
	
		modelMap.addAttribute("frmRecruiterId", rid);
		modelMap.addAttribute("frmJobId",jid);
		modelMap.addAttribute("frmSeekerId",sid);
		modelMap.addAttribute("applicationModel",new ApplicationModel());
		mv.addAllObjects(modelMap);
		mv.setViewName("jobSeeker/app_register");
		return mv;
	}
	@RequestMapping(value="/saveAppPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="applicationModel")ApplicationModel applicationModel,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Post Mapping for Resume Upload");	
		String strRecruiterId=req.getParameter("frmRecruiterId");
		String strJobId=req.getParameter("frmJobId");
		String strSeekerId=req.getParameter("frmSeekerId");
		
		applicationModel.setJobSeekerId(strSeekerId);
		applicationModel.setRecruiterId(strRecruiterId);
		applicationModel.setJobId(strJobId);
		
		this.myAppService.registerApplication(applicationModel);
		return "redirect:/loginSuccessPath";
	}
	@RequestMapping(value="/viewAppPath",method=RequestMethod.GET)
	public String dispathGetAllAppByJobId(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		ApplicationModel model=new ApplicationModel();
		String jobId=req.getParameter("frmJobId");
		model.setJobId(jobId);
		modelMap.addAttribute(model);
		this.myAppService.getActivateApplicationByJobId(model);
		modelMap.addAttribute("appModel",model);
		return "recruiter/view_app_by_job";
	}
	@RequestMapping(value = { "/downloadAppPath" }, method = RequestMethod.GET)
	public String downloadDocument( HttpServletRequest req,HttpServletResponse response) throws IOException {
		String strId=req.getParameter("frmAppId");
		Application app=new Application();
		app=this.myAppService.getAnApplicationById(strId);
		System.out.println("EDU CONTROLLER EDU CONTRENT TYPE-->"+app.getContentType());
		response.setContentLength(app.getCvForm().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + app.getFileName()+"\"");
        response.setContentType(app.getContentType());
        FileCopyUtils.copy(app.getCvForm(), response.getOutputStream());
 		return "recruiter/view_app_by_job";
	}
	@RequestMapping(value="/saveSelectionPath",method=RequestMethod.POST)
	public String dispatchSaveSelection(@ModelAttribute(name="applicationModel")ApplicationModel applicationModel,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Post Mapping for Resume Upload");	
		String aid=req.getParameter("frmAppId");
		String jid=req.getParameter("frmJobId");
		applicationModel.setAppId(aid);
		this.myAppService.makeSelection(applicationModel);
		return "redirect:/viewAppPath"+"?frmJobId="+jid;
	}
	
	@RequestMapping(value="/getAllAppPath",method=RequestMethod.GET)
	public String dispathGetAllAppBySeekerId(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		ApplicationModel model=new ApplicationModel();
		HttpSession session=req.getSession(true);
		String seekerId=(String)session.getAttribute("loginId");
		session.setAttribute("seekerId", seekerId);
	
		model.setJobSeekerId(seekerId);
		this.myAppService.getAllApplicationBySeekerId(model);
		modelMap.addAttribute("appModel",model);
		return "jobSeeker/view_all_app";
	}
}
	

