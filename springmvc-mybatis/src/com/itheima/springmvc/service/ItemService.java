package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface ItemService {
	
	public List<Items> selectItemList();
	

	//商品查找
	public Items selectItemById(Integer id);
	//商品修改
	public void updateItem(Items item);

}
