package com.itheima.service;

public class HelloServiceImpl implements HelloService{
	public String sayHello(String name) {
		System.out.println("基于CXF开发的服务端sayHello方法被调用了。。。。");
		return "hello " + name;
	}
}
