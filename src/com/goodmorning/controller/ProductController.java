package com.goodmorning.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodmorning.bean.Pagination;
import com.goodmorning.bean.Product;
import com.goodmorning.service.IProductService;
import com.goodmorning.util.PubFun;
import com.google.gson.Gson;

@Controller
public class ProductController {

	@Resource(name = "productService")
	private IProductService productService;

	@RequestMapping(value = "/product/submitinfo", method = RequestMethod.GET)
	public void submitProductInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String pmid = request.getParameter("mid");
		String pname = request.getParameter("pname");
		String ppirce = request.getParameter("ppirce");
		String pdesc = request.getParameter("pdesc");
		String pimageurl = request.getParameter("pimageurl");
		String pchannel = request.getParameter("pchannel");
		Product product = new Product();

		product.setmId(pmid);
		product.setpDesc(pdesc);
		product.setPid(pmid + PubFun.getseqRandomNum());
		product.setPimageUrl(pimageurl);
		product.setpName(pname);
		product.setPrice(ppirce);
		product.setPchannel(pchannel);
		String pcreated = "";
		try {
			pcreated = PubFun.getDateTime("yyyy-mm-dd HH:MM:ss", new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		product.setPcrated(pcreated);

		try {
			productService.saveProductInfo(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/product/queryProductlist", method = RequestMethod.GET)
	@ResponseBody
	public String queryProductlist(HttpServletRequest request,
			HttpServletResponse response) {
		String productListJson = "";
		try {
			Gson gson = new Gson();
			Pagination<Product> pagination = new Pagination<Product>();
			pagination = productService.findNewProducts(pagination);
			productListJson = gson.toJson(pagination);
			System.out.println(productListJson);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productListJson;
	}

	@RequestMapping(value = "/product/findHotTop5", method = RequestMethod.GET)
	@ResponseBody
	public String findHotTop5(HttpServletRequest request,
			HttpServletResponse response) {
		String productListJson = "";
		try {
			Gson gson = new Gson();
			List<Product> products = productService.findHotTop5();
			productListJson = gson.toJson(products);
			System.out.println(productListJson);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productListJson;
	}
}
