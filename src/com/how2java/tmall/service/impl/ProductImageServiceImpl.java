/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl  extends BaseServiceImpl implements ProductImageService {

	@Override
	public void setFirstProdutImage(Product product) {
		if(null!=product.getFirstProductImage())
			return;
		List<ProductImage> pis= list("product", product, "type", ProductImageService.type_single);
		if(!pis.isEmpty())
			product.setFirstProductImage(pis.get(0));
	}
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
