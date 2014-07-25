package com.jynine.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;

import com.jynine.model.Source;
/**
 * 资源加载
 * @ClassName: LoadSourceService
 * @Description: TODO
 * @author caijy caijiuyin@sina.com
 * @date 2014-7-5 下午6:51:26
 *
 */
public interface LoadSourceService {
	 /**
	  * 资源加载
	  * @return
	  */
	 void loadSource();
	 /**
	  * 得到所所有资源
	  * @return
	  */
	 List<Source> getAllSources();
	 /**
	  * 通过ID加载资源
	  * @param roleId
	  * @return
	  */
	 List<Source> getSourcesByRoleId(Integer roleId);
	
	 /**
	  * 获取可视资源
	  * @param roleId 
	  * @return
	  */
	 List<Source> getViewSourcesByRoleId(Integer roleId);
     /**
      *刷新资源 	 
      */
	 void reflushResource();
	 
	 /**
	  * 通过父资源节点获取子资源
	  * @param 父节点
	  * @return
	  */
	 List<Source> getSourcesBtn(String parentSourceId);
	 /**
	  * 通过sourceUrl得到权限资源
	  * @param sourceUrl
	  * @return
	  */
	 List<Source> getSourcesBtnsByUrl(String sourceUrl);
	 /**
	  * 通过资源url获取资源对应的角色权限
	  * @param sourceurl
	  * @return
	  */
	 List<Integer> getRolesBySourceUrl(String sourceurl);
	 /**
	  * 通过资源url获取资源对应的角色权限集合
	  * @param sourceurl
	  * @return
	  */
	  Collection<ConfigAttribute> getRoleCollectionBySourceUrl(String sourceurl);
}
