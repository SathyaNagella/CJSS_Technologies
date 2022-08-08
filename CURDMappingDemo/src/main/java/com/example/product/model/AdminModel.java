package com.example.product.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AdminModel {
    private String adminId;
    private String adminName;
    private Long adminMobileNo;

    public AdminModel() {}

    public AdminModel(String adminId, String adminName, Long adminMobileNo) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminMobileNo = adminMobileNo;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Long getAdminMobileNo() {
        return adminMobileNo;
    }

    public void setAdminMobileNo(Long adminMobileNo) {
        this.adminMobileNo = adminMobileNo;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminMobileNo=" + adminMobileNo +
                '}';
    }
}
