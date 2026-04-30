package com.jobportal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jobportal.entity.Application;
import com.jobportal.entity.Selection;


public class ApplicationModel {

	MultipartFile file;
	String appId;
	String status;
	String resume;
	String dateApplied;
	String jobSeekerId;
	String recruiterId;
	String jobId;
	
	Selection selection;
	String selectionStatus;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}


	List<Application> appList;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	public String getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public List<Application> getAppList() {
		return appList;
	}
	public void setAppList(List<Application> appList) {
		this.appList = appList;
	}
	public String getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}
	public Selection getSelection() {
		return selection;
	}
	public void setSelection(Selection selection) {
		this.selection = selection;
	}
	public String getSelectionStatus() {
		return selectionStatus;
	}
	public void setSelectionStatus(String selectionStatus) {
		this.selectionStatus = selectionStatus;
	}
	
	
	
}