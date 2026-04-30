package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.util.JobSeekerId;

@Repository("JobSeekerDao")
public class JobSeekerDao extends AbstractDao<Integer, JobSeeker> {
	
	public void saveJobSeeker(JobSeeker seeker)
	{
		super.persistVoid(seeker);
    }
	
	public String getJobSeekerId(){
		String myStr=super.CreateQueryGetJobSeekerId();
	    String subStr=myStr.substring(myStr.indexOf("0")+1);
	    int a=Integer.parseInt(subStr)+1;
	    String b=""+a;
		int codeLength=5;
		
		if(b.length()!=codeLength){
			int len=b.length();
			for(int i=0;i<codeLength-len;i++)
				b="0"+b;
		}
		String startCode="uid";
		String d=startCode+b;
		return d;
	}
	
	public JobSeeker getJobSeekerbyId(String id){
		JobSeeker jobSeeker=super.criteriaQueryGetObjectByName(id,"jobSeekerId") ;
		System.out.println("JobSeeekr Work exp dao --->"+jobSeeker.getJobSeekerId());
		System.out.println("JobSeeekr Work exp dao --->"+jobSeeker.getName());

		return jobSeeker;
	}
	
	public List<JobSeeker> getAllJobSeekerLists(){
		List<JobSeeker> l=super.getAllEntity();
		return l;
	}
	
	public void saveOrUpdateJobSeeker(JobSeeker seeker)
	{
		super.SaveOrUpdate(seeker);
    }
	public void deleteJobSeeker(JobSeeker seeker){
		super.delete(seeker);
	}

}
