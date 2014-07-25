package com.jynine.dao;

import java.util.List;
import java.util.Map;
/**
 * 
 * <p>Title: BaseDao.java</p>
 * <p>Description: </p>
 * <p>Company: CST</p>
 * @author caijy
 * @date 2014-7-10
 */
public interface BaseDao {
	/**
	 * 获取分页的列表
	 * @param params
	 * @return
	 */
    List<?> getPageList(Map<String,Object> params);
	/**
	 * 获取总数
	 * @param params
	 * @return
	 */
	Integer getPageListCount(Map<String,Object> params);
}
