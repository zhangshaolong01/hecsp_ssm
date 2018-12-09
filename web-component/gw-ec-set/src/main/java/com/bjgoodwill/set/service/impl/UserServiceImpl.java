package com.bjgoodwill.set.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjgoodwill.set.dao.IUserDao;
import com.bjgoodwill.set.model.User;
import com.bjgoodwill.set.service.IUserService;
/**
 * 用户Service层实现
 * 
 * @author liuyang
 * @date 2017年5月12日 下午4:38:36
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int i = this.userDao.addUser(user);
		return i;
	}

	/*public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}*/

	@Override
	public void queryUserByName(String username) {
		// TODO Auto-generated method stub
		
		this.userDao.queryUserByName(username);
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		int count = this.userDao.deleteUser(user);
		return count;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateUser(user);
	}

	@Override
	public List queryUserList(String nickname) {
		// TODO Auto-generated method stub
		return this.userDao.queryUserList(nickname);
		
	}

}
