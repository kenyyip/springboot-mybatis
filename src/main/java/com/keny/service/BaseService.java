package com.keny.service;

import com.keny.pager.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T, PK extends Serializable> {

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return 删除个数
	 */
	int deleteById(PK id);

	/**
	 * 插入，空属性也会插入
	 * 
	 * @param record
	 * @return 插入个数
	 */
	int add(T record);

	/**
	 * 插入，空属性不会插入
	 * 
	 * @param record
	 * @return
	 */
	int addSelective(T record);
	
	/**
	 * 批量插入，空属性不会插入
	 * 
	 * @param items
	 * @return
	 */
	int addSelectiveBatch(List<T> items);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return pojo对象
	 */
	T getById(PK id);

	/**
	 * 根据主键修改，空值条件不会修改成null
	 * 
	 * @param record
	 * @return
	 */
	int updateSelective(T record);

	/**
	 * 根据主键修改，空值条件会修改成null
	 * 
	 * @param record
	 * @return
	 */
	int update(T record);

	/**
	 * 根据查询条件分页查询
	 * 
	 * @param params
	 * @return page
	 */
	public Page<T> findByParamPage(Map<String, Object> params);
}
