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

public class MybatisMapperTest {
	
	@Test
	public void testMapper() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		   User user = userMapper.findUserById(10);
		   System.out.println(user);
	}
	
	@Test
	public void testfindUsernameVo() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		   
		   QueryVo vo=new QueryVo();
		   User user=new User();
		   user.setUsername("王");
		   vo.setUser(user);
		   
		    List<User> list = userMapper.findUserByQueryVo(vo);
		    System.out.println(list);
		 
	}
	

	@Test
	public void testCountUser() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		   
		   Integer countUser = userMapper.countUser();
		   System.out.println(countUser);
		   
		 
	}
	
	@Test
	public void testSelectOrderList() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		   List<Orders> selectOrderList = ordersMapper.selectOrderList();
		   
		   for(Orders orderlist:selectOrderList)
		   System.out.println(orderlist);  
		 
	}
	
	@Test
	public void testSelectUserSexandUsername() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		   
		   User user = new User();
		   //user.setSex("1");
		   user.setUsername("张小明");   
		   List<User> info = userMapper.selectUserSexandUsername(user);
		   for(User userList: info){
			   System.out.println(userList);
		   }
		   
		 
	}
	
	
	@Test
	public void testSelectUserByIds() throws IOException{
		//加载核心配置文件
		   String resource = "sqlMapConfig.xml";
		    InputStream in = Resources.getResourceAsStream(resource);
		     //创建SqlSessionFactory
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		     //创建SqlSession
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		   
////////////  尝试着List来    ///////////////////////////////////////////////		   
  /*   	   List<Integer> idsList=new ArrayList<>();
		   idsList.add(10);
		   idsList.add(16);
		   idsList.add(22);
		   
		  QueryVo  voIdsList=new QueryVo();
		  voIdsList.setIdsList(idsList);
		  List<User> selectUserByIds = userMapper.selectUserByIds(voIdsList);
		  for(User user:selectUserByIds){
			  System.out.println(user);
		  }
		  
		  */
///////////////////////////////////////////////////////////////////////////////////////
		  
/////////////   尝试着Integer   ///////////////////////////////////////////////////////
		  Integer[] ids=new Integer[3];
		  ids[0]=24;
		  ids[1]=25;
		  ids[2]=26;
		  QueryVo voIds=new QueryVo();
		  voIds.setIds(ids);
		  List<User> selectUserByIds2 = userMapper.selectUserByIds(voIds);
		  
		  for(User userids:selectUserByIds2){
		    System.out.println(userids);
		  }
	}
}
