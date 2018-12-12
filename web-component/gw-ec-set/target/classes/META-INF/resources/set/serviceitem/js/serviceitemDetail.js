var serviceItemDetUrl=basepath+"/set/serviceitem/query_serviceItem.action";

$(function (){
	setPageControl("nd_",serviceItemDataName,"span");
    setServiceItemDetail();
	$("#closeDetail").val(gcloseWord);
});  
      	
//初始页面数据
function setServiceItemDetail(){
	var ServiceItemObj = ajaxSet("qd_",serviceItemDetUrl,"lServiceItem","det_","span");
	if(ServiceItemObj.lServiceItem&&ServiceItemObj.lServiceItem.length>0){
		var ServiceItem = ServiceItemObj.lServiceItem[0];
		if(ServiceItem.servicePrice){
			$("#det_servicePrice").text(StringUtils.formatMoney(ServiceItem.servicePrice,2,1));
		}
		if(ServiceItem.monthlyPrice){
			$("#det_monthlyPrice").text(StringUtils.formatMoney(ServiceItem.monthlyPrice,2,1));
		}
	}
}