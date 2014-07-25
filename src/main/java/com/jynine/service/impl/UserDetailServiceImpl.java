package com.jynine.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jynine.dao.UserDao;
import com.jynine.model.Source;
import com.jynine.model.SpringUser;
import com.jynine.model.User;
import com.jynine.service.LoadSourceService;

public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoadSourceService loadSourceService;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.queryUserByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException(username + "不存在！");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Source> resources = loadSourceService.getSourcesByRoleId(user.getRoleId());
		for (Source resource : resources) {
			authorities.add(new SimpleGrantedAuthority(resource.getSourceurl()));
		}
		SpringUser springUser = new SpringUser(username, user.getPassword(), true, true, true, true, authorities);
		springUser.setName(user.getName());
		springUser.setRoleId(user.getRoleId());
		springUser.setUserId(user.getUserId());
		return springUser;
	}
	public LoadSourceService getLoadSourceService() {
		return loadSourceService;
	}
	public void setLoadSourceService(LoadSourceService loadSourceService) {
		this.loadSourceService = loadSourceService;
	}

}
