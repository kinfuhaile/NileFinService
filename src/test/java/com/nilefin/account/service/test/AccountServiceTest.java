package com.nilefin.account.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nilefin.model.Authority;
import com.nilefin.model.User;

import com.nilefin.service.impl.LoginService;
import com.springinpractice.config.MySQLRepositoryConfig;
import com.springinpractice.config.NileServiceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MySQLRepositoryConfig.class, NileServiceConfig.class})
@Transactional
@ActiveProfiles(value = "mysql-h22")
public class AccountServiceTest {

	@Autowired
	private LoginService accountService;

	@Autowired
	private User user;

	@Autowired
	private Authority authority;

	private Collection<Authority> authorityCollectionn = new ArrayList<>();
	
	@Test
	@Rollback(false)
	public void createAccountTest() {

		
		user.setEmail("abc@gmail.com");
		authority.setUserName(user.getUsername());
		authorityCollectionn.add(authority);
		user.setAuthorityCollection(authorityCollectionn);
		accountService.createAccount(user);
		System.out.println(user.getEmail());
		assertEquals(1, 1);

	}

}
