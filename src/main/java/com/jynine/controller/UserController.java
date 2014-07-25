package com.jynine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jynine.model.Source;
import com.jynine.model.User;
import com.jynine.page.PageBean;
import com.jynine.service.LoadSourceService;
import com.jynine.service.RoleService;
import com.jynine.service.UserService;

/**
 * <p>文件名称 : UserController.java</p>
 * <p>文件描述 : 用户信息管理控制器 </p>
 * <p>内容摘要 : 负责系统用户管理模块</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月14日 下午1:25:59</p>
 * @author 李文军
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private LoadSourceService loadSourceService; 
	/**
	 * <p>方法描述 : 跳转系统管理用户页面 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月14日 下午1:38:43</p>
	 * @author 李文军
	 * @param request
	 * @return 系统用户视图
	 */
	@RequestMapping(value="/listuser")
	public ModelAndView toUsersPage(HttpServletRequest request,String name) {
		ModelAndView mv = new ModelAndView("admin/user/listuser");
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(request.getServletPath());
		PageBean pageBean = userService.findPageCount(name);
		mv.addObject("pb", pageBean);// 分页的参数
		mv.addObject("name", name);//
		mv.addObject("btns", btns);// 按钮数据
		return mv;
	}
	/**
	 * <p>方法描述 : 加载系统用户数据 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月18日 下午5:39:32</p>
	 * @author 李文军
	 * @param model
	 * @param index
	 * @param request
	 * @return 视图名
	 */
	@RequestMapping(value="/listuser/template")
	public String loadUsersPage(Model model, Integer index, HttpServletRequest request,String name) {
		String parentUrl = request.getServletPath();
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(parentUrl.substring(0, parentUrl.lastIndexOf("/")));
		model.addAttribute("btns", btns);//按钮
		model.addAttribute("list", userService.findUserByPage(index,name));//数据
		return "admin/user/childlist";
	}
	/**
	 * <p>方法描述 : 跳转到新增用户页面 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月17日 下午3:59:56</p>
	 * @author 李文军
	 * @return
	 */
	@RequestMapping(value = "/adduser")
	public ModelAndView toAddUserPage() {
		ModelAndView mv = new ModelAndView("admin/user/adduser");
		mv.addObject("role", roleService.findAll());// 全部角色信息
		return mv;
	}
	/**
	 * <p>方法描述 : 保存用户信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月17日 下午4:11:45</p>
	 * @author 李文军
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/saveuser")
	public boolean saveUser(User user) {
		return userService.save(user);
	}
	/**
	 * <p>方法描述 : 查看用户信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月17日 下午4:13:04</p>
	 * @author 李文军
	 * @param request
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping(value="/userview")
	public ModelAndView toUserInfoPage(Integer userId){
		ModelAndView mv = new ModelAndView("admin/user/userview");
		mv.addObject("user", userService.findUserById(userId));//用户信息
		return mv;
	}
	/**
	 * <p>方法描述 : 编辑用户信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月17日 下午4:13:04</p>
	 * @author 李文军
	 * @param request
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping(value="/edituser")
	public ModelAndView toEditUserPage(Integer userId) {
		ModelAndView mv = new ModelAndView("admin/user/edituser");
		mv.addObject("user", userService.findUserById(userId));// 用户信息
		return mv;
	}
	/**
	 * <p>方法描述 : 更改用户状态 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月17日 下午4:13:04</p>
	 * @author 李文军
	 * @param request
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping(value="/changestatus")
	public boolean changeStatus(Integer userId, Integer status) {
		// 0-正常 1-禁用 2-已删除
		return userService.updateUserStatusById(userId, status);
	}
}
