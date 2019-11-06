package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//总条数
	public Integer  cutomerCount(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//回显数据
	public Customer selectCustomerById(Integer id);
	//修改
	public void updateCustomer(Customer customer);
	//删除用户
	public void deleteCustomerById(Integer id);
}
