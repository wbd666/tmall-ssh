/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;



public class PropertyValueAction extends Action4Result {

	
	@Action("admin_propertyValue_edit")
	public String edit() {
		//初始化
		t2p(product);
		propertyValueService.init(product);
		propertyValues = propertyValueService.listByParent(product); 
		return "editPropertyValue";
	}
	@Action("admin_propertyValue_update")
	public String update() {
		String value = propertyValue.getValue();
		t2p(propertyValue);
		propertyValue.setValue(value);
		propertyValueService.update(propertyValue);
		return "success.jsp";
	}
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
