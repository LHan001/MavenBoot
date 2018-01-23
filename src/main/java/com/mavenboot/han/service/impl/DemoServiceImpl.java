package com.mavenboot.han.service.impl;

import com.mavenboot.han.service.DemoService;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
        return "Hello " + name;
    }
	
}
