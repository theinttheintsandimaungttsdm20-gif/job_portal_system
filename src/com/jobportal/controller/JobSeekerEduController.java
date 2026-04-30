package com.jobportal.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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

import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.service.JobCategoryService;
import com.jobportal.service.JobSeekerEduService;
import com.jobportal.service.JobSeekerService;
import com.jobportal.service.JobSeekerWorkExpService;
import com.jobportal.service.LoginService;
import com.jobportal.util.JobSeekerId;
import com.jobportal.util.FileValidator;

@Controller
@Transactional
public class JobSeekerEduController {	

	@Autowired
	private JobSeekerEduService myJobSeekerEduService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	FileValidator fileValidator;
	
	@InitBinder("fileBucket")
	protected void initBinder(WebDataBinder binder) {
	   binder.setValidator(fileValidator);
	}
	
	@RequestMapping(value="/regEduPath",method=RequestMethod.GET)
	public ModelAndView dispatchLoadRegister(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load Edu Form");
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession(true);
		String strId=(String)session.getAttribute("loginId");
		session.setAttribute("frmSeekerId", strId);
		modelMap.addAttribute("fileBucket",new FileBucket());
		mv.addAllObjects(modelMap);
		mv.setViewName("jobSeeker/edu_register");
		return mv;
	}
	@RequestMapping(value="/saveEduPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="fileBucket")FileBucket fileBucket,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Post Mapping for File Upload");	
		
		String strId=req.getParameter("frmSeekerId");
		
		fileBucket.setJobSeekerId(strId);
		
		System.out.println("JobSeeker Edu Controller-->"+strId);
		this.myJobSeekerEduService.registerEdu(fileBucket);
		return "redirect:/loginSuccessPath";
	}
	
	@RequestMapping(value="/getEduPath",method=RequestMethod.GET)
	public String LoadAllEducation(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Load Eduation");
		String strId=req.getParameter("frmId");
		System.out.println("Seeker Id-->"+strId);
		String role=req.getParameter("frmRole");
		ModelAndView mv=new ModelAndView();
		FileBucket model=new FileBucket();
		model.setJobSeekerId(strId);
		this.myJobSeekerEduService.getAllEducation(model);;
		modelMap.addAttribute("fileBucket",model);
		mv.addAllObjects(modelMap);
		if(role.equals("seeker")){
			return "jobSeeker/view_all_edu";
		}else{
			return "recruiter/view_edu";
		}
		
	}
	
	@RequestMapping(value = { "/downloadEduPath" }, method = RequestMethod.GET)
	public String downloadDocument( HttpServletRequest req,HttpServletResponse response) throws IOException {
		String strSeekerId=req.getParameter("frmJobSeekerId");
		String eduId=req.getParameter("frmEduId");
		JobSeekerEducation edu=new JobSeekerEducation();
		
		edu=this.myJobSeekerEduService.getEducationById(eduId);
		System.out.println("EDU CONTROLLER EDU CONTRENT TYPE-->"+edu.getContentType());
		response.setContentLength(edu.getCertificationFile().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + edu.getFileName()+"\"");
        response.setContentType(edu.getContentType());
        FileCopyUtils.copy(edu.getCertificationFile(), response.getOutputStream());
		

 		return "recruiter/view_all_edu";
	}
	
	@RequestMapping(value="/prepareUpdateEduPath",method=RequestMethod.GET)
	public String dispatchSaveOrUpdateSeeker(HttpServletRequest req,HttpServletResponse resp,ModelMap map){
		System.out.println("Get Edu Mapping");
			String sid=req.getParameter("frmJobSeekerId");
			String eid=req.getParameter("frmEduId");
			System.out.println("Update For SeekerId"+sid);
			System.out.println("Update For Edu Id"+eid);
			FileBucket fileBucket=new FileBucket();
			fileBucket.setJobSeekerId(sid);
			fileBucket.setEduId(eid);
			map.addAttribute("frmJobSeekerId",sid);
			map.addAttribute("frmEduId",eid);
			this.myJobSeekerEduService.prepareUpdateJobSeekerEdu(fileBucket);
			map.addAttribute("fileBucket",fileBucket);
		return "jobSeeker/update_edu";
	}
	
	@RequestMapping(value="/updateEduPath",method=RequestMethod.POST)
	public String dispatchSaveOrUpdateSeeker(@ModelAttribute(name="fileBucket")FileBucket fileBucket,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Update Edu Mapping");
			String sid=req.getParameter("frmJobSeekerId");
			String eid=req.getParameter("frmEduId");
			System.out.println("Update For SeekerId"+sid);
			System.out.println("Update For Edu Id"+eid);
			fileBucket.setJobSeekerId(sid);
			fileBucket.setEduId(eid);
			
			this.myJobSeekerEduService.updateJobSeekerEdu(fileBucket);
		return "redirect:getEduPath?frmId="+sid;
	}
	
	@RequestMapping(value="/deleteEduPath",method=RequestMethod.GET)
	public String dispatchDeleteEdu(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Delete Edu Mapping");
			FileBucket fileBucket=new FileBucket();
			String eduId=req.getParameter("frmEduId");
			String jobseekerId=req.getParameter("frmJobSeekerId");
			fileBucket.setEduId(eduId);
			
			this.myJobSeekerEduService.deleteJobSeekerEdu(fileBucket);
		return "redirect:getEduPath?frmId="+jobseekerId;
	}
}
	

