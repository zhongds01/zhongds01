package com.zds.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Custom {
    private Long custId;

    private String custName;

    private String custPwd;

    private String custSex;

    private Long custTel;

    private String custEmail;

    private String custAddress;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyDate;

    private String state;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustPwd() {
        return custPwd;
    }

    public void setCustPwd(String custPwd) {
        this.custPwd = custPwd == null ? null : custPwd.trim();
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex == null ? null : custSex.trim();
    }

    public Long getCustTel() {
        return custTel;
    }

    public void setCustTel(Long custTel) {
        this.custTel = custTel;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}