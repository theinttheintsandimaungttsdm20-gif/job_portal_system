package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.Login;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.util.JobSeekerId;

@Repository("SeekerCategoryJoinIdDao")
public class SeekerCategoryJoinIdDao extends AbstractDao<Integer, SeekerCategoryJoinId> {
	
	public List<SeekerCategoryJoinId> getJoinListbySeekerId(String id){
		return super.criteriaQueryGetObjectsByName(id, "jobSeekerId");
	}
	
}
