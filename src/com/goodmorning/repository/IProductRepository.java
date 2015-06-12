package com.goodmorning.repository;

import java.util.List;

import com.goodmorning.bean.Pagination;
import com.goodmorning.bean.Product;


public interface IProductRepository extends IBaseRepository<Product>{

	public Product findProductBy(String pid)throws Exception;
	public List<Product> findHotTop5() throws Exception;
	public Pagination<Product> findNewProducts(Pagination<Product> page) throws Exception;
}
