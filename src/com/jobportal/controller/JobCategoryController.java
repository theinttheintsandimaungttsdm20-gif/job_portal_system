package com.jobportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class JobCategoryController {
	
	@Autowired
	private JobCategoryService myJobCategoryService;
	

	@RequestMapping(value="/regCatPath",method=RequestMethod.GET)
	public ModelAndView dispatchLoadRegister(ModelMap modelMap){
		System.out.println("Load Job Category Form");
		ModelAndView mv=new ModelAndView();
		modelMap.addAttribute("jobCategoryModel",new JobCategoryModel());
		
		
		JobCategoryModel model1=new JobCategoryModel();
		this.myJobCategoryService.getAllCategory(model1);
		modelMap.addAttribute("jobCategoryModel1",model1);
		System.out.println("JOBCATEGORY MODEL 1 -->"+model1.getFrmJobCategoryList().size());
		mv.addAllObjects(modelMap);
		mv.setViewName("admin/job_category_register");
		return mv;
	}
	
	@RequestMapping(value="/saveCatPath",method=RequestMethod.POST)
	public String dispatchSaveRegister(@ModelAttribute(name="jobCategoryModel")JobCategoryModel jobCategoryModel){
		System.out.println("Post Mapping");

		
		this.myJobCategoryService.registerJobCategory(jobCategoryModel);
		return "redirect:/regCatPath";
	}
	
	@RequestMapping(value="/viewCatPath",method=RequestMethod.GET)
	public String dispatchViewCategory(HttpServletRequest req,HttpServletResponse resp,
			ModelMap modelMap){
		System.out.println("Get Mapping");

		JobCategoryModel model=new JobCategoryModel();
		this.myJobCategoryService.getAllCategory(model);
		modelMap.addAttribute("jobCategoryModel",model);
		return "admin/view_category";
	}
	
	@RequestMapping(value="/prepareUpdateCatPath",method=RequestMethod.GET)
	public String dispatchPrepareUpdateCategory(HttpServletRequest req,HttpServletResponse resp,
			ModelMap modelMap){
		System.out.println("Upate Get Mapping");
		String id=req.getParameter("frmCatId");
		JobCategoryModel model=new JobCategoryModel();
		model.setId(id);
		this.myJobCategoryService.prepareUpdateCategory(model);
		modelMap.addAttribute("jobCategoryModel",model);
		return "admin/update_category";
	}
	
	@RequestMapping(value="/updateCatPath",method=RequestMethod.POST)
	public String dispatchUpdateCategory(@ModelAttribute(name="jobCategoryModel")JobCategoryModel jobCategoryModel,
			HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Update Mapping");
		String id=req.getParameter("frmCatId");
		jobCategoryModel.setId(id);
		this.myJobCategoryService.updateCategory(jobCategoryModel);
		return "redirect:/prepareUpdateCatPath"+"?frmCatId="+id;
	}
	
	@RequestMapping(value="/deleteCatPath",method=RequestMethod.GET)
	public String dispatchDeleteCategory(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("delete Mapping");
		JobCategoryModel model=new JobCategoryModel();
		String id=req.getParameter("frmCatId");
		model.setId(id);
		this.myJobCategoryService.deleteCategory(model);
		return "redirect:/regCatPath";
	}
	
}
