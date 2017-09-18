/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;

import java.lang.reflect.Method;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;
import com.how2java.tmall.service.ReviewService;
import com.how2java.tmall.service.UserService;

public class Action4Service extends Action4Pojo{

	@Autowired
	CategoryService categoryService;
	@Autowired
	PropertyService propertyService;
	@Autowired
	ProductService productService;	
	@Autowired
	ProductImageService productImageService;	
	@Autowired
	PropertyValueService propertyValueService;	
	@Autowired
	UserService userService;	
	@Autowired
	OrderService orderService;	
	@Autowired
	OrderItemService orderItemService;	
	@Autowired
	ReviewService reviewService;	
	/**
	 * transient to persistent
	 * 瞬时对象转换为持久对象
	 * @param o
	 */
	public void t2p(Object o){
			try {
				Class clazz = o.getClass();
				int id = (Integer) clazz.getMethod("getId").invoke(o);
				Object persistentBean = categoryService.get(clazz, id);

				String beanName = clazz.getSimpleName();
				Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);
				setMethod.invoke(this, persistentBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
