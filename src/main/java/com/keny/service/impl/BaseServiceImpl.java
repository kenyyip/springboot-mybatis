package com.keny.service.impl;

import com.keny.dao.BaseMapper;
import com.keny.pager.Page;
import com.keny.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T, Serializable> {

	@Autowired
	private BaseMapper<T, Serializable> baseMapper;
	
	@Override
	public int deleteById(Serializable id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int add(T record) {
		return baseMapper.insert(record);
	}

	@Override
	public int addSelective(T record) {
		return baseMapper.insertSelective(record);
	}
	
	@Override
	public int addSelectiveBatch(List<T> items){
		return baseMapper.insertSelectiveBatch(items);
	}

	@Override
	public T getById(Serializable id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateSelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

	@Override
	public Page<T> findByParamPage(Map<String,Object> params){
		
		Page<T> page = new Page<>();
		
		page.setPageNo(Integer.valueOf(params.get("pageNo").toString()));
		page.setPageSize(Integer.valueOf(params.get("pageSize").toString()));
		
		params.remove("pangeNo");
		params.remove("pageSize");
		
		page.setParams(params);
		List<T> results = baseMapper.selectByParamPage(page);
		
		page.setResults(results);
		
		return page;
	}
}
