package com.jynine.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jynine.dao.UserDao;
import com.jynine.model.DormitoryBuilding;
import com.jynine.model.Employee;
import com.jynine.model.MessageReply;
import com.jynine.model.vo.MessageVo;
import com.jynine.model.vo.UserVo;
import com.jynine.page.PageBean;
import com.jynine.service.DormitoryBuildingService;
import com.jynine.service.EmployeeService;
import com.jynine.service.MessageService;
import com.jynine.service.UserService;

/**
 * <p>文件名称 : AppTest.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月22日 上午9:55:57</p>
 * @author 李文军
 */
public class AppTest {
	ApplicationContext applicationContext = null;
	@Before
	public void before(){
		String[] str = new String[]
				{
				"src/main/webapp/WEB-INF/spring/servlet-context.xml",
				"src/main/webapp/WEB-INF/spring/spring-database.xml",
				"src/main/webapp/WEB-INF/spring/spring-security.xml",
				"src/main/webapp/WEB-INF/spring/spring-service.xml"};
		applicationContext = new FileSystemXmlApplicationContext(str);
	}
	
	@Test
	public void test1(){
		EmployeeService service = (EmployeeService) applicationContext.getBean("employeeService");
		List<Employee> emps = service.findEmployeesByPage("潘飞", 1);
		for (Employee employee : emps) {
			System.out.println(employee.getNameCn());
		}
		PageBean bean1 =  service.findPageCount("pf");
		System.out.println(bean1.getTotalPage());
		Employee employee  = new Employee();
		employee.setId(13);
		employee.setEmpTypeId(1);
		employee.setEmpTypeName("组长");
		employee.setAddress("渝中");
		employee.setAge(20);
		employee.setEntryTime(new Date());
		employee.setNameCn("张三");
		employee.setBirth("1992-12");
		employee.setPhone("10101780");
		service.save(employee);
		service.updateStatus(13, 1);
	}
	@Test
	public void Test2(){
		MessageService messageService = (MessageService) applicationContext.getBean("messageService");
//		Message message = new Message();
//		message.setMsgContent("消息内容4");
//		message.setMsgTitle("消息标题4");
//		message.setMsgTime(new Date());
//		message.setMsgStatus(1);
//		message.setMsgSendId(2);
//		message.setMsgReciId(0);
//		messageService.save(message);
//		PageBean bean = messageService.findMsgCountPage(1, null, 0);
//		System.out.println(bean.getTotalPage());
//		PageBean bean = messageService.findMsgPage(1, null, null, 0);
//		List<MessageVo> messages = (List<MessageVo>) bean.getList();
//		for (MessageVo message : messages) {
//			System.out.println(message.getSendName());
//			System.out.println(message.getReciName());
//			System.out.println(message.getTitle());
//			System.out.println("-----------------------------");
//		}
//		MessageReply messageReply = new MessageReply();
//		messageReply.setMsgContent("消息ID为1的消息回复13");
//		messageReply.setMsgId(1);
//		messageReply.setMsgTime(new Date());
//		messageReply.setMsgType(2);
//		messageService.saveReply(messageReply);
		MessageVo messageVo = messageService.findMessageById(1);
		String str1 = messageVo.getSendName();
		String str2 = messageVo.getReciName();
//		System.out.println(messageVo.getTitle());
		List<MessageReply> list = messageService.findMessageReplyByMsgId(1);
		for (MessageReply messageReply : list) {
			if(messageReply.getMsgType()==1){
				System.out.println(str1+"说:"+messageReply.getMsgContent());
			}else if(messageReply.getMsgType()==2){
				System.out.println(str2+"说:"+messageReply.getMsgContent());
			}
		}
	}
	@Test
	public void test3(){
		UserService userService = (UserService) applicationContext.getBean("userService");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//		PageBean bean = (PageBean) userService.findUserByPage(1, null);
//		List<UserVo> list = (List<UserVo>) bean.getList();
//		for (UserVo userVo : list) {
//			System.out.println(userVo.getUserName());
//		}
		PageBean bean = userService.findPageCount("sss");
		System.out.println(bean.getTotalPage());
		userService.findUserById(1);
		userDao.queryUserByUserName("a");
	}
	@Test
	public void test4(){
		DormitoryBuildingService buildingService = (DormitoryBuildingService) applicationContext.getBean("dormitoryBuildingService");
		DormitoryBuilding building = new DormitoryBuilding();
		building.setDbDesc("描述");
		building.setDbName("楼1");
		building.setDbTime(new Date());
		building.setDbNum(4);
		building.setDbRoomNum(12);
		buildingService.save(building);
	}
	@After
	public void after(){
		
	}
}
