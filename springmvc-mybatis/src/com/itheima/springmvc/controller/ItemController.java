package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	//入门程序
	@RequestMapping(value = "/item/itemlist.action")//导航栏输入的东西
	public ModelAndView itemList(){
		
		ModelAndView mav=new ModelAndView();
		List<Items> list = itemService.selectItemList();
		
		mav.addObject("itemList", list);//实际是放在request域里
		//mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		//在springmvc配置，可以简写以上的代码
		mav.setViewName("itemList");
		
		return mav;
	}
	
  @RequestMapping(value = "/itemEdit.action")
  public ModelAndView itemEdit(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
	  
	  String id = request.getParameter("id");
	  
	  Items item = itemService.selectItemById(Integer.parseInt(id));
	  ModelAndView mav=new ModelAndView();
	  mav.addObject("item",item);
	  mav.setViewName("editItem");
	  
	  return mav;
  }
  
  @RequestMapping(value="updateitem.action")
 public ModelAndView updateitem(Items item){
	  itemService.updateItem(item);
	  ModelAndView mav=new ModelAndView();
	 
	  mav.setViewName("success");
	  
	return mav;
	  
  }


}
