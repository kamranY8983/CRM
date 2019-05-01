package com.crm.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping(value="/hello")
	public String sayHello() {
		return "hello";
	}
}
