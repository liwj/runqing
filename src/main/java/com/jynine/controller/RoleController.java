package com.jynine.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jynine.model.Role;
import com.jynine.model.Source;
import com.jynine.model.SpringUser;
import com.jynine.page.PageBean;
import com.jynine.service.LoadSourceService;
import com.jynine.service.RoleService;
import com.jynine.utils.CommonUtil;
import com.jynine.utils.Constant;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private LoadSourceService loadSourceService;
	@RequestMapping(value = "/addrole")
	public ModelAndView addRole() {
		ModelAndView mv = new ModelAndView("admin/role/addrole");
		return mv;
	}
	
	@RequestMapping(value = "/listrole")
	public ModelAndView rolelist(String name,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/admin/role/listrole");
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(request.getServletPath());
		PageBean pb = this.roleService.getCount(name,1,Constant.PAGE_SIZE);
		mv.addObject("btns", btns);
		mv.addObject("name", name);
		mv.addObject("pb", pb);
		return mv;
	}
	
	@RequestMapping(value = "/listrole/template")
	public String rolelistJson(Model model,String name,Integer pageIndex,HttpServletRequest request){
		try {
			PageBean pb = this.roleService.getList(name,pageIndex,Constant.PAGE_SIZE);
			String parentUrl = request.getServletPath();
			List<Source> btns = loadSourceService.getSourcesBtnsByUrl(parentUrl.substring(0, parentUrl.lastIndexOf("/")));
			List<Role> list = (List<Role>) pb.getList();
			model.addAttribute("btns", btns);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "/admin/role/childlist";
	}
}
