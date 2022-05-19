package com.demo.vo;

import java.io.Serializable;

/**
 * 联系人（t_contact表对应的Java实体类）
 */
public class Contact implements Serializable {
    private Long id;//主键
    private String contactName;//姓名
    private String contactSex;//性别:男/女
    private String contactType;//关系
    private String contactPhone;//电话
    private String contactAddress;//地址
    private String contactText;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactSex() {
        return contactSex;
    }

    public void setContactSex(String contactSex) {
        this.contactSex = contactSex;
    }
    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
    public String getContactText() {
        return contactText;
    }

    public void setContactText(String contactText) {
        this.contactText = contactText;
    }
}
