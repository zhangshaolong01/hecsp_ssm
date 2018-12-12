package com.bjgoodwill.set.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bjgoodwill.common.dao.ECBaseDao;
import com.bjgoodwill.set.dao.IServiceItemDao;
import com.bjgoodwill.set.model.ServiceItem;
import com.github.pagehelper.Page;

/**
 * @description 服务项数据层操作接口实现
 * @author zhangshaolong	 
 * @createtime 2017-12-20
 */
public class ServiceItemDaoImpl extends ECBaseDao implements IServiceItemDao {
	
	//增加 
	public ServiceItem insert(ServiceItem entity){
		entity.setServiceItemId(UUID.randomUUID().toString().replaceAll("-", ""));
		insert(entity.getClass().getName()+".insert", entity);
		return entity;
	}

	//删除
	public int delete(ServiceItem entity){
		return delete(entity.getClass().getName()+".delete", entity);
	}

	//修改 
	public int update(ServiceItem entity){
		return update(entity.getClass().getName()+".update", entity);
	}

	//查询 
	public ServiceItem get(ServiceItem entity){
		return (ServiceItem)queryForObject(entity.getClass().getName()+".get", entity);
	}

	//分页查询 
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="";
		if (sort==null){
			sCol = "a.update_time desc";
		}
		map.put("pageSort", sCol);
		//return queryForPage(ServiceItem.class.getName()+".getList", map, pageNo,pageSize);
		return null;
	}


	@Override
	public Page getListForPageforPackage(Map map, int pageNo, int pageSize, String sort, String desc) {
		String sCol="";
		if (sort==null){
			sCol = "a.service_item_name";
		}
		map.put("pageSort", sCol);
		//return queryForPage(ServiceItem.class.getName()+".getListforPackage", map, pageNo,pageSize);
		return null;
	}
	
	//多条查询 
	public List getList(ServiceItem entity){
		return queryForList(entity.getClass().getName()+".getListNoPage", entity);
	}
	
}
