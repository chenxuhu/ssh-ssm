package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;

@Controller
public class ItemController {
	
	//入门程序
	@RequestMapping(value = "/item/itemlist.action")//导航栏输入的东西
	public ModelAndView itemList(){
		
		ModelAndView mav=new ModelAndView();
		
	   ArrayList<Items> list = new ArrayList<>();
	    list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		
		mav.addObject("itemList", list);//实际是放在request域里
		//mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		//在springmvc配置，可以简写以上的代码
		mav.setViewName("itemList");
		
		return mav;
		
	}


}
