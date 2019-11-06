package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

/*
 * 客户管理
 * 
 */
@Controller
public class CustomerController {
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private  CustomerService customerService;
	
	

	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(CUSTOMER_FROM_TYPE);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(CUSTOMER_INDUSTRY_TYPE);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(CUSTOMER_LEVEL_TYPE);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件，查询
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
		
	}
	
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer toEdit(Integer id){
		return	customerService.selectCustomerById(id);
	}
	
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		customerService.updateCustomer(customer);
		return "OK";
	}
	
	
	
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody
	String deleteCustomerById(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
