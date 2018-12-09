package com.bjgoodwill.set.dao;

import java.util.List;

import com.bjgoodwill.set.model.User;

public interface IUserDao {

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	int addUser(User user);
	
	/**
	 * 查询用户
	 * 
	 * @param username
	 */
	void queryUserByName(String username);
	/**
	 * 查询用户列表
	 * 
	 * @param nickName
	 * @return
	 */
	List queryUserList(String nickName);
	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	int deleteUser(User user);
	/**
	 * 更新用户
	 * 
	 * @Date 2017年5月18日 下午5:52:15
	 * @param user
	 * @return
	 */
	int updateUser(User user);
}
