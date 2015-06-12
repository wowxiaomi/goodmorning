package com.goodmorning.util;

import static java.lang.System.out;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoDBTool {

	private static Mongo mongo;
	
	public MongoDBTool(){
	
	}

	public static void init(){
		try{
			mongo=new Mongo("115.159.28.221",27017);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static DB getDB(String dbName){
		if(mongo==null){
			
		}
		return mongo.getDB(dbName);
	}

	public static DBCollection getTable(DB db,String tableName){
		DBCollection dbc=null;
		try{
			dbc=db.getCollection(tableName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dbc;
	}
	
	public static void getAllDB(){
		init();
		for(String dbname:mongo.getDatabaseNames()){
			out.println(dbname);
		}
	}
	
	public static void getAllTable(String dbName){
		init();
		DB db=getDB(dbName);
		for(String tableName:db.getCollectionNames()){
			out.println(tableName);
		}
	}
	
	public static void addUser(){
		init();
		DB db=getDB("clocktenten");
		DBObject user=new BasicDBObject();
		user.put("_user_id", "20000");
		user.put("_user_name", "runingman");
		user.put("_user_age", 19);
		DBCollection users=db.getCollection("users");
		out.println(users.save(user).getN());
	}
	
	public static void queryUsers(){
		init();
		DB db=getDB("clocktenten");
		DBCollection users=db.getCollection("users");
		DBCursor cur= users.find();
		while(cur.hasNext()){
			out.println(cur.next());
		}
	}
	
	
	public static void main(String[] args){
//		DB db=MongoDBTool.getDB("clocktenten");
//		DBCollection dbc = MongoDBTool.getTable(db,"users");
		getAllDB();
//		getAllTable("clocktenten");
//		addUser();
//		queryUsers();
	}
	
	
}
