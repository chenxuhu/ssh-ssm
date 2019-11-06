package com.itheima.mybatis.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.pojo.UserExample;


public class JunitTest {
	
	@Test
	public void juniTestSpring(){
		ApplicationContext ac =new	ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example=new UserExample();
		example.createCriteria().andSexEqualTo("1");
		
		int countByExample = userMapper.countByExample(example);
		System.out.println(countByExample);
	}
	
	
	@Test
	public void sexUsername(){
		ApplicationContext ac =new	ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example=new UserExample();
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%明%");
		
		int countByExample = userMapper.countByExample(example);
		System.out.println(countByExample);
		
		List<User> selectByExample = userMapper.selectByExample(example);
		
		System.out.println("selectByExample====="+selectByExample);
		
	}
}
