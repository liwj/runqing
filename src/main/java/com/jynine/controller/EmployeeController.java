package com.jynine.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jynine.model.Employee;
import com.jynine.model.Source;
import com.jynine.page.PageBean;
import com.jynine.service.EmployeeService;
import com.jynine.service.LoadSourceService;
/**
 * <p>文件名称 : EmployeeController.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月17日 下午6:07:36</p>
 * @author 李文军
 */
@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LoadSourceService loadSourceService; 

	@RequestMapping(value="/listemp",method = RequestMethod.GET)
	public ModelAndView toEmployeesPage(String name, Integer index, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/emp/listemp");
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(request.getServletPath());
		PageBean pageBean = employeeService.findPageCount(name);
		mv.addObject("pb", pageBean);// 分页的参数
		mv.addObject("btns", btns);// 按钮数据
		return mv;
	}
	@RequestMapping(value="/listemp/template",method = RequestMethod.GET)
	public String loadEmpsPage(String name, Model model, Integer index, HttpServletRequest request) {
		String parentUrl = request.getServletPath();
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(parentUrl.substring(0, parentUrl.lastIndexOf("/")));
		model.addAttribute("btns", btns);// 按钮
		model.addAttribute("list", employeeService.findEmployeesByPage(name, index));// 数据
		return "admin/emp/childlist";
	}
	@RequestMapping(value="/addemp",method = RequestMethod.GET)
	public ModelAndView toAddEmpPage(){
		ModelAndView mv = new ModelAndView("admin/emp/addemp");
		return mv;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public boolean save(Employee employee){
		return employeeService.save(employee);
	}
	@RequestMapping(value="/changestatus",method = RequestMethod.GET)
	public boolean changeEmpStatus(Integer empId,Integer status){
		return employeeService.updateStatus(empId,status);
	}
	@RequestMapping(value="/editemp",method=RequestMethod.GET)
	public ModelAndView toEditEmpPage(Integer empId) {
		ModelAndView mv = new ModelAndView("admin/emp/editemp");
		mv.addObject("emp", employeeService.find(empId));
		return mv;
	}
	@RequestMapping(value = "/viewemp",method=RequestMethod.GET)
	public ModelAndView toEmpInfoPage(Integer empId){
		ModelAndView mv = new ModelAndView("admin/emp/viewemp");
		mv.addObject("emp", employeeService.find(empId));
		return mv;
	}
}
