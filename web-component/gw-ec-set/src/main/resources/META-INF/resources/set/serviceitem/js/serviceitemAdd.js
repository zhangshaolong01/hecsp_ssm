var serviceItemAddUrl = basepath + "/set/serviceitem/insert_serviceItem.action";
var querListUrl = basepath + "/set/serviceitem/querylistNP_serviceItem.action";
var categoryCombobox = null, csData = new Array(), hpData = new Array(), sendData = new Array();
$(function () {
    setPageControl("na_", serviceItemDataName, "span");
    $.metadata.setType("attr", "validate");
    $("#ServiceItemAddForm").validate({
        errorPlacement: function (lable, element) {
            errorPlacement(lable, element);
        },
        success: function (lable) {
            success(lable);
        },
        submitHandler: function () {
            submitHandler();
            submitServiceItemAdd();
        }
    });

    if (!serviceCategory) {
        serviceCategory = setJson({}, queryServiceCategoryUrl).lServiceCategory;
    }

    var typesata = getDict("cs_business_type");

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

    categoryCombobox = $("#a_serviceitemCategoryCode_view").ligerComboBox({
        valueField: "fact_value",
        textField: "display_name",
        width: 180,
        cancelable: false,
        data: null,
        valueFieldID: "a_serviceitemCategoryCode",
        onSelected: function (newvalue, text) {
        }
    });


    $("#a_businessType_view").ligerComboBox({
        valueField: "fact_value",
        textField: "display_name",
        width: 180,
        data: typesata,
        valueFieldID: "a_businessType",
        onSelected: function (newvalue, text) {
            $("#a_serviceitemCategoryCode").val("");
            if (newvalue == 1) {//上门
                categoryCombobox.setData(hpData);
            } else if (newvalue == 0) {
                categoryCombobox.setData(csData);
            } else if (newvalue == 2) {//派送
                categoryCombobox.setData(sendData);
            }
        }
    });

    $("#a_subsidyType_view").ligerCheckBoxList({
        valueField: "fact_value",
        textField: "display_name",
        valueFieldID: "a_subsidyType",
        value: 0,
        data: getDict("cs_subsidy_type")
    });
    if (systemInfo && systemInfo["systemFlag"] == 1) {
        $("#serviceStandardsFlag").hide();
    }
    WoohForm.createForm('ServiceItemAddForm', {});
});

//增加数据
function submitServiceItemAdd() {
    checkServiceItemName();
    ajaxSubmit("a_", serviceItemAddUrl, serviceItemManagement, ADD, 3, "goback()");
}

function checkServiceItemName() {
    var serviceItemName = $("#a_serviceItemName").val();
    if (serviceItemName != null && serviceItemName != "") {
        var serviceItemNameJson = "{\"serviceItemName\":\"" + serviceItemName + "\"}";
        var data = ajaxJsonGet(serviceItemNameJson, querListUrl, "lServiceItem");
        if (data.length > 0) {
            WoohCommon.showMessage("warning", "服务项目已存在!")
            return;
        }
    }
} 