package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.User;

public interface OrdersMapper {
	
	public List<Orders> selectOrderList();
	
	//一对一，以订单为中心
	public List<Orders> selectOrders();
	
	//一对多
	public List<User> selectUserList();

}
