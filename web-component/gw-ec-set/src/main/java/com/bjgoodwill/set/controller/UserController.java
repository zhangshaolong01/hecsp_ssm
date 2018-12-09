package com.bjgoodwill.set.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.set.model.ReturnResult;
import com.bjgoodwill.set.model.User;
import com.bjgoodwill.set.service.IUserService;

/**
 * 用户Controller
 * 
 * @author chronos
 * @date 2017年5月12日 下午1:57:58
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	/*public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}*/
	/**
	 * 新增用户
	 * produces="text/html;charset=UTF-8 解决返回结果中文乱码
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String addUser(User user)	{
		int i = this.userService.addUser(user);
		ReturnResult result = new ReturnResult();
		if(i > 0) {
			result.setStatus(ReturnResult.STATUS_SUCCESS);
			result.setMessage("新增成功！");
		} else {
			result.setStatus(ReturnResult.STATUS_ERROR);
			result.setMessage("新增失败！");
		}
		return JSONObject.toJSONString(result);
	}
	
	@RequestMapping("/query")
	public String queryUser(){
		
		String username = "chronos";	
		this.userService.queryUserByName(username);
		
		return null;
	}
	/**
	 * 查询用户列表
	 * 
	 * @param pageindex
	 * @param pageSize
	 * @param nickName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryList",produces="text/html;charset=UTF-8")
	public String queryUserList(Integer pageindex,Integer pageSize,String nickName){
		
		List<User> list = this.userService.queryUserList(nickName);
		//简单分页
		long total = list.size();
		int startIndex =(pageindex-1)*pageSize;	//开始下标
		int endIndex = (int) (total < (pageindex*pageSize) ? total:(pageindex*pageSize));	//结束下标
		List<User> subUser = list.subList(startIndex,endIndex);//获取子list，左闭右开
		
		JSONObject result = new JSONObject();
		result.put("rows", subUser);
		result.put("total", total);
		System.out.println(result.toJSONString());
		
		return result.toJSONString();
	}
	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update",produces="text/html;charset=UTF-8")
	public String updateUser(User user){

		int count = this.userService.updateUser(user);
		ReturnResult result = new ReturnResult();
		if(count > 0) {
			result.setStatus(ReturnResult.STATUS_SUCCESS);
			result.setMessage("修改成功！");
		} else {
			result.setStatus(ReturnResult.STATUS_ERROR);
			result.setMessage("修改失败！");
		}
		return JSONObject.toJSONString(result);
	}
	
	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces="text/html;charset=UTF-8")
	public String deleteUser(@RequestBody User user){
		
		int count = this.userService.deleteUser(user);
		ReturnResult result = new ReturnResult();
		if(count > 0) {
			result.setStatus(ReturnResult.STATUS_SUCCESS);
			result.setMessage("删除成功！");
		} else {
			result.setStatus(ReturnResult.STATUS_ERROR);
			result.setMessage("删除失败！");
		}
		return JSONObject.toJSONString(result);
	}
	
}
