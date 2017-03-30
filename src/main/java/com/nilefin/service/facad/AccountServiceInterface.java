package com.nilefin.service.facad;

import org.springframework.transaction.annotation.Transactional;

import com.nilefin.model.User;

@Transactional
public interface AccountServiceInterface{

	public void createAccount(User e);

	public void login();

	public void deleteAccount();

}
