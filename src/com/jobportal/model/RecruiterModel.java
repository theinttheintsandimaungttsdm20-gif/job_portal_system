package com.jobportal.model;

import java.util.List;

import com.jobportal.entity.Recruiter;

public class RecruiterModel {

	private String frmRecruiterId;
	private String frmRecruiterName;
	private String frmCompanyName;
	private String frmCompanyLicense;
	private String frmEmail;
	private String frmAddress;
	private String frmState;
	private String frmPostalCode;
	private String frmDescription;
	private List<Recruiter> frmRecruiterList;
	private Recruiter recruiter;
	
	public String getFrmRecruiterId() {
		return frmRecruiterId;
	}

	public void setFrmRecruiterId(String frmRecruiterId) {
		this.frmRecruiterId = frmRecruiterId;
	}

	public String getFrmRecruiterName() {
		return frmRecruiterName;
	}

	public void setFrmRecruiterName(String frmRecruiterName) {
		this.frmRecruiterName = frmRecruiterName;
	}

	public String getFrmCompanyName() {
		return frmCompanyName;
	}

	public void setFrmCompanyName(String frmCompanyName) {
		this.frmCompanyName = frmCompanyName;
	}

	public String getFrmCompanyLicense() {
		return frmCompanyLicense;
	}

	public void setFrmCompanyLicense(String frmCompanyLicense) {
		this.frmCompanyLicense = frmCompanyLicense;
	}

	public String getFrmEmail() {
		return frmEmail;
	}

	public void setFrmEmail(String frmEmail) {
		this.frmEmail = frmEmail;
	}

	public String getFrmAddress() {
		return frmAddress;
	}

	public void setFrmAddress(String frmAddress) {
		this.frmAddress = frmAddress;
	}

	public String getFrmState() {
		return frmState;
	}

	public void setFrmState(String frmState) {
		this.frmState = frmState;
	}

	public String getFrmPostalCode() {
		return frmPostalCode;
	}

	public void setFrmPostalCode(String frmPostalCode) {
		this.frmPostalCode = frmPostalCode;
	}

	public String getFrmDescription() {
		return frmDescription;
	}

	public void setFrmDescription(String frmDescription) {
		this.frmDescription = frmDescription;
	}

	public List<Recruiter> getFrmRecruiterList() {
		return frmRecruiterList;
	}

	public void setFrmRecruiterList(List<Recruiter> frmRecruiterList) {
		this.frmRecruiterList = frmRecruiterList;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
}
