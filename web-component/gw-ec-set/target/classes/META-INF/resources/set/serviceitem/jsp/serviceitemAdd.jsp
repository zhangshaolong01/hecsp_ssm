<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script src="./set/serviceitem/js/serviceitemAdd.js" type="text/javascript"></script>
<style>
    .editForm form label {
        width: 185px;
    }

    .editForm table label {
        width: auto;
    }

    .editForm table a {
        margin-top: 12px;
    }

    .warnMsg {
        margin-right: 31%;
    }

    .selectFile {
        display: inline-block;
        width: 90px;
        border: 1px solid #d2d2d2;
        border-radius: 3px;
        background-color: #fff;
        color: #808080;
        cursor: pointer;
        margin-left: 0px;
    }

    .selectFile:hover, .selectFile:focus, .selectFile:active {
        border-color: #228963;
        color: #228963;
    }
</style>
<div class="editForm editForm2 bg">
    <form id="ServiceItemAddForm" name="ServiceItemAddForm" method="post">
        <input type="hidden" id="a_businessType" name="a_businessType"/>
        <input type="hidden" id="a_subsidyType" name="a_subsidyType"/>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_businessType" class="required"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <input type="text" ltype="text" id="a_businessType_view" name="a_businessType_view"
                       validate="{required:true,maxlength:10}"/>
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_serviceitemCategoryCode"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <input type="hidden" id="a_serviceitemCategoryCode" name="a_serviceitemCategoryCode"/>
                <input type="text" ltype="text" id="a_serviceitemCategoryCode_view"
                       name="a_serviceitemCategoryCode_view"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_serviceItemName"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <input type="text" ltype="text" id="a_serviceItemName" name="a_serviceItemName"
                       validate="{required:true,maxlength:30}"/>
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_workingHours"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="a_workingHours" name="a_workingHours"
                       validate="{required:true,maxlength:10}"/>小时
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_servicePrice"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="a_servicePrice" name="a_servicePrice"
                       validate="{required:true,maxlength:10}"/>元/次
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_monthlyPrice"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="a_monthlyPrice" name="a_monthlyPrice"
                       validate="{required:true,maxlength:10}"/>元/月
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_spbm"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="a_spbm" name="a_spbm"
                       validate="{required:true,maxlength:50}"/>
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_slv"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="a_slv" name="a_slv" value="16"
                       validate="{required:true,digits:true,max:50,min:0}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_subsidyType"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <div id="a_subsidyType_view" name="a_subsidyType_view"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="na_serviceContent"></label>
            </div>
            <div class="col-lg-10 col-md-10 col-xs-10 padding">
                <textarea class="l-textarea textarea_" name="a_serviceContent" id="a_serviceContent" ltype="text"
                          validate="{maxlength:500}" style="width: 69%;"></textarea>
                <div class="warnMsg">限1-100字</div>
            </div>
        </div>
        <div class="row" id="serviceStandardsFlag">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label>上传要求与标准</label>
            </div>
            <div class="col-lg-10 col-md-10 col-xs-10 padding">
                <input type="hidden" id="a_serviceStandards" name="a_serviceStandards"/>
                <div style="display: none">
                    <input type="file" name="upload" id="uploadServiceStandards"
                           onchange="ajaxFileUpload(this,'a_serviceStandards','standardsView');"/>
                </div>
                <span class="selectFile" onclick="$('#uploadServiceStandards').click();">上传PDF文件</span>
                <a style="cursor: pointer;display: none" id="standardsView" codeUrl=""
                   onclick="clickOpenStandards(this);">预览</a>
            </div>
        </div>
    </form>
    <center class="center">
        <input type="button" value="保存" class="savebtn" id="saveAdd" onclick="$('#ServiceItemAddForm').submit()"/>
        <input type="button" value="关闭" class="closebtn" id="closeAdd" onclick="saveDialogClose();"/>
    </center>
</div>