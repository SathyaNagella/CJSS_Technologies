package com.example.product.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@Entity
public class AdminEntity {
    @Id
    @NotNull(message = "must required")
    private String adminId;
    @NotNull(message = "Enter Name")
    private String adminName;
    //@NotEmpty(message = "Enter MobileNo")
    private Long adminMobileNo;
    private String role;

    public AdminEntity() {}

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminMobileNo=" + adminMobileNo +
                '}';
    }

}
