package com.jynine.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jynine.dao.MessageDao;
import com.jynine.model.Message;
import com.jynine.model.MessageReply;
import com.jynine.model.vo.MessageVo;
import com.jynine.page.PageBean;
import com.jynine.utils.Constant;
/**
 * <p>文件名称 : MessageService.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月21日 上午11:32:33</p>
 * @author 李文军
 */
@Service("meessageService")
public class MessageService {
	
	private Logger log = LoggerFactory.getLogger(MessageService.class.getName());
	
	@Autowired
	private MessageDao messageDao;
	
	public PageBean findMsgCountPage(Integer status, String title, Integer userId) {
		PageBean pageBean = new PageBean();
		Map<String, Object> searchMap = new HashMap<String, Object>();
		int count = 0;
		try {
			searchMap.put("status", status);
			searchMap.put("title", title);
			searchMap.put("userId", userId);
			count = messageDao.findMsgCountPage(searchMap);
			pageBean.setTotalPage(count);
			pageBean.setPageIndex(1);
			pageBean.setPageSize(Constant.PAGE_SIZE);
		} catch (Exception e) {
			log.error("查询消息数据条数", e);
		}
		return pageBean;
	}

	public List<MessageVo> findMsgPage(Integer index, Integer status, String title, Integer userId) {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		List<MessageVo> messages = null;
		try {
			searchMap.put("status", status);
			searchMap.put("title", title);
			searchMap.put("userId", userId);
			int startLine = Constant.PAGE_SIZE * (index - 1);
			searchMap.put("startLine", startLine);
			searchMap.put("pageSize", Constant.PAGE_SIZE);
			messages = messageDao.findMsgPage(searchMap);
		} catch (Exception e) {
			log.error("分页查询消息数据", e);
		}
		return messages;
	}

	public boolean saveMessage(Message message,Integer userId) {
		boolean flag = false;
		try {
			message.setMsgSendId(userId);//消息发送人
			message.setMsgStatus(1);//消息状态
			messageDao.insertMsg(message);
			flag = true;
		} catch (Exception e) {
			log.error("保存消息", e);
		}
		return flag;
	}

	public boolean saveReply(MessageReply reply) {
		boolean flag = false;
		try {
			messageDao.insertReply(reply);//保存好回复信息
			this.updateStatus(1, reply.getMsgId());//将消息更新为未读状态
			flag = true;
		} catch (Exception e) {
			log.error("保存消息回复信息", e);
		}
		return flag;
	}

	/**
	 * <p>方法描述 : 根据消息ID查询消息信息 </p>
	 * <p>其他说明 : 当消息的状态为 未查看状态 时序修改为 已查看状态</p>
	 * <p>完成日期 : 2014年7月22日 下午5:06:36</p>
	 * @author 李文军
	 * @param msgId
	 * @return
	 */
	public MessageVo findMessageById(Integer msgId) {
		MessageVo messageVo = messageDao.findMsg(msgId);
		if (messageVo != null) {
			if (messageVo.getStatus() == 1) {
				this.updateStatus(0, msgId);// 将消息的状态改为已查看状态
			}
		}
		return messageVo;
	}

	public List<MessageReply> findMessageReplyByMsgId(Integer msgId) {
		return messageDao.findMsgReply(msgId);
	}

	public boolean updateStatus(Integer status, Integer msgId) {
		boolean flag = false;
		Message message = new Message();
		message.setMsgId(msgId);
		message.setMsgStatus(status);
		try {
			messageDao.updateMsg(message);
			flag = true;
		} catch (Exception e) {
			log.error("更新消息状态", e);
		}
		return flag;
	}
	/**
	 * <p>方法描述 : 查询用户是否有新消息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午3:47:01</p>
	 * @author 李文军
	 * @param userId 用户ID
	 * @return
	 */
	public boolean findIsNewMessage(Integer userId) {
		int count = messageDao.findIsNewMessage(userId);
		return count > 0;
	}
}
