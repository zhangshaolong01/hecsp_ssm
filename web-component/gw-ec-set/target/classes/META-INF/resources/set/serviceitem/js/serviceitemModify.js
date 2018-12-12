var serviceItemDetUrl = basepath + "/set/serviceitem/query_serviceItem.action";
var subsidyTypeCheckBoxList = null, businessTypeCombobox = null, categoryCombobox = null;
var csData = new Array(), hpData = new Array(), sendData = new Array();
$(function () {
    setPageControl("nm_", serviceItemDataName, "span");
    $.metadata.setType("attr", "validate");
    $("#ServiceItemModifyForm").validate({
        errorPlacement: function (lable, element) {
            errorPlacement(lable, element);
        },
        success: function (lable) {
            success(lable);
        },
        submitHandler: function () {
            submitHandler();
            submitServiceItemModify();
        }
    });

    subsidyTypeCheckBoxList = $("#m_subsidyType_view").ligerCheckBoxList({
        valueField: "fact_value",
        textField: "display_name",
        valueFieldID: "m_subsidyType",
        css: "aCheckbox",
        data: getDict("cs_subsidy_type")
    });
    //初始化
    setServiceItem();

    if (!serviceCategory) {
        serviceCategory = setJson({}, queryServiceCategoryUrl).lServiceCategory;
    }
    for (index in serviceCategory) {
        var businessType = serviceCategory[index].business_type;
        if (businessType == 1) {//上门
            hpData.push(serviceCategory[index]);
        } else if (businessType == 0) {
            csData.push(serviceCategory[index]);
        } else if (businessType == 2) {//派送
            sendData.push(serviceCategory[index]);
        }
    }
    ;

    categoryCombobox = $("#m_serviceitemCategoryCode_view").ligerComboBox({
        valueField: "fact_value",
        textField: "display_name",
        width: 180,
        cancelable: false,
        data: null,
        valueFieldID: "m_serviceitemCategoryCode",
        onSelected: function (newvalue, text) {
        }
    });
    var serviceitemCategory = $("#m_serviceitemCategoryCode").val();
    var businessType = $("#m_businessType").val();
    businessTypeCombobox = $("#m_businessType_view").ligerComboBox({
        valueField: "fact_value",
        textField: "display_name",
        width: 180,
        cancelable: false,
        data: getDict("cs_business_type"),
        valueFieldID: "m_businessType",
        value: businessType,
        onSelected: function (newvalue, text) {
            $("#m_serviceitemCategoryCode").val("");
            if (newvalue == 1) {//上门
                categoryCombobox.setData(hpData);
            } else if (newvalue == 0) {
                categoryCombobox.setData(csData);
            } else if (newvalue == 2) {//派送
                categoryCombobox.setData(sendData);
            }
        }
    });

    categoryCombobox.setValue(serviceitemCategory);

    if (maintenanceType == 0) {
        categoryCombobox.setDisabled();
        businessTypeCombobox.setDisabled();
        $("#m_serviceItemName").attr("disabled", "disabled");
    }
    $("#saveModify").val(gsaveWord);
    $("#closeModify").val(gcloseWord);
    if (systemInfo && systemInfo["systemFlag"] == 1) {
        $("#serviceStandardsFlag").hide();
    }
    WoohForm.createForm('ServiceItemModifyForm', {});

});

//修改数据
function submitServiceItemModify() {
    ajaxSubmit("m_", serviceItemModUrl, serviceItemManagement, MODIFY, 3, "goback()");
}

//初始页面数据
function setServiceItem() {
    var ServiceItemObj = ajaxSet("qm_", serviceItemDetUrl, "lServiceItem", "m_");
    if (ServiceItemObj.lServiceItem && ServiceItemObj.lServiceItem.length > 0) {
        var ServiceItem = ServiceItemObj.lServiceItem[0];
        subsidyTypeCheckBoxList.setValue(ServiceItem.subsidyType);
        if (ServiceItem.serviceStandards && ServiceItem.serviceStandards.indexOf("http://") > -1) {
            $("#standardsView").attr("codeUrl", ServiceItem.serviceStandards);
            $("#standardsView").show();
        }
    }
}

