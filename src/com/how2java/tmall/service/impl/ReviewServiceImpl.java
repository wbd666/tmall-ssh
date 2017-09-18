/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.Review;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ReviewService;

@Service
public class ReviewServiceImpl  extends BaseServiceImpl implements ReviewService {

	@Autowired OrderService orderService;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void saveReviewAndUpdateOrderStatus(Review review, Order order) {
		orderService.update(order);
		save(review);
	}
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
