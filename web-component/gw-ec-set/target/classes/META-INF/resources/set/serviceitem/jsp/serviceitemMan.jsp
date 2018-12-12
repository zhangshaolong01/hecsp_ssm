<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script src="./set/serviceitem/js/serviceitemMan.js" type="text/javascript"></script>
<div class="container">
    <form id="ServiceItemForm" name="ServiceItemForm" class="queryForm">
        <input name="d_serviceItemId" type="hidden" id="d_serviceItemId"/>
        <input name="qd_serviceItemId" type="hidden" id="qd_serviceItemId"/>
        <input name="qm_serviceItemId" type="hidden" id="qm_serviceItemId"/>
        <input name="qm_status" type="hidden" id="qm_status"/>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-4">
                <input name="q_serviceItemName" type="text" id="q_serviceItemName" ltype="text" placeholder="请输入服务项目名称"
                       width="25%"/>
            </div>
            <div class="col-lg-3 col-md-1 col-sm-2">
                <button class="btn btn-default" type="button" onclick="getServiceItemSearch()">查询</button>
            </div>
            <div id="more" class="pull-right">
                <div class="gw_more" data-toggle="collapse" data-target="#detail">
                    更多筛选条件<i id="moreCon" class="fa fa-chevron-circle-down"></i>
                </div>
            </div>
        </div>
        <div id="detail" class="box panel-collapse collapse topGap">
            <div class="row">
                <label id="n_businessType"></label>
                <div id="businessType"></div>
            </div>
            <div class="row">
                <label id="n_serviceitemCategoryCode"></label>
                <div id="serviceitemCategoryCode" class="col-md-10"></div>
            </div>
            <div class="row">
                <label id="n_subsidyType"></label>
                <div id="subsidyType"></div>
            </div>
            <div class="row">
                <label id="n_maintenanceType"></label>
                <div id="maintenanceType"></div>
            </div>
            <div class="row">
                <label id="n_status"></label>
                <div id="status"></div>
            </div>
        </div>
    </form>
    <div class="box topGap">
        <div class="row">
            <div class="col-lg-12 ocl-md-12 col-xs-12">
                <h1 class="title">查询结果
                    <span class="btnGrp">
						<i title="新增" class="fa fa-plus" onclick="initServiceItemAdd();"></i>
					</span>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-xs-12">
                <div id="ServiceItemMainGrid"></div>
            </div>
        </div>
    </div>
</div>