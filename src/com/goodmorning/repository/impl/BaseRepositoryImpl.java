package com.goodmorning.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.goodmorning.bean.Pagination;
import com.goodmorning.repository.IBaseRepository;
import com.mongodb.WriteResult;


@Repository("baseRepository")
public class BaseRepositoryImpl<T> implements IBaseRepository<T>{

	@Resource(name="mongoTemplate")
	MongoTemplate mongoTemplate;
	
	
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	@Override
	public List<T> getAllObjects() throws Exception {
		return mongoTemplate.findAll(getTclass());
	}

	@Override
	public void saveObject(T object) throws Exception {
		
		mongoTemplate.insert(object);
	}

	@Override
	public T getObject(String id) throws Exception {
		
	 return (T) mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), getTclass());
	}

	@Override
	public WriteResult updateObject(String id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObject(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCollection() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropCollection() throws Exception {
		// TODO Auto-generated method stub
		
	}

	private Class getTclass(){
		return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public Pagination<T> getPageData(Query query, Pagination<T> pagination)
			throws Exception {
			//获取总条数
		    long totalCount = this.mongoTemplate.count(query, this.getTclass()); 
		    pagination= new Pagination(pagination.getPageNo(), pagination.getPageSize(), totalCount);
		    query.skip(pagination.getFirstResult());// skip相当于从那条记录开始
			// 从skip开始,取多少条记录
			query.limit(pagination.getPageSize());
			List<T> datas = this.mongoTemplate.find(query, getTclass());
			pagination.setDatas(datas);
			return pagination;
	}

	@Override
	public List<T> find(Query query) throws Exception {
		return  mongoTemplate.find(query, getTclass());
	}

}
