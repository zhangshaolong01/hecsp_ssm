package com.bjgoodwill.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.github.pagehelper.Page;

public class ECBaseDao{
	@Autowired
	protected SqlSession sqlSession;
    /**
     * 添加
     *
     * @param statementName
     * @param parameterObject
     * @return
     */
    public Object insert(String statementName, Object parameterObject) {
        try {
      	  this.sqlSession.insert(statementName, parameterObject);
          return parameterObject;
        } catch (Exception e) {
    	   this.sqlSession.insert(statementName, parameterObject);
           return parameterObject;
        }
    }

    /**
     * 修改
     *
     * @param statementName
     * @param parameterObject
     * @return
     * @throws DataAccessException
     */
    public int update(String statementName, Object parameterObject) throws DataAccessException {
        try {
            return this.sqlSession.update(statementName, parameterObject);
		} catch (Exception e) {
			return this.sqlSession.update(statementName, parameterObject);
		}
    }

    /**
     * 删除
     *
     * @param statementName
     * @param parameterObject
     * @return
     * @throws DataAccessException
     */
    public int delete(String statementName, Object parameterObject) throws DataAccessException {
        try {
            return this.sqlSession.update(statementName, parameterObject);
		} catch (Exception e) {
			return this.sqlSession.update(statementName, parameterObject);
		}
        
    }

    /**
     * 单条查询
     *
     * @param statementName
     * @param parameterObject
     * @return
     * @throws DataAccessException
     */
    public Object queryForObject(String statementName, Object parameterObject) throws DataAccessException {
    	try {
            return this.sqlSession.selectOne(statementName, parameterObject);
		} catch (Exception e) {
			return this.sqlSession.selectOne(statementName, parameterObject);
		}
    }

    /**
     * 分页查询
     *
     * @param statementName
     * @param parameterObject
     * @param pageNo
     * @param pageSize
     * @return
     * @throws DataAccessException
     */
    /*public Page queryForPage(String statementName, Map parameterObject, int pageNo, int pageSize) throws DataAccessException {
        try {
            return this.sqlSession.queryForPage(statementName, parameterObject, pageNo, pageSize);
		} catch (Exception e) {
			 return this.sqlSession.queryForPage(statementName, parameterObject, pageNo, pageSize);
		}
    }*/

    /**
     * 列表查询
     *
     * @param statementName
     * @param parameterObject
     * @return
     * @throws DataAccessException
     */
    public List queryForList(String statementName, Object parameterObject) throws DataAccessException {
    	try {
	        return this.sqlSession.selectList(statementName, parameterObject);
		} catch (Exception e) {
			return this.sqlSession.selectList(statementName, parameterObject);
		}
       
    }
}