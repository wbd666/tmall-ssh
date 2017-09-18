/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl implements PropertyValueService {

	@Autowired
	PropertyService propertyService; 
	
	@Override
	public void init(Product product) {
		List<Property> propertys= propertyService.listByParent(product.getCategory());
		for (Property property: propertys) {
			PropertyValue propertyValue = get(property,product);
			if(null==propertyValue){
				propertyValue = new PropertyValue();
				propertyValue.setProduct(product);
				propertyValue.setProperty(property);
				save(propertyValue);
			}
		}
	}

	private PropertyValue get(Property property, Product product) {
		List<PropertyValue> result= this.list("property",property, "product",product);
		if(result.isEmpty())
			return null;
		return result.get(0);
		
	}
	
	

	
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
