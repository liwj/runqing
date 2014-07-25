package com.jynine.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.jynine.dao.SourceDao;
import com.jynine.model.Source;
import com.jynine.service.LoadSourceService;


public class SecurityMetadataSource  implements FilterInvocationSecurityMetadataSource{

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    @Autowired
	private LoadSourceService loadSourceService;
    @Autowired
    private SourceDao sourceDao;
    public Collection<ConfigAttribute> getAllConfigAttributes() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public boolean supports(Class<?> clazz) {  
        // TODO Auto-generated method stub  
        return true;  
    }  
    //加载所有资源与权限的关系 
    private void loadResourceDefine(){
    	
    	try
    	{
            resourceMap = new ConcurrentHashMap<String, Collection<ConfigAttribute>>();
            List<Source> sources = loadSourceService.getAllSources();
            for (Source source : sources) {  
                Collection<ConfigAttribute> configAttributes = loadSourceService.getRoleCollectionBySourceUrl(source.getSourceurl());
                resourceMap.put(source.getSourceurl(), configAttributes);  
            }  
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }  
    //返回所请求资源所需要的权限  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {  
          
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        requestUrl = removeUrlParams(requestUrl);
        if(resourceMap == null) {  
            loadResourceDefine();  
        }
        return resourceMap.get(requestUrl);  
    }
    
    public void refreshResourceDefine(){
    	this.loadResourceDefine();

    	
    }
    private String removeUrlParams(String requestUrl){
    	if(StringUtils.isEmpty(requestUrl))
    		return StringUtils.EMPTY;
    	else if(requestUrl.indexOf("?") == -1)
    		return requestUrl;
    	else
    		return requestUrl.substring(0,requestUrl.indexOf("?"));
    }
    
}
