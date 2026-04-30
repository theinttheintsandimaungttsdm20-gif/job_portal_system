package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobportal.dao.LoginDao;
import com.jobportal.entity.Login;
import com.jobportal.model.LoginModel;


@Service
@Repository("LoginService")
public class LoginService {
	@Autowired
	private LoginDao myLoginDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void registerLoginInfo(LoginModel lm){
		Login user=new Login();
		user.setLoginId(lm.getFrmLoginId());
		user.setUsername(lm.getFrmUserName());
		user.setEmail(lm.getFrmEmail());
		user.setPassword(lm.getFrmPassword());
		this.myLoginDao.saveLoginInfo(user);
	}
	
	public Login CheckUserLogin(String email){
		Login user=this.myLoginDao.CheckUserLogin1(email);
		if(user!=null){
		return user;}
		else{
			return null;
		}
		
	}
	
	public void updatePassword(LoginModel lm){
		Login user=new Login();
		user=this.myLoginDao.getOneLogin(lm.getFrmLoginId());
		String newPassword=lm.getFrmNewPassword();
		String rePassword=lm.getFrmRePassword();
		String currentPassword=lm.getFrmPassword();
//		boolean isPasswordMatch = passwordEncoder.matches( lm.getFrmPassword(),dbPassword);
		String dbPassword=user.getPassword();
		boolean isPasswordMatch = passwordEncoder.matches( currentPassword,dbPassword);
		if(isPasswordMatch==true && newPassword.equals(rePassword)){
			System.out.println("Update Login Service "+isPasswordMatch+" "+user.getEmail());
			user.setPassword(passwordEncoder.encode(newPassword));
			this.myLoginDao.saveOrUpdateLoginInfo(user);
		}
	}

}
