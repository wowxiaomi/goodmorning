package com.goodmorning.bean;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4497191540474625794L;
	private String mId;
	private String pid;
	private String pName;
	private String pimageUrl;
	private String pDesc;
	private String price;
	private String pchannel;
	private String _id;
	private String pcrated;
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPimageUrl() {
		return pimageUrl;
	}
	public void setPimageUrl(String pimageUrl) {
		this.pimageUrl = pimageUrl;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPchannel() {
		return pchannel;
	}
	public void setPchannel(String pchannel) {
		this.pchannel = pchannel;
	}
	public String get_id() {
		return _id;
	}
	public String getPcrated() {
		return pcrated;
	}
	public void setPcrated(String pcrated) {
		this.pcrated = pcrated;
	}
	
	
}
