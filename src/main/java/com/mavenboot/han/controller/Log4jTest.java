package com.mavenboot.han.controller;

import java.lang.reflect.Method;

public class Log4jTest {

	public void mytest(){
		System.out.println("aaaaa");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*String s1 = new String("abc");
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = "abc";
		System.out.println(s1.equals(s2));//true
		System.out.println(s3.equals(s2));//true
		System.out.println(s1 == s2);//false
		System.out.println(s1 == s3);//false
		System.out.println(s2 == s4);//true*/
		Log4jTest test = new Log4jTest();
		System.out.println(test.getClass().getName());
		Class<?> forName = Class.forName("com.mavenboot.han.controller.Log4jTest");
		Method[] methods = forName.getMethods();
		for (Method method : methods) {
			String name = method.getName();
			System.out.println(name);
		}
		Object object = forName.newInstance();
		}
}
