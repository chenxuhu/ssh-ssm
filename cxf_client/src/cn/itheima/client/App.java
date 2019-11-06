package cn.itheima.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cxf.xml");
		HelloService proxy = (HelloService) ctx.getBean("myClient");
		String sayHello = proxy.sayHello("test");
		System.out.println(sayHello);
	}

}
