package com.springinpractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nilefin.service.impl.LoginService;

@Configuration
@ComponentScan(basePackageClasses=LoginService.class)
public class NileServiceConfig {

}
