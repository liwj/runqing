package com.jynine.dao;

import java.util.List;
import java.util.Map;

import com.jynine.model.Employee;

/**
 * <p>文件名称 : EmployeeDao.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月17日 下午6:27:27</p>
 * @author 李文军
 */
public interface EmployeeDao {
	
	public List<Employee> findEmployeesByPage(Map<String,Object> map);
	
	public Employee findEmployee(Integer empId);
	
	public void insertSelective(Employee employee);
	
	public int findEmployeesCountByPage(Map<String,Object> map);
	
	public void updateByPrimaryKeySelective(Employee employee);
	
}
