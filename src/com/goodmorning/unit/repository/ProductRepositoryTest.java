package com.goodmorning.unit.repository;

import java.util.List;

import com.goodmorning.bean.Pagination;
import com.goodmorning.bean.Product;
import com.goodmorning.repository.IProductRepository;

public class ProductRepositoryTest extends UnitTest{

	public static void saveProductInfo(){
		IProductRepository productRepository=(IProductRepository) getBean("productRepository");
		Product product=new Product();
		product.setmId("888888");
		product.setPchannel("tb");
		product.setpDesc("verygood");
		product.setPid("888888-001");
		product.setPimageUrl("http://img14.360buyimg.com/n4/jfs/t277/193/1005339798/768456/29136988/542d0798N19d42ce3.jpg");
		product.setpName("iphone");
		product.setPrice("5288");
		try {
			productRepository.saveObject(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void queryProductInfo() throws Exception{
		IProductRepository productRepository=(IProductRepository) getBean("productRepository");
		List<Product> products=productRepository.getAllObjects();
		System.out.println(products.size());
		for(Product product:products){
			System.out.println(product.getmId());
			System.out.println(String.valueOf(product.get_id()));
			System.out.println(product.getPimageUrl());
		}
		
	}
	
	public static void queryProductTop5()throws Exception{
		IProductRepository productRepository=(IProductRepository) getBean("productRepository");
		List<Product> products=productRepository.findHotTop5();
		for(Product product:products){
			System.out.println(product.getmId());
			System.out.println(product.get_id());
		}
	}
	
	public static void main(String[] args)throws Exception{
//		saveProductInfo();
		queryProductInfo();
//		queryProductTop5();
	}
	
	
}
