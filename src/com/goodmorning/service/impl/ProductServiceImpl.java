package com.goodmorning.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.goodmorning.bean.Pagination;
import com.goodmorning.bean.Product;
import com.goodmorning.repository.IProductRepository;
import com.goodmorning.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService{

	@Resource(name = "productRepository")
	private IProductRepository productRepository;

	@Override
	public void saveProductInfo(Product product) throws Exception{
		productRepository.saveObject(product);
	}

	@Override
	public Product findProductBy(String pid) throws Exception {
		
		return null;
	}

	@Override
	public List<Product> findHotTop5() throws Exception {
		List<Product> products=productRepository.findHotTop5();
		return products;
	}

	@Override
	public Pagination<Product> findNewProducts(Pagination<Product> page)
			throws Exception {
		page=productRepository.findNewProducts(page);
		return page;
	}
	
	
	
}
