/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package com.nilefin.service.facad;

import org.springframework.validation.Errors;

import com.nilefin.model.User;


public interface AccountService {


	public boolean registerAccount(User account, String password, Errors errors);
	public User getUserAccount(String userName);


}
