package com.itheima.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;

public class JunitTest {
	
	@Test
	public void juniTestSpring(){
		ApplicationContext ac =new	ClassPathXmlApplicationContext("applicationContext.xml");

		
		UserMapper mapper = ac.getBean(UserMapper.class);//这个方法是直接获取一个接口
		//UserMapper mapper = (UserMapper) ac.getBean("userMapper");//这个是从spring容器中获取一个userMapper接口
		User user = mapper.findUserById(10);
		System.out.println(user);
	}
}
