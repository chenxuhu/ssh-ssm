package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MybatisFirstTest {
	
	//根据ID查询用户
	@Test
	public void testFindUserById() throws IOException{
		//加载核心配置文件
	   String resource = "sqlMapConfig.xml";
	    InputStream in = Resources.getResourceAsStream(resource);
	     //创建SqlSessionFactory
	   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	     //创建SqlSession
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   User user = sqlSession.selectOne("findUserById",10);
	   System.out.println(user);
  }

	//<!-- 根据名字查User  like-->
	@Test
	public void testFindUserLike() throws IOException{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> user = sqlSession.selectList("test.findUserByName", "王");
		for(User u:user){
			System.out.println(user);
		}
	}
	
	//添加用户
		@Test
		public void insertUser() throws IOException{
			//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		  User user =new User();
		 
		  user.setUsername("陈许湖");
		  user.setBirthday(new Date());
		  user.setSex("南");
		  user.setAddress("chsaf");
		   int insert = sqlSession.insert("test.insertUser", user);
		   sqlSession.commit();
		   System.out.println(user.getId());
	  }
		
		//修改用户
				@Test
				public void updateUser() throws IOException{
					//加载核心配置文件
				   String resource = "sqlMapConfig.xml";
				    InputStream in = Resources.getResourceAsStream(resource);
				     //创建SqlSessionFactory
				   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				     //创建SqlSession
				   SqlSession sqlSession = sqlSessionFactory.openSession();
				  User user =new User();
				  user.setId(30);
				  user.setUsername("陈许湖");
				  user.setBirthday(new Date());
				  user.setSex("南");
				  user.setAddress("chenxuhu");
				   int update = sqlSession.update("test.updateUser", user);
				   sqlSession.commit();	   
				   
			  }
				
				//删除用户
				@Test
				public void deleteUser() throws IOException{
					//加载核心配置文件
				   String resource = "sqlMapConfig.xml";
				    InputStream in = Resources.getResourceAsStream(resource);
				     //创建SqlSessionFactory
				   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				     //创建SqlSession
				   SqlSession sqlSession = sqlSessionFactory.openSession();
				int i = sqlSession.delete("test.deleteUser", 29);
				sqlSession.commit();
				
				   
			  }
}
