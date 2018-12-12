<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script src="./set/serviceitem/js/serviceitemDetail.js" type="text/javascript"></script>
<div class="editForm padd10">
    <form id="ServiceItemDetailForm" name="ServiceItemDetailForm" method="post" class="form185">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_businessType"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_businessTypeView"></span>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_serviceitemCategoryCode"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_serviceitemCategoryCodeView"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_serviceItemName"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_serviceItemName"></span>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_workingHours"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_workingHours"></span>小时
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_servicePrice"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_servicePrice"></span>元/次
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_monthlyPrice"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_monthlyPrice"></span>元/月
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_spbm"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_spbm"></span>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_slv"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_slv"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_subsidyType"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <span id="det_subsidyTypeView"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-3 padding text-right">
                <label id="nd_serviceContent"></label>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-8 padding">
                <span id="det_serviceContent"></span>
            </div>
        </div>
    </form>
    <center class="center" style="margin-left: 230px;">
        <input type="button" value="关闭" id="closeDetail" class="closebtn" onclick="saveDialogClose();"/>
    </center>
</div>              