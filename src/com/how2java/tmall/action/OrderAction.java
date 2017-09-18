/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.util.Page;

public class OrderAction extends Action4Result {

	@Action("admin_order_list")
	public String list() {
		if (page == null)
			page = new Page();
		int total = orderService.total();
		page.setTotal(total);
		orders = orderService.listByPage(page);
		orderItemService.fill(orders);
		return "listOrder";
	}

	@Action("admin_order_delivery")
	public String delivery() {
		t2p(order);
		order.setDeliveryDate(new Date());
		order.setStatus(OrderService.waitConfirm);
		orderService.update(order);
		return "listOrderPage";
	}

}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
