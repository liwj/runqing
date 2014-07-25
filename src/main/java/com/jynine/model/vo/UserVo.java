package com.jynine.model.vo;
/**
 * <p>文件名称 : UserVo.java</p>
 * <p>文件描述 : 系统用户分页信息VO </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月14日 下午2:01:13</p>
 * @author 李文军
 */
public class UserVo {
	private Integer userId;//用户ID
	private String userName;//用户名
	private String loginName;//登录名
	private String userRole;//角色
	private Short status;//用户状态
	private String lastLoginTime;//最后登录时间
	private String shopName;//用户所属商店
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
