package com.goodmorning.util;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


public class PubFun {
	/**
	 * 获得系统时间Date
	 * ***/
	public static Date getDate(String format, String date) throws Exception {
		Date d = null;
		SimpleDateFormat  sdf = new  SimpleDateFormat(format);  
		if(date!=null){
			d = sdf.parse(date);
		}else{
			d = sdf.parse(PubFun.getDateTime(format,null));
		}
		return d;
		
	}
	public static String getDateTime(String format, Date date) throws Exception {
		String result = null;
		Calendar c = Calendar.getInstance();
		if (date != null)
			c.setTime(date);
		SimpleDateFormat f = new SimpleDateFormat(format);
		result = f.format(c.getTime());
		return result;
	}
	public static String changeDateTime(String dateTime) throws Exception{
		StringBuilder stb = new StringBuilder();
		if(dateTime.trim().length()==14){
			stb.append(dateTime.substring(0,4)+"-");
			stb.append(dateTime.substring(4,6)+"-");
			stb.append(dateTime.substring(6,8)+" ");
			stb.append(dateTime.substring(8,14));
		}
		return stb.toString();
	}
	//充值变更时间格式
	public static String changeDTime(String dateTime) throws Exception{
		StringBuilder stb = new StringBuilder();
		if(dateTime.trim().length()==8){
			stb.append(dateTime.substring(0,4)+"-");
			stb.append(dateTime.substring(4,6)+"-");
			stb.append(dateTime.substring(6,8)+" ");
		}
		return stb.toString();
	}
	//判断是否为数字
	public static boolean isNumeric(String str) throws Exception {
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	} 
	//字符串截取
	public static String strCut(String v,int b,int e) throws Exception{
		return v.substring(b,e);
	}
	//身份证验证
	public static boolean isCredentialsNum(String credentialsNum) throws Exception{
		boolean s = false;
		if(credentialsNum.trim().length()==15||credentialsNum.trim().length()==18){
			if(credentialsNum.trim().length()==15){
				s = isNumeric(credentialsNum);
			}else{
				if(isNumeric(strCut(credentialsNum,0,17))&&("X".equals(strCut(credentialsNum,17,18))||"x".equals(strCut(credentialsNum,17,18)))){
					s = true;
				}else if(isNumeric(credentialsNum)){
					s = true;
				}
			}
		}
		return s;
	}
	//判断代收金额
	public static boolean isPayAMount(String payAMount) throws Exception{
		boolean s = false;
		String b = payAMount.substring(0,1);
		String e = payAMount.substring(payAMount.length()-1,payAMount.length());
		if(payAMount.indexOf(".")!=-1&&!".".equals(b)&&!".".equals(e)){//判断是否有点,点的位置是否是开头和结尾
			String[] src = payAMount.split("\\.");
			if(!(src[0].length()>1&&"0".equals(b))){//判断数字首位是否是0
				if(src[1].length()==2&&isNumeric(src[0])&&isNumeric(src[1])&&src.length==2&&Double.valueOf(payAMount)>0.00){//验证是否有一个小数点,是否是数字,小数点后是否保留两位
					s = true;
				}
			}
		}
		return s;
	}
	//验证开户省
	public static boolean isProvince(String province) throws Exception{
		boolean s = false;
		String v = "北京市*上海市*广东省*安徽省*重庆市*福建省*甘肃省*广西自治区*贵州省*海南省*河北省*河南省*黑龙江省*湖北省*湖南省*江苏省*江西省*吉林省*辽宁省*内蒙古自治区*宁夏自治区*青海省*山东省*山西省*陕西省*四川省*天津市*新疆自治区*西藏自治区*云南省*浙江省";
		String[] src = v.split("\\*");
		for(int i=0;i<src.length;i++){
			if(province.equals(src[i])){
				s = true;
			}
		}
		return s;
	}
	//判断是否为null并替换默认
	public static String instandNull(String v,String f){
		return v==null?f:v;
	}
	
	//检查文件是否存在
	public static boolean isFileExist(String path) throws Exception{
		boolean f = false;
		try{
			if(new File(path).exists()){
				f = true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return f;
	}
	//根据当前日期得到一个月以前的日期
		public static String monthAgo() throws Exception{
			String monthAgo = "";
			String year = "";
			String month = "";
			String day = "";
			try{
				Calendar calendar = Calendar.getInstance();    
				calendar.add(Calendar.MONTH, -1);    //得到前一个月
				year = String.valueOf(calendar.get(Calendar.YEAR));
				month = String.valueOf(calendar.get(Calendar.MONTH)+1);
				day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
				monthAgo = year + "-" + month + "-" + day;
				monthAgo = PubFun.getDateTime("yyyy-MM-dd", PubFun.getDate("yyyy-MM-dd", monthAgo));
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return monthAgo;
		}
		//分页计算总页数
		public static int totalPageNo(int countNo,int pageSize) throws Exception{
			int totalPageNo = 0;
			try{
				if(countNo%pageSize==0&&countNo!=0){
					totalPageNo = countNo/pageSize;
				}else{
					totalPageNo = countNo/pageSize+1;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return totalPageNo;
		}
		//计算分页起始数值
		public static int acountLimitNo(int pageNo,int pageSize) throws Exception{
			int n = 0;
			try{
				n = pageNo*pageSize;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return n;
		}
		//转换double过亿的数值
		public static String changeDouble(double v) throws Exception{
			String cv = "0.00";
			try{
				DecimalFormat df = new DecimalFormat("0.00");
				cv = df.format(v);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return cv;
		}	
	public static String getNow(){
		String nowStr = "";
		SimpleDateFormat  sdf = new  SimpleDateFormat("yyyy-MM-dd HHmmss");
		nowStr=sdf.format(new Date());
		return nowStr;
	}
	public static String getDate(){
		String nowStr = "";
		SimpleDateFormat  sdf = new  SimpleDateFormat("yyyyMMdd");
		nowStr=sdf.format(new Date());
		return nowStr;
	}
	//查询结束时间+1
	public static String updateEndDate(String endDate) throws Exception{
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
            Calendar cd = Calendar.getInstance();   
            cd.setTime(sdf.parse(endDate));   
            cd.add(Calendar.DATE, 1);//增加一天   
            endDate = sdf.format(cd.getTime());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return endDate;
	}	


	/**
	 * 根据金额和批处理数自动算出批处理的金额
	 * */
	public static List<Object> autoCountFunds(Double funds, Double maxNum){
		ArrayList<Object> list=new ArrayList<Object>();
		try{
			int countNo = cashByMaxSplit(funds,maxNum);
			if(funds>0&&countNo>0){
				if(funds>maxNum){
					String[] src = String.valueOf(funds).split("\\.");
					String funds1 = src[0];
					String funds2 = src[1];
					int imInt = (int)Math.floor(maxNum);
					int imDouble = Integer.parseInt(funds1)-imInt*countNo;
					for(int i=0;i<countNo+1;i++){
						if(i!=countNo){
							list.add(imInt+".00");
						}else{
							list.add(imDouble+"."+funds2);
						}
					}
				}else{
					list.add(funds);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			list = null;
		}
		return list;
	}
	/**
	 * 按提现的最大金额获得拆分数
	 * */
	public static int cashByMaxSplit(Double totalNum, Double maxNum){
		int n = 0;
		try{
			if(totalNum>0&&maxNum>0){
				if(totalNum>=maxNum){
					n = (int)Math.floor(totalNum/maxNum);
				}else{
					n = 1;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return n;
	}
	
	public static String getseqRandomNum(){
		String num="";
		try{
		int random=(int)(Math.random()*1000000);
		num=String.valueOf(random);
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	
	public static void main(String[] arg) throws Exception{
//		String msg = "<P2PREQ><RESPTIME>null</RESPTIME><SERIALNUM>YZFDS0000000000781</SERIALNUM><CARDNUM>6212260200018899902</CARDNUM><ACCOUNTNAME>杨宇轩</ACCOUNTNAME><PAYAMOUNT>20.00</PAYAMOUNT><RESULTCODE>06</RESULTCODE><RESULTDESC></RESULTDESC><EXTPARAMES><PARAMEKEY>null</PARAMEKEY><PARAMEVALUE>null</PARAMEVALUE></EXTPARAMES></P2PREQ>";
//		Document doc = DocumentHelper.parseText(msg);
//		Element acountNameE = (Element) doc.selectNodes("/P2PREQ/ACCOUNTNAME");
//		String acountName = acountNameE.getText();
//		System.out.println(acountName);
//		String f = "1.00";
//		Double d = Double.valueOf(f).doubleValue();
//		System.out.println(d);
//		String date = "20140102121501";
//		date = PubFun.changeDateTime(date);
//		Date d = null;
//		try{
//			d = PubFun.getDate("yyyy-MM-dd HHmmss", date);
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//		System.out.println(d);
//		String a = base64Fun("王丽文");
//		System.out.println(a);
//		System.out.println(new String(Base64.decode(a)));
//		Double a = 0.00;
//		if(a==0){
//			System.out.println(true);
//		}
//		int a = 1701;
//		int b = 5;
//		System.out.println("结果::::"+a/b+"=====余数::::"+a%b);
		/**
		 * 按拆分数拆分提现金额
		 * */
//		int d = cashByMaxSplit("7232.01","723265.01");
//		System.out.println("拆分数"+d);
		 List<Object> list = autoCountFunds(671.13,171.01);
		 System.out.println("总金额批次数::::"+list.size());
		 Iterator<Object> iterList=list.iterator();
		 int i=0;
		 while(iterList.hasNext()){
		   iterList.next();
		   System.out.println("第"+(i+1)+"批金额:::"+list.get(i));
		   i++;
		 }
//		Double d = 639.00;
//		Double d1 = 723.01;
//		System.out.println(d1-d);
//		int a = (int)Math.floor(d/d1);
//		System.out.println(a);
	}

	
}
