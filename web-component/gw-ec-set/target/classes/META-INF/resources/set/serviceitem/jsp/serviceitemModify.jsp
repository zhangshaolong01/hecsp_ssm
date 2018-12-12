<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script src="./set/serviceitem/js/serviceitemModify.js" type="text/javascript"></script>
<style>
    .editForm form label {
        width: 185px;
    }

    .editForm .aCheckbox label {
        width: auto;
    }

    .editForm .aCheckbox .l-checkbox-wrapper {
        margin-top: 7px;
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
    <form id="ServiceItemModifyForm" name="ServiceItemModifyForm" method="post">
        <input type="hidden" id="m_serviceItemId" name="m_serviceItemId"/>
        <input type="hidden" id="m_businessType" name="m_businessType"/>
        <input type="hidden" id="m_serviceitemCategoryCode" name="m_serviceitemCategoryCode"/>
        <input type="hidden" id="m_subsidyType" name="m_subsidyType"/>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_businessType" class="required"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <input type="text" ltype="text" id="m_businessType_view" name="m_businessType_view"
                       validate="{required:true,maxlength:10}"/>
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_serviceitemCategoryCode"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <input type="text" ltype="text" id="m_serviceitemCategoryCode_view"
                       name="m_serviceitemCategoryCode_view" validate="{required:true,maxlength:30}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_serviceItemName"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <input type="text" ltype="text" id="m_serviceItemName" name="m_serviceItemName"
                       validate="{required:true,maxlength:30}"/>
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_workingHours"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="m_workingHours" name="m_workingHours"
                       validate="{required:true,maxlength:10}"/> 小时
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_servicePrice"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="m_servicePrice" name="m_servicePrice"
                       validate="{required:true,maxlength:10}"/> 元/次
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_monthlyPrice"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="m_monthlyPrice" name="m_monthlyPrice"
                       validate="{required:true,maxlength:10}"/> 元/月
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_spbm"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="m_spbm" name="m_spbm"
                       validate="{required:true,maxlength:50}"/>
            </div>
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_slv"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding lineHeight">
                <input type="text" ltype="text" id="m_slv" name="m_slv" value="16"
                       validate="{required:true,digits:true,max:50,min:0}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_subsidyType"></label>
            </div>
            <div class="col-lg-3 col-md-3 col-xs-3 padding">
                <div id="m_subsidyType_view"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label id="nm_serviceContent"></label>
            </div>
            <div class="col-lg-10 col-md-10 col-xs-10 padding">
                <textarea class="l-textarea textarea_" name="m_serviceContent" id="m_serviceContent" ltype="text"
                          validate="{maxlength:500}" style="width: 69%;"></textarea>
                <div class="warnMsg">限1-100字</div>
            </div>
        </div>
        <div class="row" id="serviceStandardsFlag">
            <div class="col-lg-2 col-md-2 col-xs-2 padding text-right">
                <label>上传要求与标准</label>
            </div>
            <div class="col-lg-10 col-md-10 col-xs-10 padding">
                <input type="hidden" id="m_serviceStandards" name="m_serviceStandards"/>
                <div style="display: none">
                    <input type="file" name="upload" id="uploadServiceStandards"
                           onchange="ajaxFileUpload(this,'m_serviceStandards','standardsView');"/>
                </div>
                <span class="selectFile" onclick="$('#uploadServiceStandards').click();">上传PDF文件</span>
                <a style="cursor: pointer;display: none" id="standardsView" codeUrl=""
                   onclick="clickOpenStandards(this);">预览</a>
            </div>
        </div>
    </form>
    <center class="center">
        <input type="button" value="保存" class="savebtn" id="saveModify" onclick="$('#ServiceItemModifyForm').submit()"/>
        <input type="button" value="关闭" class="closebtn" id="closeModify" onclick="saveDialogClose();"/>
    </center>
</div>