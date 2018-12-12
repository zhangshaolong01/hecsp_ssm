package com.bjgoodwill.set.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjgoodwill.common.dao.ECBaseDao;
import com.bjgoodwill.set.dao.IUserDao;
import com.bjgoodwill.set.model.User;
/**
 * 用户dao层实现
 * 
 * @author chronos
 * @date 2017年5月12日 下午4:19:16
 */
@Repository
public class UserDaoImpl extends ECBaseDao implements IUserDao{

	//mapper文件的namespace
	private String mapperNamespace = "com.bjgoodwill.set.mapper.User";

	
	/*public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}*/

	/**
	 * 添加一个用户
	 */
	@Override
	public int addUser(User user) {
		int i =this.sqlSession.insert(mapperNamespace+".insertUser",user);
		return i;
	}
	/**
	 * 查询用户
	 */
	@Override
	public void queryUserByName(String username) {
		
		User  user = this.sqlSession.selectOne(mapperNamespace+".selectUser", username);
		
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		int i = this.sqlSession.delete(mapperNamespace+".deleteUser", user);
		return i;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		int i = this.sqlSession.update(mapperNamespace+".updateUser", user);
		return i;
	}

	@Override
	public List queryUserList(String nickName) {
		// TODO Auto-generated method stub
		List list = this.sqlSession.selectList(this.mapperNamespace+".selectUserList",nickName);
		return list;
	}
	
	
	
	
}
