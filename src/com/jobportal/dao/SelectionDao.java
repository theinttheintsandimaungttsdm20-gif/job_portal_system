package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.Selection;
import com.jobportal.util.JobSeekerId;

@Repository("SelectionDao")
public class SelectionDao extends AbstractDao<Integer, Selection> {
	
	public void saveSelection(Selection selection)
	{
		super.persistVoid(selection);
    }
	public Integer saveSelectionWithId(Selection selection)
	{
		return super.persist(selection);
    }
	public void saveOrUpdateSelection(Selection selection)
	{
		super.SaveOrUpdate(selection);
    }
	public Selection getselectionById(int id){
		Selection l=super.criteriaQueryGetObjectById(id, "selectionId");
		return l;
	}
	
}
