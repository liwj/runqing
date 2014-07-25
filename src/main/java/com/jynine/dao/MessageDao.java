package com.jynine.dao;

import java.util.List;
import java.util.Map;

import com.jynine.model.Message;
import com.jynine.model.MessageReply;
import com.jynine.model.vo.MessageVo;

public interface MessageDao {

    /**
     * <p>方法描述 : 分页查询消息信息 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午3:55:29</p>
     * </pre>
     * @author 李文军
     * @param map
     * @return
     */
    List<MessageVo> findMsgPage(Map<String,Object> map);
    
    /**
     * <p>方法描述 : 按条件查询消息数据 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午3:55:10</p>
     * @author 李文军
     * @param map
     * @return
     */
    int findMsgCountPage(Map<String,Object> map);
    
    /**
     * <p>方法描述 : 添加消息数据 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午3:54:50</p>
     * @author 李文军
     * @param message
     */
    void insertMsg(Message message);
    
    /**
     * <p>方法描述 : 查询单条消息</p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午3:54:35</p>
     * @author 李文军
     * @param msgId
     * @return
     */
    MessageVo findMsg(Integer msgId);
    
    /**
     * <p>方法描述 : 查询消息回复信息 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午3:54:20</p>
     * @author 李文军
     * @param msgId
     * @return
     */
    List<MessageReply> findMsgReply(Integer msgId);
    
    /**
     * <p>方法描述 : 向消息回复表插入数据 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午3:54:01</p>
     * @author 李文军
     * @param messageReply
     */
    void insertReply(MessageReply messageReply);
    
    /**
     * <p>方法描述 : 更新消息 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月21日 下午4:03:24</p>
     * @author 李文军
     * @param message
     */
    void updateMsg(Message message);
    
    /**
     * <p>方法描述 : 查询用户是否有新消息 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月22日 下午3:50:43</p>
     * @author 李文军
     * @param userId
     * @return
     */
    int findIsNewMessage(Integer userId);
}