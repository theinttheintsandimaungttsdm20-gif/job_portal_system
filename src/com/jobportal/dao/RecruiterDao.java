package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.Recruiter;
import com.jobportal.util.JobSeekerId;

@Repository("RecruiterDao")
public class RecruiterDao extends AbstractDao<Integer, Recruiter> {
	
	public Boolean saveRecruiter(Recruiter recruiter)
	{
	 Boolean y= super.persistMtoM(recruiter);
	 String id=recruiter.getRecruiterId();
	 System.out.println("DAO : id "+ id);
	 return y;
    }
	
	public String getRecruiterId(){
		String myStr=super.CreateQueryGetRecruiterId();
	    String subStr=myStr.substring(myStr.indexOf("0")+1);
	    int a=Integer.parseInt(subStr)+1;
	    String b=""+a;
		int codeLength=4;
		
		if(b.length()!=codeLength){
			int len=b.length();
			for(int i=0;i<codeLength-len;i++)
				b="0"+b;
		}
		String startCode="rid";
		String d=startCode+b;
		return d;
	}

	public Recruiter getRecruiterById(String id){
		Recruiter r=super.criteriaQueryGetObjectByName(id, "recruiterId");
		return r;
	}
	
	public List<Recruiter> getAllRecuiters(){
		return this.getAllEntity();
	}
	
	public void SaveOrUpdateRecruiter(Recruiter recruiter){
		super.SaveOrUpdate(recruiter);
	}
	
	public void deleteRecruiter(Recruiter recruiter){
		super.delete(recruiter);
	}
}
