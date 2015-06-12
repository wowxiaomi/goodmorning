package com.goodmorning.bean;

import java.io.Serializable;

public class Merchant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -774977864035077876L;
	
	private String merchantId;
	
	private String merchantName;
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	
	
}
