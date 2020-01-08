package com.keny.dao;

import com.keny.pager.Page;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T, PK extends Serializable> {

	/**
	 * 根据主键删除
	 * @param id
	 * @return 删除个数
	 * @throws DataAccessException
	 */
	int deleteByPrimaryKey(PK id) throws DataAccessException;

	/**
	 * 插入，空属性也会插入
	 * @param record
	 * @return 插入个数
	 * @throws DataAccessException
	 */
	int insert(T record) throws DataAccessException;

	/**
	 * 插入，空属性不会插入
	 * @param record
	 * @return
	 * @throws DataAccessException
	 */
	int insertSelective(T record) throws DataAccessException;

	/**
	 * 批量插入数据
	 * @param items
	 * @return
	 */
	public int insertSelectiveBatch(List<T> items) throws DataAccessException;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return pojo对象
	 * @throws DataAccessException
	 */
	T selectByPrimaryKey(PK id) throws DataAccessException;

	/**
	 * 根据主键修改，空值条件不会修改成null
	 * @param record
	 * @return
	 * @throws DataAccessException
	 */
	int updateByPrimaryKeySelective(T record) throws DataAccessException;

	/**
	 * 根据主键修改，空值条件会修改成null
	 * @param record
	 * @return
	 * @throws DataAccessException
	 */
	int updateByPrimaryKey(T record) throws DataAccessException;

	/**
	 * 根据查询条件分页查询
	 * @param page
	 * @return page对象集合
	 * @throws DataAccessException
	 */
	public <T> List<T> selectByParamPage(Page<T> page) throws DataAccessException;

}