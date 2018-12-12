var ServiceItemGrid = null, serviceItemId, maintenanceType;
var queryListUrl = basepath + "/set/serviceitem/querylist_serviceItem.action";
var serviceItemDelUrl = basepath + "/set/serviceitem/delete_serviceItem.action";
var serviceItemModUrl = basepath + "/set/serviceitem/modify_serviceItem.action";
var queryServiceCategoryUrl = basepath + "/set/serviceitem/queryServiceCategoryItem_serviceCategory.action";
var serviceCategory = null;
var serviceStandards = null;
$(function () {
    setLanguage("serviceitemPage.js", "", window.parent.languageFlag, window.parent.languagePath);
    setPageControl("n_", serviceItemDataName, "span");
    //初始化表格
    ServiceItemGrid = WoohGrid.createGrid("ServiceItemMainGrid", {
        columns: serviceItemGridHead,
        onSuccess: function (data, grid) {
            if (data.result == "false") {
                $.ligerDialog.error(data.data);
            }
        },
        root: "lServiceItem",
        record: "totalrows",
        allowHideColumn: false,
        colLen: 1,
        rownumbers: true,
        width: '98%',
        isScroll: false
    });
    //check
    setCheckInput("businessType", "cs_business_type", "check", "ServiceItemForm", "q_businessType");
    serviceCategory = setJson({}, queryServiceCategoryUrl).lServiceCategory;
    $('#serviceitemCategoryCode').render_checked({
        hiddenName: "q_serviceitemCategoryCode",
        valueList: serviceCategory,
        type: "check",
        formID: "#ServiceItemForm",
        displayName: "display_name",
        displayValue: "fact_value"
    });

    setCheckInput("subsidyType", "cs_subsidy_type", "check", "ServiceItemForm", "q_subsidyType");
    $('#maintenanceType').render_checked({
        hiddenName: "q_maintenanceType",
        valueList: [
            {"display_name": "内置服务", "fact_value": "0"},
            {"display_name": "自定义服务", "fact_value": "1"}
        ],
        type: "check",
        formID: "#ServiceItemForm",
        displayName: "display_name",
        displayValue: "fact_value"
    });
    $('#status').render_checked({
        hiddenName: "q_status",
        valueList: [
            {"display_name": "禁用", "fact_value": "0"},
            {"display_name": "启用", "fact_value": "1"}
        ],
        type: "check",
        formID: "#ServiceItemForm",
        displayName: "display_name",
        displayValue: "fact_value"
    });

    WoohForm.createForm("ServiceItemForm", {});
    getServiceItemSearch();
});

//查询多行数据
function getServiceItemSearch() {
    if (!ServiceItemGrid) return false;
    setParams("q_");
    ServiceItemGrid.setOptions({parms: params, url: queryListUrl, dataAction: 'server', newPage: 1});
}

//增加数据
function initServiceItemAdd() {
    targetTabJsp("set/serviceitem/jsp/serviceitemAdd.jsp", "服务项目添加");
    //popWin("set/serviceitem/jsp/serviceitemAdd.jsp", "服务项目添加", "700", "400");
}

//修改数据
function initServiceItemModify(id, maintenanceType) {
    $("#qm_serviceItemId").val(id);
    this.maintenanceType = maintenanceType
    targetTabJsp("set/serviceitem/jsp/serviceitemModify.jsp", "服务项目修改");
    //popWin("set/serviceitem/jsp/serviceitemModify.jsp", "服务项目修改", "700", "400");
}

//启用   
function enableServiceItemModify(id) {
    $("#qm_serviceItemId").val(id);
    $("#qm_status").val(1);
    checkSubmitFlag = false;
    ajaxSubmit("qm_", serviceItemModUrl, serviceItemManagement, MODIFY, 2, "ServiceItem");
}

//删除数据
function initServiceItemDelete(id) {
    $("#d_serviceItemId").val(id);
    $.ligerDialog.confirm(serviceItemDelMsg, function (yes) {
            if (yes) {
                if (yes)
                    ajaxSubmit("d_", serviceItemDelUrl, serviceItemManagement, DELETE, 2, "ServiceItem");
            }
        }
    );
}

//查询明细
function initServiceItemDetail(id) {
    $("#qd_serviceItemId").val(id);
    //targetTabJsp("set/serviceitem/jsp/serviceitemDetail.jsp","服务项目明细");
    popWin("set/serviceitem/jsp/serviceitemDetail.jsp", "服务项目明细", "600", "400");
}

//文件上传
function ajaxFileUpload(obj, urlId, nameId) {
    var file_id = $(obj).attr("id");
    var filein = document.getElementById(file_id);
    if (!filein.value == "") {
        var AllImgExt = ".pdf|";
        var FileExt = filein.value.substr(filein.value.lastIndexOf(".")).toLowerCase();
        if (AllImgExt.indexOf(FileExt + "|") == -1) {
            $.ligerDialog.alert('请上传pdf文档!', '提示', 'error');
            document.getElementById(file_id).value = "";
            return false;
        }
        var fileSize = filein.files[0].size;
        var size = fileSize / 1024;
        if (size > 2048 * 10) {
            $.ligerDialog.alert('文件大2048KB,保存失败!', '提示', 'error');
            document.getElementById(file_id).value = "";
            return false;
        }
        var index = filein.value.lastIndexOf("\\");
        $("#id_selectFile").text(filein.value.substring(index + 1));
    }
    jQuery.ajaxFileUpload({
        url: basepath + "/fileupload/uploadFile_file.action", 			//用于文件上传的服务器端请求地址
        secureuri: false, 			//是否需要安全协议，一般设置为false
        fileElementId: file_id, 	//文件上传域的ID
        dataType: 'json', 			//返回值类型 一般设置为json
        success: function (data, status) {
            var uploadUrl = data.resultMap.uploadUrl.replace("\\", "/");
            $("#" + urlId).val(uploadUrl);
            $("#" + nameId).attr("codeUrl", uploadUrl);
            $("#" + nameId).show();
        },
        error: function (data, status, e) {
        } //服务器响应失败处理函数
    });
    return false;
}

function clickOpenStandards(obj) {
    var codeUrl = $(obj).attr("codeUrl");
    if (codeUrl && codeUrl.indexOf("http://") > -1) {
        openServiceStandards(codeUrl)
    }
}

//预览服务要求与标准
function openServiceStandards(_standards) {
    serviceStandards = _standards;
    targetTabJsp("set/serviceitem/jsp/serviceStandardsPreview.jsp", "服务要求与标准预览");
}

//返回
function goback() {
    saveDialogClose();
    getServiceItemSearch();
}