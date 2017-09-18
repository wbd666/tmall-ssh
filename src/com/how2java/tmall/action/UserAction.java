/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.util.Page;


public class UserAction extends Action4Result {
	
	@Action("admin_user_list")
	public String list() {
		if(page==null)
			page = new Page();
		int total = userService.total();
		page.setTotal(total);
		users = userService.listByPage(page);
		return "listUser";
	}
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
