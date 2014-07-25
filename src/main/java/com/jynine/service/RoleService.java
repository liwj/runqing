package com.jynine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jynine.dao.RoleDao;
import com.jynine.model.Role;
import com.jynine.page.PageBean;

@Service("roleService")
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public List<Role> getRoles(){
		return null;
	}
	/**
	 * 
	 * @param name
	 * @param pageIndex 
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageBean getList(String name,int pageIndex,int pageSize){
		int startIndex = (pageIndex-1) * pageSize;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		param.put("startIndex", startIndex);
		param.put("pageSize", pageSize);
		List<Role> list = (List<Role>) this.roleDao.getPageList(param);
		PageBean pb = new PageBean();
		pb.setList(list);
		return pb;
	}
	public PageBean getCount(String name,int pageIndex,int pageSize){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		int count = this.roleDao.getPageListCount(param);
		PageBean pb = new PageBean();
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		pb.setTotalPage(count);
		return pb;
	}
	/**
	 * <p>方法描述 : 查询所有角色信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月17日 下午4:02:30</p>
	 * @author 李文军
	 * @return
	 */
	public Role findAll(){
		return roleDao.findAll();
	}
}
