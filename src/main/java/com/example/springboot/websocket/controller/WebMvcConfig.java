package com.example.springboot.websocket.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	 public void addViewControllers(ViewControllerRegistry registry){
		 registry.addViewController("/websocket").setViewName("websocket");
		 registry.addViewController("/login").setViewName("login");
		 registry.addViewController("/chat").setViewName("chat");
		 registry.addViewController("/main").setViewName("main");
		 registry.addViewController("/top").setViewName("top");
		 registry.addViewController("/center").setViewName("center");
	 }
}
