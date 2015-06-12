package com.goodmorning.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.goodmorning.bean.Pagination;
import com.goodmorning.bean.Product;
import com.goodmorning.repository.IProductRepository;

@Repository("productRepository")
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements IProductRepository{

	@Resource(name="mongoTemplate")
	MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public Product findProductBy(String pid) throws Exception{
		
		return null;
	}

	@Override
	public List<Product> findHotTop5()
			throws Exception {
		Query query=new Query();
		query.with(new Sort(Sort.Direction.DESC,"pcrated")).limit(5);
		List<Product> products=find(query);
		return products;
	}

	@Override
	public Pagination<Product> findNewProducts(Pagination<Product> page)
			throws Exception {
		Query query=new Query();
		query.with(new Sort(Sort.Direction.DESC,"mId"));
		page=getPageData(query, page);
		return page;
	}
	
	
}
