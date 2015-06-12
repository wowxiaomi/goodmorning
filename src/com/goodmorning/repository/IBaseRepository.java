package com.goodmorning.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import com.goodmorning.bean.Pagination;

public interface IBaseRepository <T>{
	
	public List<T> getAllObjects() throws Exception;
	 
    public void saveObject(T object) throws Exception;
 
    public T getObject(String id) throws Exception;
 
    public WriteResult updateObject(String id, String name) throws Exception;
 
    public void deleteObject(String id) throws Exception;
 
    public void createCollection() throws Exception;
 
    public void dropCollection() throws Exception;
    
    public List<T> find(Query query) throws Exception;
    
    public Pagination<T> getPageData(Query query,Pagination<T> pagination)throws Exception;
    
}
