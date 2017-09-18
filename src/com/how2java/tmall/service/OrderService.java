/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;

public interface OrderService extends BaseService {
	public static final String waitPay = "waitPay";
	public static final String waitDelivery = "waitDelivery";
	public static final String waitConfirm = "waitConfirm";
	public static final String waitReview = "waitReview";
	public static final String finish = "finish";
	public static final String delete = "delete";	
	
	public float createOrder(Order order, List<OrderItem> ois);

	public List<Order> listByUserWithoutDelete(User user);
	
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
