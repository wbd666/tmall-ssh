/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductImageService;

@Service
public class OrderItemServiceImpl  extends BaseServiceImpl implements OrderItemService {

	
	@Autowired
	ProductImageService productImageService;
	
	@Override
	public void fill(List<Order> orders) {
		for (Order order : orders) 
			fill(order);
	}
	public void fill(Order order) {
			List<OrderItem> orderItems= this.listByParent(order);
			order.setOrderItems(orderItems);
			
			float total = 0;
			int totalNumber = 0;			
			for (OrderItem oi :orderItems) {
				total+=oi.getNumber()*oi.getProduct().getPromotePrice();
				totalNumber+=oi.getNumber();
				
				productImageService.setFirstProdutImage(oi.getProduct());
			}
			order.setTotal(total);
			order.setOrderItems(orderItems);
			order.setTotalNumber(totalNumber);
	}



	
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
