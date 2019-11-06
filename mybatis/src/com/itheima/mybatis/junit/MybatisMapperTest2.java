package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import com.itheima.mybatis.mapper.OrdersMapper;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest2 {
	
	@Test
	public void testSelectOrders() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		   List<Orders> selectOrders = mapper.selectOrders();
		   for(Orders order:selectOrders){
			   System.out.println(order);
		   }
		  
	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void testSelectUserList() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		   List<User> selectUserList = mapper.selectUserList();
		   for(User user:selectUserList){
			   System.out.println(user);
		   }
	}

}
