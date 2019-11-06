package com.itheima.mybatis.mapper;

import java.util.List;

import org.junit.Test;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public interface UserMapper {
	//遵循四个原则
		//接口 方法名  == User.xml 中 id 名
		//返回值类型  与  Mapper.xml文件中返回值类型要一致
		//方法的入参类型 与Mapper.xml中入参的类型要一致
		//命名空间 绑定此接口
	public User findUserById(Integer id);
	//包装类
	public List<User> findUserByQueryVo(QueryVo vo);
	//查询条数
	public Integer countUser();
	
	//and查询sex和username，对and的用户，动态sql
	public List<User> selectUserSexandUsername(User user);
	
	//根据多个id查询
	/*
	public List<User> selectUserByIds(Integer[] ids) ;collection="array"必须是array
	public List<User> selectUserByIds(List<Integer> ids) ;collection="list"必须是list
	*/
	
	
	public List<User> selectUserByIds(QueryVo ids) ;
	

}
