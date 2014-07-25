package com.jynine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jynine.model.Source;
import com.jynine.model.SpringUser;
import com.jynine.model.User;
import com.jynine.service.LoadSourceService;
import com.jynine.utils.CommonUtil;

@Controller
public class HomeController {
	@Autowired
	private LoadSourceService loadSourceService;
	@RequestMapping(value = "/")
	public String home(){
		return "home";
	}
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("contextPath", CommonUtil.getContextPath(request)); 
		return "login";
	}
	@RequestMapping(value = "/404")
	public String page404(){
		return "404";
	}
	@RequestMapping(value = "/403")
	public String page403(){
		return "403";
	}
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("admin/index");
	/*	HttpSession session = request.getSession();
		SpringUser userDetails = CommonUtil.getUserDetails();
		List<Source> sources = loadSourceService.getViewSourcesByRoleId(userDetails.getRoleId());
		mv.addObject("viewSources", sources);
		mv.addObject("userDetails", userDetails);*/
		return mv;
	}
	@RequestMapping(value="/loginSuccess")
	@ResponseBody
	public Map<String,String> loginSuccess(HttpServletRequest request){
		HttpSession session = request.getSession();
		SpringUser userDetails = CommonUtil.getUserDetails();
		session.setAttribute("contextPath", CommonUtil.getContextPath(request)); 
		session.setAttribute("userDetails", userDetails);
		List<Source> sources = loadSourceService.getViewSourcesByRoleId(userDetails.getRoleId());
		session.setAttribute("viewSources", sources);
		Map<String, String> map = new HashMap<>();
		map.put("status", "1");
		return map;
	}
 	@RequestMapping(value="/top")
	public ModelAndView top(){
 		SpringUser userDetails = CommonUtil.getUserDetails();
 		ModelAndView mv = new ModelAndView("admin/top");
 		mv.addObject("userDetails", userDetails);
		return mv;
	}
	@RequestMapping(value="/center")
	public String center(){
		return "admin/center";
	}
	@RequestMapping(value="/down")
	public String down(){
		return "admin/down";
	}
	@RequestMapping(value="/middle")
	public String middle(){
		return "admin/middle";
	}
	@RequestMapping(value="/welcome")
	public String fristIndex(){
		return "admin/welcome";
	}
	@RequestMapping(value="/left")
	public ModelAndView left(){
		ModelAndView mv = new ModelAndView("admin/left");
		SpringUser userDetails = CommonUtil.getUserDetails();
		List<Source> sources = loadSourceService.getViewSourcesByRoleId(userDetails.getRoleId());
		mv.addObject("viewSources", sources);
		return mv;
	}
	@RequestMapping(value="/logout")
	public void logout(){
		
	}
	@RequestMapping(value="/accessindex")
	public String accessindex(){
		return "accessindex";
	}
	@RequestMapping(value="/accessfailed")
	public String authenticationfail(){
		return "authenticationfailure";
	}
}
