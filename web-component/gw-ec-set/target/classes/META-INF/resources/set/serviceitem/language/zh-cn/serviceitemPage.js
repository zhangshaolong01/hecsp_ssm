var serviceItemDataName = [{
    serviceItemId: "service_item_id",
    businessType: "业务类型",
    serviceitemCategoryCode: "服务类别",
    serviceItemName: "服务项目",
    serviceItemCode: "服务项目编码",
    workingHours: "服务工时",
    servicePrice: "服务单价",
    monthlyPrice: "包月价格",
    subsidyType: "补贴类型",
    maintenanceType: "维护类型",
    serviceContent: "服务项目描述",
    serviceStandards: "服务要求与标准",
    status: "状态",
    slv: "税率",
    spbm: "商品编码"
}];

var serviceItemGridHead = [
    //{display: 'service_item_id', name: 'serviceItemId', width: '10%', align: 'center', isSort: false},
    {display: '服务项目', name: 'serviceItemName', width: '15%', align: 'center', isSort: false},
    {display: '服务类别', name: 'serviceitemCategoryCodeView', width: '8%', align: 'center', isSort: false},
    {display: '业务类型', name: 'businessTypeView', width: '8%', align: 'center', isSort: false},
    {
        display: '维护类型', name: 'maintenanceType', width: '8%', align: 'center', isSort: false,
        render: function (rowdata, rowindex, value) {
            if (value == 0) return "内置";
            return "自定义";
        }
    },
    //{display: '服务项目编码', name: 'serviceItemCode', width: '10%', align: 'center', isSort: false},
    {display: '工时(小时)', name: 'workingHours', width: '8%', align: 'right', isSort: false},
    {
        display: '服务单价(元/次)', name: 'servicePrice', width: '10%', align: 'right', isSort: false,
        render: function (rowdata, rowindex, value) {
            return StringUtils.formatMoney(value, 2, 0);
        }
    },
    {
        display: '包月价格(元/月)', name: 'monthlyPrice', width: '10%', align: 'right', isSort: false,
        render: function (rowdata, rowindex, value) {
            return StringUtils.formatMoney(value, 2, 0);
        }
    },
    {
        display: '状态', name: 'status', width: '8%', align: 'center', isSort: false,
        render: function (rowdata, rowindex, value) {
            if (value == 1) return "启用";
            return "禁用";
        }
    },
    {
        display: '操作', isSort: false, width: '14%',
        render: function (rowdata, rowindex, value) {
            var optGrp = new Array();
            optGrp.push({
                "name": "明细",
                "icon": "fa fa-info",
                "action": "initServiceItemDetail(\"" + rowdata.serviceItemId + "\")"
            });
            optGrp.push({
                "name": "修改",
                "icon": "fa fa-pencil",
                "action": "initServiceItemModify(\"" + rowdata.serviceItemId + "\",\"" + rowdata.maintenanceType + "\")"
            });

            if (!(systemInfo && systemInfo["systemFlag"] == 1)) {
                if (rowdata.serviceStandards && rowdata.serviceStandards.indexOf("http://") > -1) {
                    optGrp.push({
                        "name": "预览",
                        "icon": "fas fa-align-justify",
                        "action": "openServiceStandards('" + rowdata.serviceStandards + "')"
                    });
                }
            }

            if (rowdata.status != 1) {
                optGrp.push({
                    "name": "启用",
                    "icon": "fa-check",
                    "action": "enableServiceItemModify(\"" + rowdata.serviceItemId + "\")"
                });
            }
            if (rowdata.maintenanceType != 0) {
                optGrp.push({
                    "name": "删除",
                    "icon": "fa-trash-o",
                    "action": "initServiceItemDelete(\"" + rowdata.serviceItemId + "\")"
                });
            }
            return outputOpt(optGrp);
        }
    }
];

var ADD = "添加";
var DELETE = "删除";
var MODIFY = "修改";
var DETAIL = "详情";
var gsearchWord = "查询";
var gsaveWord = "保存";
var gcloseWord = "关闭";
var serviceItemManagement = "服务项";
var serviceItemManagementADD = serviceItemManagement + ADD;
var serviceItemManagementMODIFY = serviceItemManagement + MODIFY;
var serviceItemManagementDETAIL = serviceItemManagement + DETAIL;
var serviceItemDelMsg = "是否要删除服务项？";