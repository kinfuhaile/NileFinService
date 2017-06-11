/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.nilefin.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.nilefin.model.Authority;
import com.nilefin.model.User;
import com.nilefin.persistent.dao.interfaces.UserDao;
import com.nilefin.service.facad.AccountService;



/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Inject
	@Qualifier("hbnUserDao")
	private UserDao userDao;
	/*@Inject private RoleDao roleDao;
	*/
	@Inject
	private Authority authority;
	
	@Override
	@Transactional(readOnly = false)	
	public boolean registerAccount(User user, String password, Errors errors) {
		validateUsername(user.getUsername(), errors);
		Boolean userExist= true;
		 //Boolean userExist = userDao.load(user.getUsername()).size()>0;
		System.out.println(userExist);
		boolean valid = !errors.hasErrors();
		
		if(userExist){
			System.out.println("User Exists");
			return true;
		}
		
		if (valid) {
			System.out.println(valid);
			Set<Authority> roles = new HashSet<Authority>();
			authority.setUserRole("User");
			authority.setUserName(user.getUsername());
			roles.add(authority);
			user.setAuthorityCollection(roles);
			//userDao.create(user);
		}
		
		return valid;
	}
	
	private void validateUsername(String username, Errors errors) {
		if (true/*userDao.load(username).size()>0*/) {
			log.debug("Validation failed: duplicate username");
			errors.rejectValue("username", "error.duplicate", new String[] { username }, null);
		}
	}

	@Override
	public User getUserAccount(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(userName);
	}
	
	
}
