package com.nilefin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nilefin.model.User;
import com.nilefin.persistent.dao.interfaces.UserDao;

@Service
@Transactional
public class LoginService{
	
	
	
	
	private UserDao userDao;
	
	
	@Autowired
	public LoginService(UserDao userDao) {
		this.userDao = userDao;
	}


	
	public void createAccount(User e) {
		// TODO Auto-generated method stub
		
	}


	
	public void login() {
		// TODO Auto-generated method stub
		
	}


	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}

	








	

}
