/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.Page;



public class ProductAction extends Action4Result {

	@Action("admin_product_list")
	public String list() {
		if(page==null)
			page = new Page();
		int total = productService.total(category);
		page.setTotal(total);
		page.setParam("&category.id="+category.getId());
		products = productService.list(page,category);
		for (Product product : products) {
			productImageService.setFirstProdutImage(product);
		}
		
		t2p(category);
		
		return "listProduct";
	}
	
	@Action("admin_product_add")
	public String add() {
		product.setCreateDate(new Date());
		productService.save(product);
		return "listProductPage";
	}
	
	@Action("admin_product_delete")
	public String delete() {
		t2p(product);
		productService.delete(product);
		return "listProductPage";
	}
	
	@Action("admin_product_edit")
	public String edit() {
		t2p(product);
		return "editProduct";
	}
	@Action("admin_product_update")
	public String update() {
		Product productFromDB= (Product)productService.get(product.getId());
		product.setCreateDate(productFromDB.getCreateDate());
		
		productService.update(product);
		return "listProductPage";
	}




}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
