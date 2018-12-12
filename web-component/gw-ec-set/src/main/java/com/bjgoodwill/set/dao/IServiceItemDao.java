package com.bjgoodwill.set.dao;

import java.util.List;
import java.util.Map;

import com.bjgoodwill.set.model.ServiceItem;
import com.github.pagehelper.Page;

/**
 * @description 服务项数据层操作接口
 * @author zhangshaolong	 
 * @createtime 2017-12-20
 */
public abstract interface IServiceItemDao{
	
	//增加 
	public abstract ServiceItem insert(ServiceItem entity);

	//删除
	public abstract int delete(ServiceItem entity);

	//修改 
	public abstract int update(ServiceItem entity);

	//查询单条 
	public abstract ServiceItem get(ServiceItem entity);

	//分页查询 
	public abstract Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc);

	//多条查询 
	public abstract List getList(ServiceItem entity);

	public abstract Page getListForPageforPackage(Map map, int pageNo, int pageSize, String sort, String desc);
	
}