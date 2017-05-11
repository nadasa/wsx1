package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.domain.Person;
@Controller
@SpringBootApplication
public class Wsx1Application {
	@RequestMapping("/index")
	public String index(Model model){
		Person person = new Person("aa",1);
		
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("xx",2);
		Person p2 = new Person("yy",3);
		Person p3 = new Person("zz",4);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		model.addAttribute("person", person);
		model.addAttribute("people", people);
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Wsx1Application.class, args);
	}
}
