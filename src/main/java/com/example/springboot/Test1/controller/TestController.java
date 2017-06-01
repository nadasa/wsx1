package com.example.springboot.Test1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/mm")
	public String he(){
		return "wwwwwwwwwwwwwwwwwwwwwww";
	}
}
