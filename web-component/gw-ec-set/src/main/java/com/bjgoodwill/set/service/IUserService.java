package com.bjgoodwill.set.service;

import java.util.List;

import com.bjgoodwill.set.model.User;

/**
 * 用户sevice层接口
 * 
 * @author chronos
 * @date 2017年5月12日 下午4:38:02
 */
public interface IUserService {

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	int addUser(User user);
	
	/**
	 * 查询用户
	 * 
	 * @Date 2017年5月12日 下午5:34:37
	 * @param user
	 */
	void queryUserByName(String username);
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
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 查询用户列表
	 * 
	 * @param nickname
	 * @return
	 */
	List queryUserList(String nickname);
	
}
