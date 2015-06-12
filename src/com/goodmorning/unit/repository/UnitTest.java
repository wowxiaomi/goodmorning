package com.goodmorning.unit.repository;

import com.goodmorning.util.SpringContextUtil;

public class UnitTest {

	public static Object getBean(String beanName){
		Object object=null;
		object = SpringContextUtil.getBean(beanName);
		return object;
	}
	public static void main(String[] arg) throws Exception{
		
	}
}
