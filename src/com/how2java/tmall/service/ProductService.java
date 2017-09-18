/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;

public interface ProductService extends BaseService {
	public void fill(List<Category> categorys);
	public void fill(Category category);
	public void fillByRow(List<Category> categorys);
	public void setSaleAndReviewNumber(Product product);
	public void setSaleAndReviewNumber(List<Product> products);
	public List<Product> search(String keyword, int start, int count);	
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
