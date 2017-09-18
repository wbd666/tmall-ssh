/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;

@Service
public class OrderServiceImpl  extends BaseServiceImpl implements OrderService {

	@Autowired OrderItemService orderItemService;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public float createOrder(Order order, List<OrderItem> ois) {
		save(order);
		float total =0;
		for (OrderItem oi: ois) {
	        oi.setOrder(order);
	        orderItemService.update(oi);
	        total+=oi.getProduct().getPromotePrice()*oi.getNumber();
	    }
		return total;
	}

	@Override
	public List<Order> listByUserWithoutDelete(User user){
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq("user", user));
		dc.add(Restrictions.ne("status", OrderService.delete));
		return findByCriteria(dc);

	}
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
