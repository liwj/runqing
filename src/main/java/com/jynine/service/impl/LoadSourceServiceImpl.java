package com.jynine.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.access.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;

import com.jynine.dao.SourceDao;
import com.jynine.model.Source;
import com.jynine.service.LoadSourceService;
import com.jynine.utils.CommonUtil;
/**
 * 加载资料类
 * @ClassName: LoadSourceImpl
 * @Description: TODO
 * @author caijy caijiuyin@sina.com
 * @date 2014-7-5 下午6:36:32
 *
 */
public class LoadSourceServiceImpl implements LoadSourceService{
	@Autowired 
	private SourceDao sourceDao;
	private Map<Integer, List<Source>> resources ;
	private List<Source> sourceList;
	private Logger logger = LoggerFactory.getLogger(LoadSourceServiceImpl.class);
	/**
	 * 加载资源
	 * @return
	 */
	public  void loadSource(){
		logger.error("---------->load source start.");
		if(resources == null || resources.isEmpty()){
			getAllSources();
			logger.error("---------->loading source  ...");
			resources = new ConcurrentHashMap<Integer,List<Source>>();
			for (int i = 0; i < sourceList.size(); i++) {
				Source source = sourceList.get(i);
				Integer roleId = source.getRoleId();
				List<Source> list;
				if(!resources.containsKey(roleId)){
					list = new ArrayList<>();
				}else{
					list = resources.get(roleId);
				}
				list.add(source);
				resources.put(roleId, list);
			}
		}
		logger.error("---------->loading source end.");
	}
	
	public List<Source> getAllSources(){
		if(sourceList == null || sourceList.size() == 0){			
			sourceList = sourceDao.queryAllSources();
		}
		return sourceList;
	}
	/**
	 * 通过角色ID加载资源
	 * @param roleId
	 * @return
	 */
	public List<Source> getSourcesByRoleId(){
		initResource();
		Integer roleId = CommonUtil.getRoleIdBySession();
		return resources.get(roleId);
	}
	/**
	 * 
	 * @param sourceurl
	 * @return
	 */
	public List<Integer> getRolesBySourceUrl(String sourceurl){
		getAllSources();
		List<Integer> roleIds = new ArrayList<>();
		for (Source source : sourceList) {
			if(source.getSourceurl().equals(sourceurl)){
				roleIds.add(source.getRoleId());
			}
		}
		return roleIds;
	}
	
	@Override
	public Collection<ConfigAttribute> getRoleCollectionBySourceUrl(
			String sourceurl) {
		getAllSources();
		 Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		for (Source source : sourceList) {
			if(source.getSourceurl().equals(sourceurl)){
				ConfigAttribute configAttribute =  new SecurityConfig(source.getSourceurl());
				configAttributes.add(configAttribute);
			}
		}
		return configAttributes;
	}

	public List<Source> getViewSourcesByRoleId(Integer roleId){
		initResource();
		List<Source> sources = resources.get(roleId);
		List<Source> list = new ArrayList<>();
		for (Source source : sources) {
			if(source.getLevel() == 1){
				list.add(source);
			}
		}
		List<Source> returnList = new ArrayList<>();
		for (Source source : list) {
			if(source.getSourceparent().equals("0")){
				source.setSources(findChildSources(list, source.getSourceid()));
				returnList.add(source);
			}
		}
		return returnList;
	}
	
	/**
	 * 通过父资源在集合中查找子节点资源
	 * @param sources
	 * @param parentSourceId
	 * @return
	 */
	public List<Source> findChildSources(List<Source> sources,String parentSourceId){
		List<Source> temp = new ArrayList<>();
		for (Source source : sources) {
			if(source.getSourceparent().equals(parentSourceId)){
				temp.add(source);
			}
		}
		return temp;
	}
	/**
	 * 通过父资源节点获取子资源
	 * @return
	 */
	public List<Source> getSourcesBtn(String parentSourceId){
		initResource();
		Integer roleId = CommonUtil.getRoleIdBySession();
		List<Source> sources = findChildSources(resources.get(roleId), parentSourceId);
		return sources;
	}
	
	public List<Source> getSourcesBtnsByUrl(String sourceUrl){
		getAllSources();
		String parentSourceId = getSourceIdBySourceUrl(sourceUrl);
		if(parentSourceId != null && !"".equals(parentSourceId)){
			return getSourcesBtn(parentSourceId);
		}
		return null;
	}
	
	private String getSourceIdBySourceUrl(String sourceUrl){
		getAllSources();
		if(sourceList != null){
			for (Source source : sourceList) {
				if(source.getSourceurl().equals(sourceUrl)){
					return source.getSourceid();
				}
			}
		}
		return null;
	}
	/**
	 * 初始化资源
	 */
	private void  initResource(){
		if(resources == null || resources.isEmpty()){
			loadSource();
		}
	}
	
	public void reflushResource(){
		resources.clear();
		loadSource();
	}
	@Override
	public List<Source> getSourcesByRoleId(Integer roleId) {
		initResource();
		return resources.get(roleId);
	}
}
