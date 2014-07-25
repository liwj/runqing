package com.jynine.dao;

import com.jynine.model.Role;

/**
 * 角色Dao
 * <p>Title: RoleDao.java</p>
 * <p>Description: </p>
 * <p>Company: CST</p>
 * @author caijy
 * @date 2014-7-10
 */
public interface RoleDao extends BaseDao{
	public Role findAll();
}
