package com.itheima.service;

public class APP {
	public static void main(String[] args) {
		HelloServiceImplService ss = new HelloServiceImplService();
		HelloService port = ss.getHelloServiceImplPort();
		String ret = port.sayHello("test");
		System.out.println(ret);
	}

}
