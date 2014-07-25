package com.jynine.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jynine.dao.UserDao;
import com.jynine.model.User;
import com.jynine.model.vo.UserVo;
import com.jynine.page.PageBean;
import com.jynine.utils.Constant;

/**
 * <p>文件名称 : UserServiceImpl.java</p>
 * <p>文件描述 : 系统用户管理业务实现类 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月14日 下午1:53:18</p>
 * @author 李文军
 */
@Service("userService")
public class UserService{
	
	private static Logger log = LoggerFactory.getLogger(UserService.class); 
	@Autowired
	private UserDao userDao;

	/**
	 * <p>方法描述 : 分页查询系统用户数据 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月14日 下午1:45:50</p>
	 * @author 李文军
	 * @param index 页码
	 * @return List<UserVo>
	 */
	public List<UserVo> findUserByPage(Integer index, String name) {
		List<UserVo> users = null;
		try {
			Map<String, Object> searchMap = new HashMap<String, Object>();
			int startLine = Constant.PAGE_SIZE * (index - 1);
			searchMap.put("startLine", startLine);
			searchMap.put("pageSize", Constant.PAGE_SIZE);
			searchMap.put("name", name);
			users = userDao.findUsersByPage(searchMap);
		} catch (Exception e) {
			log.error("分页查询系统用户数据 ", e);
		}
		return users;
	}
	
	/**
	 * <p>方法描述 : 根据系统用户ID查询用户信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月15日 下午2:25:41</p>
	 * @author 李文军
	 * @param userId 系统管理用户ID
	 * @return
	 */
	public UserVo findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}
	/**
	 * <p>方法描述 : 根据系统用户ID修改用户状态信息 </p>
	 * <p>其他说明 : 修改用户状态(0-正常 1-禁用 2-已删除)</p>
	 * <p>完成日期 : 2014年7月15日 下午2:43:23</p>
	 * @author 李文军
	 * @param userId 用户ID
	 */
	public boolean updateUserStatusById(Integer userId, int stutas) {
		boolean flag = false;
		User user = new User();
		try {
			user.setUserId(userId);
			user.setStatus(stutas);
			userDao.updateByPrimaryKeySelective(user);
			flag = true;
		} catch (Exception e) {
			log.error("修改用户状态信息", e);
		}
		return flag;
	}
	/**
	 * <p>方法描述 : 保存用户信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月15日 下午2:44:35</p>
	 * @author 李文军
	 * @param user 用户ID
	 */
	public boolean save(User user) {
		boolean flag = false;
		try {
			user.setUpdateTime(new Date());
			Integer userId = user.getUserId();
			if (userId == null) {
				user.setStatus(0);
				userDao.insert(user);
			} else {
				userDao.updateByPrimaryKey(user);
			}
			flag = true;
		} catch (Exception e) {
			log.error("保存系统用户信息", e);
		}
		return flag;
	}

	/**
	 * <p>方法描述 : 无 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月18日 下午4:29:49</p>
	 * @author 李文军
	 * @return
	 */
	public PageBean findPageCount(String name) {
		PageBean pb = new PageBean();
		int count = userDao.findUserCount(name);
		pb.setPageIndex(1);
		pb.setPageSize(Constant.PAGE_SIZE);
		pb.setTotalPage(count);
		return pb;
	}
	/**
	 * <p>方法描述 : 查询正常状态下的所用用户 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月22日 下午3:23:42</p>
	 * @author 李文军
	 * @return
	 */
	public List<User> findUsers(){
		return userDao.findUsers();
	}
}
