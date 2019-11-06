package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class MybatisDaoTest {
	
	
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testSectedUserById(){
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void testSectedUserByname(){
		UserDaoImpl userDaoImpl=new UserDaoImpl(sqlSessionFactory);
		List<User> selectUser = userDaoImpl.selectUserByname("王");
		for(User user:selectUser){
		    System.out.println(user);
		}
	}
	

}
