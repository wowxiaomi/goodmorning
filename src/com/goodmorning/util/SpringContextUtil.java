package com.goodmorning.util;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil  {  
	 private static BeanFactory factory;

	  public static synchronized Object getBean(String beanName)
	  {
	    if (factory == null) {
	      factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");;
	    }
	    return factory.getBean(beanName);
	  }
    
    public static void main(String[] args){
    }
    
    
}