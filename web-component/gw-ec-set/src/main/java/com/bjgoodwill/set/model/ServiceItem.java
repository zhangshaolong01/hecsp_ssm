package com.bjgoodwill.set.model;

import java.util.Date;

import com.bjgoodwill.common.domain.EcBaseObject;

/**
 * @author zhangshaolong
 * @description 服务项对象
 * @createtime 2017-12-20
 */
@SuppressWarnings("serial")
public class ServiceItem extends EcBaseObject {

    private String serviceItemId;    //service_item_id String 32
    private String businessType;    //0  护理   1 上门 String 1
    private String businessTypeView;
    private String serviceitemCategoryCode;    //来自字典 String 30
    private String serviceitemCategoryCodeView;
    private String serviceItemName;    //服务项目名称 String 30
    private String serviceItemCode;    //服务项目编码 String 30
    private Double workingHours;    // Double 12
    private Double servicePrice;    //服务价格 Double 12
    private Double monthlyPrice;    // Double 12
    private String subsidyType;    //0自营  1长照项目  2老龄补贴 String 1
    private String subsidyTypeView;
    private String maintenanceType;    //0内置  1自定义 String 1
    private String serviceContent;    //服务项目描述 String 100
    private String serviceStandards;    //服务要求与标准 String 255
    private String status; //状态

    private String validFlag;    // String 4
    private Date createTime;    // Date 19
    private Date updateTime;    // Date 19
    private String operateMan;    // String 120
    private String operateReason;    // String 200
    private String institutionId;    // String 32
    private ServiceItem where;

    private String slv;
    private String spbm;

    //service_item_id
    public String getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(String serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    //0  护理   1 上门
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
        this.businessTypeView = businessType;
    }

    //来自字典
    public String getServiceitemCategoryCode() {
        return serviceitemCategoryCode;
    }

    public void setServiceitemCategoryCode(String serviceitemCategoryCode) {
        this.serviceitemCategoryCode = serviceitemCategoryCode;
        this.serviceitemCategoryCodeView = serviceitemCategoryCode;
    }

    //服务项目名称
    public String getServiceItemName() {
        return serviceItemName;
    }

    public void setServiceItemName(String serviceItemName) {
        this.serviceItemName = serviceItemName;
    }

    //服务项目编码
    public String getServiceItemCode() {
        return serviceItemCode;
    }

    public void setServiceItemCode(String serviceItemCode) {
        this.serviceItemCode = serviceItemCode;
    }

    //
    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    //服务价格
    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    //
    public Double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(Double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    //0自营  1长照项目  2老龄补贴
    public String getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(String subsidyType) {
        this.subsidyType = subsidyType;
        this.subsidyTypeView = subsidyType;
    }

    //0内置  1自定义
    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    //服务项目描述
    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    //服务要求与标准
    public String getServiceStandards() {
        return serviceStandards;
    }

    public void setServiceStandards(String serviceStandards) {
        this.serviceStandards = serviceStandards;
    }

    //
    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    //
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    //
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    //
    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    //
    public String getOperateReason() {
        return operateReason;
    }

    public void setOperateReason(String operateReason) {
        this.operateReason = operateReason;
    }

    //
    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getBusinessTypeView() {
        return businessTypeView;
    }

    public void setBusinessTypeView(String businessTypeView) {
        this.businessTypeView = businessTypeView;
    }

    public String getServiceitemCategoryCodeView() {
        return serviceitemCategoryCodeView;
    }

    public void setServiceitemCategoryCodeView(String serviceitemCategoryCodeView) {
        this.serviceitemCategoryCodeView = serviceitemCategoryCodeView;
    }

    public String getSubsidyTypeView() {
        return subsidyTypeView;
    }

    public void setSubsidyTypeView(String subsidyTypeView) {
        this.subsidyTypeView = subsidyTypeView;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //修改条件
    public ServiceItem getWhere() {
        return where;
    }

    public void setWhere(ServiceItem where) {
        this.where = where;
    }

    public String getSlv() {
        return slv;
    }

    public void setSlv(String slv) {
        this.slv = slv;
    }

    public String getSpbm() {
        return spbm;
    }

    public void setSpbm(String spbm) {
        this.spbm = spbm;
    }

}