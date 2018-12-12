package com.bjgoodwill.set.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bjgoodwill.common.exception.FrameworkException;
import com.bjgoodwill.common.service.BaseService;
import com.bjgoodwill.set.dao.IServiceItemDao;
import com.bjgoodwill.set.model.ServiceItem;
import com.bjgoodwill.set.service.IServiceItemService;
import com.github.pagehelper.Page;

/**
 * @description 服务项数据业务层操作
 * @author zhangshaolong	
 * @createtime 2017-12-20
 */
public class ServiceItemServiceImpl extends BaseService implements IServiceItemService {

	private final static Log  log = LogFactory.getLog(ServiceItemServiceImpl.class);
	
	private IServiceItemDao serviceItemDao;
	
	public IServiceItemDao getServiceItemDao() {
		return serviceItemDao;
	}
	public void setServiceItemDao(IServiceItemDao serviceItemDao) {
		this.serviceItemDao = serviceItemDao;
	}

	//增加
	public ServiceItem insert(ServiceItem entity){
		try {
			return (ServiceItem)serviceItemDao.insert(entity);
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-添加异常", e);
		}
	}

	//删除
	public boolean delete(ServiceItem entity){
		try {
			return serviceItemDao.delete(entity)>0;
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-删除异常", e);
		}
	}
	
	//修改
	public boolean update(ServiceItem entity){
		try {
			return serviceItemDao.update(entity)>0;
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-修改异常", e);
		}
	}
	
	//查询单条
	public ServiceItem get(ServiceItem entity){
		try {
			return (ServiceItem)serviceItemDao.get(entity);
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-单条查询异常", e);
		}
	}

	//分页查询  
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		try {
			return serviceItemDao.getListForPage(map,pageNo,pageSize,sort,desc);
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-分页查询异常", e);
		}
	}

	@Override
	public Page getListForPageforPackage(Map map, int pageNo,int pageSize,String sort,String desc) {
		try {
			return serviceItemDao.getListForPageforPackage(map,pageNo,pageSize,sort,desc);
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-分页查询异常", e);
		}
	}

	
	//多条查询
	public List getList(ServiceItem entity){
		try {
			return serviceItemDao .getList(entity);
		} catch (Exception e) {
			log.error(e);
			throw new FrameworkException("$tableInfo.tabComment-多条查询异常", e);
		}
	}
}

