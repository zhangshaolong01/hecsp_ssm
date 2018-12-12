package com.bjgoodwill.set.service;

import java.util.List;
import java.util.Map;

import com.bjgoodwill.set.model.ServiceItem;
import com.github.pagehelper.Page;

/**
 * @description 服务项数据业务层操作接口
 * @author zhangshaolong	
 * @createtime 2017-12-20
 */
public abstract interface IServiceItemService{
	
	//增加 
	public abstract ServiceItem insert(ServiceItem entity);
	
	//删除
	public abstract boolean delete(ServiceItem entity);
	
	//修改
  	public abstract boolean update(ServiceItem entity);
	
	//查询单条 
  	public abstract ServiceItem get(ServiceItem entity);
	
	//分页查询  
	public abstract Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc);
	
	//多条查询
  	public abstract List getList(ServiceItem paramDatatable);

	public abstract Page getListForPageforPackage(Map map, int pagesize, int pagerow, String sort, String dir);
}
