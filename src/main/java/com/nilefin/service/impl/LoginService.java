package com.nilefin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nilefin.model.User;
import com.nilefin.persistent.dao.abst.AbstractNileFinDao;
import com.nilefin.persistent.dao.impl.UserDao;
import com.nilefin.persistent.database.config.MySQLRepositoryConfig;
import com.nilefin.service.facad.AccountServiceInterface;

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
