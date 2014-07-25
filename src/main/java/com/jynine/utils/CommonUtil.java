package com.jynine.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.jynine.model.SpringUser;

public class CommonUtil {
	public static void main(String[] args) {
		System.out.println(md5EncodePassword("123456", "000000"));
		System.out.println(md5EncodePassword("123456", "000001"));
		System.out.println(md5EncodePassword("123456", "000002"));
		System.out.println(md5EncodePassword("123456", "000003"));
		System.out.println(md5EncodePassword("123456", "000004"));
		System.out.println(md5EncodePassword("123456", "000005"));
		System.out.println(md5EncodePassword("123456", "000006"));
	}
	public static String md5EncodePassword(String password,String salt) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder.encodePassword(password,salt);
	}
	/**
	 * 获取spring session中用户信息
	 * @return
	 */
	public static SpringUser getUserDetails(){
		SpringUser userDetails = (SpringUser) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		return userDetails;
	} 
	/**
	 * 通过sesson 获取 角色id
	 * @return
	 */
	public static Integer getRoleIdBySession() {
		SpringUser userDetails = getUserDetails();
		return userDetails.getRoleId();
	}
	
	public static String getContextPath(HttpServletRequest request){
		String root = request.getContextPath();
		return root;
		
	}
	
}
