package com.jynine.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jynine.model.User;
import com.jynine.model.vo.UserVo;


public interface  UserDao{


    void deleteByPrimaryKey(Integer userId);

    void insert(User user);

    void insertSelective(User user);


    User selectByPrimaryKey(Integer userId);
    /**
     * 通过用户名查询用户
     * @param userName
     * @return
     */
    User queryUserByUserName(String userName);
    

    void updateByPrimaryKeySelective(User user);

    void updateByPrimaryKey(User user);
    
    /**
     * <p>方法描述 : 分页查询管理用户信息 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月14日 下午2:19:10</p>
     * @author 李文军
     * @param searchMap 查询条件
     * @return
     */
    List<UserVo> findUsersByPage(Map<String,Object> searchMap);
    
    /**
     * <p>方法描述 : 查询登录用户数量 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月14日 下午2:21:05</p>
     * @author 李文军
     * @param name
     * @return 登录用户数量
     */
    int findUserCount(@Param(value="name") String name);
    
    UserVo findUserById(Integer userId);
    
    /**
     * <p>方法描述 : 查询正常状态下的所有用户 </p>
     * <p>其他说明 : 无</p>
     * <p>完成日期 : 2014年7月22日 下午3:21:39</p>
     * @author 李文军
     * @return
     */
    List<User> findUsers();
    
}	
