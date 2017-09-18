/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	

package com.how2java.tmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.ReviewService;

@Service
public class ProductServiceImpl  extends BaseServiceImpl implements ProductService {

	
	@Autowired
	ProductImageService productImageService;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	ReviewService reviewService;
	
	@Override
	public List<Product> search(String keyword, int start, int count) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.like("name", "%"+keyword+"%"));
		return findByCriteria(dc,start,count);
	}	
	@Override
	public void setSaleAndReviewNumber(Product product) {
		int saleCount = orderItemService.total(product);
		product.setSaleCount(saleCount);
		int reviewCount = reviewService.total(product);
		product.setReviewCount(reviewCount);
	}
	
	@Override
	public void setSaleAndReviewNumber(List<Product> products) {
		for (Product product : products) {
			setSaleAndReviewNumber(product);
		}
	}
	
	
	public void fill(List<Category> categorys) {
		for (Category category : categorys) {
			fill(category);
		}
	}

	@Override
	public void fillByRow(List<Category> categorys) {
		int productNumberEachRow = 8;
		for (Category category : categorys) {
			List<Product> products =  category.getProducts();
			List<List<Product>> productsByRow =  new ArrayList<>();
			for (int i = 0; i < products.size(); i+=productNumberEachRow) {
				int size = i+productNumberEachRow;
				size= size>products.size()?products.size():size;
				List<Product> productsOfEachRow =products.subList(i, size);
				productsByRow.add(productsOfEachRow);
			}
			
			
			category.setProductsByRow(productsByRow);
		}
	}
	
	@Override
	public void fill(Category category) {
		List<Product> products= listByParent(category);
		
		for (Product product : products) 
			productImageService.setFirstProdutImage(product);
		
		
		category.setProducts(products);
		
	}	
}

/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	
