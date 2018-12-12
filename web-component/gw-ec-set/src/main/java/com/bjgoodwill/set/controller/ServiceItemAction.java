package com.bjgoodwill.set.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjgoodwill.set.model.ServiceItem;
import com.bjgoodwill.set.service.IServiceItemService;
import com.github.pagehelper.Page;

/**
 * 功能描述：服务项信息
 * 作者：zhangshaolong
 * 版本：1.0.0
 */
@Controller
@RequestMapping("/set/serviceitem")
public class ServiceItemAction{
    private IServiceItemService serviceItemService;
    private List lServiceItem = new ArrayList();
    private int totalrows = 0;
    private String result = "";
    private String condition;

    /**
     * 描述：分页信息查询服务项
     *
     * @return
     * @throws Exception
     */
    /*public String querylist() throws Exception {
        try {
            Map map = this.requestDataToMap();
            Page pageInfo = serviceItemService.getListForPage(map, pagesize, pagerow, sort, dir);
            totalpage = pageInfo.getTotalPages();
            totalrows = pageInfo.getTotalRows();
            lServiceItem = pageInfo.getData();

            Map<String, Object> transmap = new HashMap<>();
            transmap.put("businessTypeView", "cs_business_type");
            DictUtil.CodeToName(lServiceItem, transmap);
            
            transmap.clear();
            transmap.put("serviceitemCategoryCodeView", "cs_service_category");
            ServiceCategoryUtil.CodeToName(lServiceItem, transmap);
            
            this.result = "success";
        } catch (Exception e) { 
            e.printStackTrace();
            this.result = e.getMessage();
        }
        return "success";
    }*/
    
    
    /**
     * 描述：分页信息查询服务项
     *
     * @return
     * @throws Exception
     */
    /*public String querylistforPackage() throws Exception {
        try {
            Map map = this.requestDataToMap();
            Page pageInfo = serviceItemService.getListForPageforPackage(map, pagesize, pagerow, sort, dir);
            totalpage = pageInfo.getTotalPages();
            totalrows = pageInfo.getTotalRows();
            lServiceItem = pageInfo.getData();

            Map<String, Object> transmap = new HashMap<>();
            transmap.put("businessTypeView", "cs_business_type");
            DictUtil.CodeToName(lServiceItem, transmap);
            
            transmap.clear();
            transmap.put("serviceitemCategoryCodeView", "cs_service_category");
            ServiceCategoryUtil.CodeToName(lServiceItem, transmap);
            
            this.result = "success";
        } catch (Exception e) { 
            e.printStackTrace();
            this.result = e.getMessage();
        }
        return "success";
    }
    */

    /**
     * 描述：服务项单条信息查询
     *
     * @return
     * @throws Exception
     */
    /*public String query() throws Exception {
        try {
            ServiceItem queryEntity = (ServiceItem) requestDataToEntity(ServiceItem.class);
            ServiceItem entity = serviceItemService.get(queryEntity);
            lServiceItem.clear();
            lServiceItem.add(entity);

            Map<String, Object> transmap = new HashMap<>();
            transmap.put("businessTypeView", "cs_business_type");
            transmap.put("subsidyTypeView", "cs_subsidy_type");
            DictUtil.CodeToName(lServiceItem, transmap);
            
            transmap.clear();
            transmap.put("serviceitemCategoryCodeView", "cs_service_category");
            ServiceCategoryUtil.CodeToName(lServiceItem, transmap);
            
            this.result = "success";
        } catch (Exception e) {
            this.result = e.getMessage();
        }
        return "success";
    }*/

    /**
     * 描述：添加服务项数据
     *
     * @return
     * @throws Exception
     */
   /* public String insert() throws Exception {
        try {
            ServiceItem entity = (ServiceItem) requestDataToEntity(ServiceItem.class);
            entity.setMaintenanceType("1");//自定义
            entity = serviceItemService.insert(entity);
            this.result = "success";
        } catch (Exception e) {
            this.result = e.getMessage();
        }
        return "success";
    }*/

    /**
     * 修改服务项数据
     * 描述：
     *
     * @return
     * @throws Exception
     */
   /* public String modify() throws Exception {
        try {
            ServiceItem entity = (ServiceItem) requestDataToEntity(ServiceItem.class);
            ServiceItem entitywhere = new ServiceItem();
            entitywhere.setServiceItemId(entity.getServiceItemId());
            entity.setWhere(entitywhere);
            serviceItemService.update(entity);
            this.result = "success";
        } catch (Exception e) {
            this.result = e.getMessage();
        }
        return "success";
    }*/

    /**
     * 描述：删除服务项数据
     *
     * @return
     * @throws Exception
     */
   /* public String delete() throws Exception {
        try {
            ServiceItem entity = (ServiceItem) requestDataToEntity(ServiceItem.class);
            entity.setValidFlag(ConstantUtil.UN_VALIDFLAG);
            ServiceItem entitywhere = new ServiceItem();
            entitywhere.setServiceItemId(entity.getServiceItemId());
            entity.setWhere(entitywhere);
            serviceItemService.update(entity);
            this.result = "success";
        } catch (Exception e) {
            this.result = e.getMessage();
        }
        return "success";
    }*/

    /**
     * 描述：不分页查询服务项
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
	@RequestMapping(value="/querylist_serviceItem.action",produces="text/html;charset=UTF-8")
    public String querylistNP(ServiceItem entity) throws Exception {
        try {
            //ServiceItem entity = (ServiceItem) requestDataToEntity(ServiceItem.class);
            lServiceItem = serviceItemService.getList(entity);
            this.result = "success";
        } catch (Exception e) {
            this.result = e.getMessage();
        }
        return "success";
    }

    /**
     * 描述：其他页面调用服务项的方法
     *
     * @return
     */
  /*  public String queryPublishlistPublic() throws Exception {

        try {
            Map<String, Object> map = null;
            if (StringUtils.isNotEmpty(data)) {
                map = this.requestDataToMap();
            } else {
                map = new HashMap<String, Object>();
            }
            map.put("businessType", "1");
            Page page = serviceItemService.getListForPage(map, pagesize, pagerow, sort, dir);
            totalpage = page.getTotalPages();
            totalrows = page.getTotalRows();
            lServiceItem = page.getData();
            Map<String, Object> convMap = new HashMap<>();
            convMap.put("serviceitemCategoryCodeView", "cs_service_category");
            ServiceCategoryUtil.CodeToName(lServiceItem, convMap);
            this.result = "success";
        } catch (Exception e) {
            this.result = e.getMessage();
        }
        return SUCCESS;
    }
*/
    public void setServiceItemService(IServiceItemService serviceItemService) {
        this.serviceItemService = serviceItemService;
    }

    public List getlServiceItem() {
        return lServiceItem;
    }

    public void setlServiceItem(List lServiceItem) {
        this.lServiceItem = lServiceItem;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getTotalrows() {
        return totalrows;
    }

    public void setTotalrows(int totalrows) {
        this.totalrows = totalrows;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}