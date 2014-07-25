package com.jynine.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jynine.dao.EmployeeDao;
import com.jynine.model.Employee;
import com.jynine.page.PageBean;
import com.jynine.utils.Constant;
/**
 * <p>文件名称 : EmployeeService.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月17日 下午6:24:53</p>
 * @author 李文军
 */
@Service("employeeService")
public class EmployeeService {
	private Logger log = LoggerFactory.getLogger(EmployeeService.class.getName());
	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> findEmployeesByPage(String name, Integer index) {
		List<Employee> emps = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int startLine = Constant.PAGE_SIZE * (index - 1);
			map.put("startLine", startLine);
			map.put("pageSize", Constant.PAGE_SIZE);
			map.put("name", name);
			emps = employeeDao.findEmployeesByPage(map);
		} catch (Exception e) {
			log.error("分页查询员工信息", e);
		}
		return emps;
	}
	public PageBean findPageCount(String name){
		PageBean pb = new PageBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		int count = employeeDao.findEmployeesCountByPage(map);
		pb.setPageIndex(1);
		pb.setPageSize(Constant.PAGE_SIZE);
		pb.setTotalPage(count);
		return pb;
	
	}

	public boolean save(Employee employee) {
		boolean flag = false;
		try {
			employee.setNameEn(getPinYinHeadChar(employee.getNameCn()));
			if (employee.getId() != null) {
				employee.setStatus(3);
				employeeDao.updateByPrimaryKeySelective(employee);
			} else {
				employeeDao.insertSelective(employee);
			}
			flag = true;
		} catch (Exception e) {
			log.error("保存员工信息", e);
		}
		return flag;
	}
	public Employee find(Integer empId){
		return find(empId);
	}
	public boolean updateStatus(Integer empId,Integer status){
		boolean flag = false;
		Employee employee = new Employee();
		try {
			employee.setId(empId);
			employee.setStatus(status);
			employeeDao.updateByPrimaryKeySelective(employee);
			flag = true;
		} catch (Exception e) {
			log.error("更新员工状态",e);
		}
		return flag;
	}
	/**
	 * <p>方法描述 : 获取员工英文名 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月21日 上午10:26:13</p>
	 * @author 李文军
	 * @param nameCn 中文名
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination 
	 */
	private String getPinYinHeadChar(String nameCn) throws BadHanyuPinyinOutputFormatCombination {
		char[] pyChar = nameCn.toCharArray();
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		int len = pyChar.length;
		String nameEn = "";
		for (int i = 0; i < len; i++) {
			if (Character.toString(pyChar[i]).matches("[\\u4E00-\\u9FA5]+")) {// 判断是否为汉字字符
				String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(pyChar[i], format);
				nameEn += pinyins[0].substring(0, 1);// 获取拼音首字母
			}
		}
		return nameEn;
	}
}
