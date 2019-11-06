package com.itheima.bos.web.action;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;
import org.omg.IOP.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkordermanageService;
import com.itheima.bos.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage>{

	@Autowired
	private IWorkordermanageService  workordermangeService;
	public String add() throws IOException{
		String f="1";
		try{
		
			workordermangeService.save(model);
		}catch (Exception e) {
			f="0";
		e.printStackTrace();
		}
	   ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
	   ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}

}
