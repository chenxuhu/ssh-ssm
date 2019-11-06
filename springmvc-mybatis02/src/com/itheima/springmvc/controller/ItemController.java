package com.itheima.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	//入门程序 第一   包类 + 类包 + 方法名
		/**
		 * 1.ModelAndView  无敌的    带着数据  返回视图路径           不建议使用
		 * 2.String    返回视图路径     model带数据      官方推荐此种方式   解耦   数据  视图  分离  MVC  建议使用  
		 * 3.void       ajax  请求   合适   json格式数据 （response   异步请求使用
		 * @return
		 * @throws IOException 
		 * @throws ServletException 
		 * @throws MessageException 
		 */
////////////////////     三种方式                         ////////////////////////////////////////////////
	
	//方式1
/*	@RequestMapping(value = "/item/itemlist.action")//导航栏输入的东西
	public ModelAndView itemList(){
		
		ModelAndView mav=new ModelAndView();
		List<Items> list = itemService.selectItemList();
		
		mav.addObject("itemList", list);//实际是放在request域里
		//mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		//在springmvc配置，可以简写以上的代码
		mav.setViewName("itemList");
		
		return mav;
	}
	*/
	
	//方式2
	
	@RequestMapping(value = "/item/itemlist.action")
	public String itemList(Model model){
		List<Items> list = itemService.selectItemList();
		model.addAttribute("itemList", list);
		
		return "itemList";
		
	}
	
	
	//方式3
/*	@RequestMapping(value = "/item/itemlist.action")
	public void itemList(Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<Items> list = itemService.selectItemList();
		model.addAttribute("itemList", list);
		request.getRequestDispatcher("itemList").forward(request, response);
		
	}
	*/
////////////////////////////////////////////////////////////////////////////////////////////////
	
	//
	
	
	
	
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
 
 // public ModelAndView deletes(Integer[] ids){
  @RequestMapping(value="deletes.action")
	  public ModelAndView deletes(QueryVo vo){
	  
	  ModelAndView mav=new ModelAndView();
	 
	  mav.setViewName("success");
	  
	return mav;
	  
  }
  //修改
  @RequestMapping(value="/updates.action",method={RequestMethod.GET,RequestMethod.POST})
 public ModelAndView updates(QueryVo vo,MultipartFile sf){
	  
	  ModelAndView mav=new ModelAndView();
	 
	  mav.setViewName("success");
	  
	return mav;
	  
  }


}
