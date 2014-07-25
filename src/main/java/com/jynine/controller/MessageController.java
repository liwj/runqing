package com.jynine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jynine.model.Message;
import com.jynine.model.MessageReply;
import com.jynine.model.Source;
import com.jynine.model.SpringUser;
import com.jynine.page.PageBean;
import com.jynine.service.LoadSourceService;
import com.jynine.service.MessageService;
import com.jynine.service.UserService;

/**
 * <p>文件名称 : MessageController.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月21日 下午4:07:06</p>
 * @author 李文军
 */
@Controller
@RequestMapping("msg")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private LoadSourceService loadSourceService;
	
	/**
	 * <p>方法描述 : 无 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午5:11:57</p>
	 * @author 李文军
	 * @param request
	 * @param index
	 * @param title
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/listmsg")
	public ModelAndView toMessagePage(HttpServletRequest request, String title, Integer status) {
		ModelAndView mv = new ModelAndView("admin/msg/listmsg");
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(request.getServletPath());
		Integer userId = this.getUserId(request);
		if (userId != null) {
			PageBean pageBean = messageService.findMsgCountPage(status, title, userId);
			mv.addObject("pb", pageBean);// 分页的数据
		}
		mv.addObject("btns", btns);// 按钮数据
		return mv;
	}
	@RequestMapping(value="/listmsg/template")
	public String loadMessages(Model model, HttpServletRequest request, Integer index, String title, Integer status) {
		String parentUrl = request.getServletPath();
		List<Source> btns = loadSourceService.getSourcesBtnsByUrl(parentUrl.substring(0, parentUrl.lastIndexOf("/")));
		model.addAttribute("btns", btns);// 按钮
		Integer userId = this.getUserId(request);
		if (userId != null) {
			model.addAttribute("list", messageService.findMsgPage(index, status, title, userId));// 消息数据
		}
		return "admin/msg/childlist";
	}
	@RequestMapping(value="/addmsg")
	public ModelAndView toAddMessagePage() {
		ModelAndView mv = new ModelAndView("admin/msg/addmsg");
		mv.addObject("user", userService.findUsers());
		return mv;
	}
	/**
	 * <p>方法描述 : 保存新消息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午5:00:18</p>
	 * @author 李文军
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/savemsg")
	public boolean saveMessage(HttpServletRequest request,Message message) {
		Integer userId = this.getUserId(request);
		return messageService.saveMessage(message,userId);
	}
	/**
	 * <p>方法描述 : 根据消息ID查询消息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午5:09:09</p>
	 * @author 李文军
	 * @param msgId
	 * @return
	 */
	@RequestMapping(value="/viewmsg")
	public ModelAndView toMessageInfoPage(Integer msgId) {
		ModelAndView mv = new ModelAndView("admin/msg/viewmsg");
		mv.addObject("msg", messageService.findMessageById(msgId));
		return mv;
	}
	/**
	 * <p>方法描述 : 查询消息回复数据 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午4:56:24</p>
	 * @author 李文军
	 * @param msg
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewmsg/reply")
	public String loadReply(Integer msgId, Model model) {
		//TODO  需完善 
		List<MessageReply> replies = messageService.findMessageReplyByMsgId(msgId);
		model.addAttribute("replies", replies);
		return "admin/msg/listreply";
	}
	/**
	 * <p>方法描述 : 保存回复信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午4:50:12</p>
	 * @author 李文军
	 * @param reply
	 * @return
	 */
	@RequestMapping(value="/savereply")
	public boolean saveReply(MessageReply reply) {
		return messageService.saveReply(reply);
	}
	/**
	 * <p>方法描述 : 更新消息状态 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午4:51:24</p>
	 * @author 李文军
	 * @param status
	 * @param msgId
	 * @return
	 */
	@RequestMapping(value="/changestatus")
	public boolean changeStatus(Integer status, Integer msgId) {
		return messageService.updateStatus(status, msgId);
	}
	/**
	 * <p>方法描述 : 查询当前用户是否有新消息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午4:50:53</p>
	 * @author 李文军
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isnew")
	public boolean isNewMessage(HttpServletRequest request) {
		boolean flag = false;
		Integer userId = getUserId(request);
		if (userId != null) {
			flag = messageService.findIsNewMessage(userId);
		}
		return flag;
	}

	/**
	 * <p>方法描述 : 获取用户ID </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午4:47:28</p>
	 * @author 李文军
	 * @param request
	 * @return
	 */
	private Integer getUserId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SpringUser userDetails = (SpringUser) session.getAttribute("userDetails");
		Integer userId = null;
		if (userDetails != null) {
			userId = userDetails.getUserId();
		}
		return userId;
	}
}
