/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
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
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	
