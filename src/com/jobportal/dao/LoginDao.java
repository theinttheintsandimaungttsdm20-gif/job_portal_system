package com.jobportal.dao;
import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.Login;
import com.jobportal.util.JobSeekerId;

@Repository("LoginDao")
public class LoginDao extends AbstractDao<Integer, Login> {
	
	public void saveLoginInfo(Login user)
	{
		super.persistVoid(user);
    }
	
	public void saveOrUpdateLoginInfo(Login user)
	{
		super.SaveOrUpdate(user);
    }
	
	
	public String CheckUserLogin(String email,String password){
		Login login=super.getObjectTwoParam(email, "email", password, "password");
		String id= login.getLoginId();
		System.out.println("LoginDao---->"+id);
		return id;
	}
	
	public Login CheckUserLogin1(String email){
		Login login=super.criteriaQueryGetObjectByName(email, "email");
		if(login!=null){
		System.out.println("LoginDao---->"+login.getLoginId());
		return login;}
		else{
			return null;
		}
	}

	public Login getOneLogin(String id){
		Login login=super.criteriaQueryGetObjectByName(id, "loginId");
		
		System.out.println("LoginDao---->"+login.getLoginId());
		return login;
	}
	public void deleteLogin(Login user){
		super.delete(user);
	}
}
