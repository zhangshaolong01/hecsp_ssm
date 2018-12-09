<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>MyBatis测试</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap-table/bootstrap-table.css" >
  </head>
  <body>
  <div class="panel panel-primary">
  	<div class="panel-heading" >用户列表</div>
  	<div class="panel-body">
  	<div id="toolbar" >
  		<form class="form-inline" style="width:100%">
  			<div class="form-group">
  				<input type="button" value="新增用户" id="addBtn" data-toggle="modal" data-target="#addUserModal" class="btn btn-primary" >
  			</div>
  			<div class="form-group">
  				<input type="button" value="删除用户" id="deleteBtn" class="btn btn-primary" onclick="deleteUser()">
  			</div>
  			<div class="form-group">
  				<input type="button" value="修改用户" id="editBtn" class="btn btn-primary" onclick="editUser()">
  			</div>
  			<div class="form-group">
  				<label for="nickname">昵称</label>
  				<input type="text" id="nickname" class="form-control">
  				<input type="button" class="btn btn-primary" id="queryBtn"  value="查询" onclick="queryUser()">
  			</div>
  		</form>
  	
  	</div>
  	<div class="container" style="width:100%">
  		<table id="userList"  >
  		</table>
  	</div>
  	</div>
  	</div>
  	<!-- 新增用户模态窗体 -->
  	<div class="modal fade" id="addUserModal" role="dialog" tabindex="-1">
  		<div class="modal-dialog" role="document">
  		<div class="modal-content">
  		<div class="modal-header ">
  		<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetForm()"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">用户信息</h4>
  		</div>
  		<div class="modal-body">

  		<form id="addUserForm" class="form-horizontal" action="user/add"  method="post">
  			<input type="hidden" name ="id" id="userId">
  			<div class="form-group">
  				<label for="userName" class="col-sm-2 control-label">用户名称：</label>
  				<div class="col-sm-10">
  					<input type="text" name="userName" id="userName" class="form-control">
  				</div>
  			</div>
  			<div class="form-group">
  				<label for="password" class="col-sm-2 control-label">密码：</label>
  				<div class="col-sm-10">
  					<input type="password" name="password" id="password" class="form-control">
  				</div>
  			</div>
  			<div class="form-group">
  				<label for="nickName" class="col-sm-2 control-label">昵称：</label>
  				<div class="col-sm-10">
  					<input type="text" name="nickName" id="nickName" class="form-control">
  				</div>
  			</div>
  			<div class="form-group">
  				<label for="age" class="col-sm-2 control-label">年龄：</label>
  				<div class="col-sm-10">
  					<input type="text" name="age" id="age" class="form-control">
  				</div>
  			</div>
  			<div class="form-group">
  				<label for="sex" class="col-sm-2 control-label">性别：</label>
  				<div class="col-sm-10">
  					<label class="radio-inline">
  						<input type="radio" name="sex" id="sex1" value="true"> 男
					</label>
					<label class="radio-inline">
  						<input type="radio" name="sex" id="sex2" value="false"> 女
					</label>
  				</div>
  			</div>
  			<div class="form-group">
  				<label for="signature" class="col-sm-2 control-label">个性签名：</label>
  				<div class="col-sm-10">
  					<input type="text" name="signature" id="signature" class="form-control">
  				</div>
  			</div>
  		</form>
  		</div>
  		<div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="resetForm()">取消</button>
        <button type="button" class="btn btn-primary" onclick="addUser()">确定</button>
      	</div>
  		</div>
  		</div>
 	 </div>

    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/bootstrap-table/bootstrap-table.js"></script>
    <script src="js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript">
    $(function(){
    	
    	initTable();
    	
    });
    function initTable(){
    	
    	$("#userList").bootstrapTable({
    		method:"POST", 
    	 	contentType : "application/x-www-form-urlencoded", 
    		dataType:"json",
    		url:"user/queryList",
    		queryParams:queryParam,
    		striped: true,
    		pagination:true,
    		pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            uniqueId: "id", 
            sidePagination: "server", 			//server表示服务端分页，client客户端分页 
            singleSelect:true,
            clickToSelect:true,
            showRefresh:true,
            showToggle:true,
            toolbar:"#toolbar",
    		columns:[{
    		    field:"state",
    		    checkbox:"true"
    		},{
    			field:"id",
    			title:"ID"
    		},{
    			field:"userName",
    			title:"用户名称"
    		},{
    			field:"password",
    			title:"密码"
    		},{
    			field:"nickName",
    			title:"昵称"
    		},{
    			field:"age",
    			title:"年龄"
    		},{
    			field:"sex",
    			title:"性别",
    			formatter:function(value){
    				if(value == true) {
    					return '男';
    				} else {
    					return '女';
    				}
    			}
    		},{
    			field:"signature",
    			title:"个性签名"
    		}],
    	});
    }
    function queryParam(params){
    	var param = {
    			nickName:$("#nickname").val(),
    			limit : this.limit, // 页面大小
    	        offset : this.offset, // 页码
    	        pageindex : this.pageNumber,
    	        pageSize : this.pageSize
    	};
    	return param;
    	
    }
    
    //新增用户
    function addUser(){
    	var param = $("#addUserForm").serializeArray();
    	var id = $("#userId").val();
    	var url = "user/add";
    	if ( id != '') {
    		url = "user/update"
    	}
    	$.ajax({
    		url:url,
    		method:"post",
    		data:param,
    		dataType:"json",
    		success:function(data){
    			if (data.status = "success") {
    				$("#userList").bootstrapTable("refresh");
    				$("#addUserModal").modal("hide");
    				resetForm();
    			}
    			alert(data.message);
    		},
    		error:function(data){
    			
    			alert("服务器异常！");
    		}
    	});
    	
    }
    //清空表单数据
    function resetForm(){
    	document.getElementById("addUserForm").reset(); 
    }
    //删除用户
    function deleteUser(){
    	
    	var rows = $("#userList").bootstrapTable('getSelections');
    	var id = rows[0].id;
    	var data = {"id":id,"userName":"aaa"};
    	if (rows.length<=0 ) {
    		alert("请选择一条记录！");
    		return;
    	}
    	$.ajax({
    		url:"user/delete",
    		method:"post",
    		dataType:"json",
    		contentType:"application/json;charset=UTF-8",
    		data:JSON.stringify(data),
    		success:function(data){
    			alert(data.message);
    			$("#userList").bootstrapTable("refresh");
    		},
    		error:function(data){
    			alert("服务器异常！！");
    		}
    		
    	});
    }
    //修改用户
    function editUser(){
    	var rows = $("#userList").bootstrapTable('getSelections');
    	if (rows.length<=0 ) {
    		alert("请选择一条记录！");
    		return;
    	}
    	
    	var row = rows[0];
    	$("#userId").val(row.id);
    	$("#userName").val(row.userName);
    	$("#password").val(row.password);
    	$("#nickName").val(row.nickName);
    	$("#age").val(row.age);
    	if(row.sex == true) {
    		$("#sex1").attr('checked', 'checked');
    	} else {
    		$('#sex2').attr('checked', 'checked');
    	}
    	$("#signature").val(row.signature);
    	
    	$("#addUserModal").modal("show");
    	
    }
   
    //查询用户
    function queryUser(){
    	$("#userList").bootstrapTable("refresh");
    }
    
    </script>
    
  </body>
</html>