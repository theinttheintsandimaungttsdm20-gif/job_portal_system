package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.Login;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.util.JobSeekerId;

@Repository("SeekerCategoryJoinDao")
public class SeekerCategoryJoinDao extends AbstractDao<Integer, SeekerCategoryJoin> {
	
	public void saveSeekerCategoryJoin(SeekerCategoryJoin seekerCategoryJoin)
	{
		super.persistVoid(seekerCategoryJoin);
    }
	
	public void saveOrUpdateCategory(SeekerCategoryJoin categoryJoin){
		super.SaveOrUpdate(categoryJoin);
	}
	
	public void updateCategory(SeekerCategoryJoin categoryJoin){
		super.update(categoryJoin);
	}
	
	
	public SeekerCategoryJoin getSeekerCategoryJoinbyId(int id){
		return super.criteriaQueryGetObjectById(id, "seekerCategoryJoinId");	
	}

	public SeekerCategoryJoin getSeekerCategoryJoinByJobSeekerId(String id){
		return super.criteriaQueryGetObjectByName(id, "jobSeekerId");
	}
	
	public void updateSeekerCategoryJoin(SeekerCategoryJoin seekerCategoryJoin){
		super.update(seekerCategoryJoin);
	}
	
	public void deleteSeekerCategoryJoin(SeekerCategoryJoin seekerCategoryJoin){
		super.delete(seekerCategoryJoin);
	}
	
	public List<SeekerCategoryJoin> getJoinListbySeekerId(String id){
		return super.criteriaQueryGetObjectsByName(id, "jobSeekerId");
	}
	
	
}
