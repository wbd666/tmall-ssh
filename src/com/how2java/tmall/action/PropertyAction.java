/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;
 
import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.util.Page;
 
public class PropertyAction extends Action4Result{
     
	@Action("admin_property_list")
	public String list() {
		if(page==null)
			page = new Page();
		int total = propertyService.total(category);
		page.setTotal(total);
		page.setParam("&category.id="+category.getId());
		propertys = propertyService.list(page,category);
		t2p(category);
		return "listProperty";
	}
	
	@Action("admin_property_add")
	public String add() {
		propertyService.save(property);
		return "listPropertyPage";
	}
	
	@Action("admin_property_delete")
	public String delete() {
		t2p(property);
		propertyService.delete(property);
		return "listPropertyPage";
	}
	
	@Action("admin_property_edit")
	public String edit() {
		t2p(property);
		return "editProperty";
	}
	@Action("admin_property_update")
	public String update() {
		propertyService.update(property);
		return "listPropertyPage";
	}

}
/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
