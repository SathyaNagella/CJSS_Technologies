package com.example.springvalidator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerEntity {
    @Id
    private Integer cusId;
    private String cusFirstName;
    private String cusLastName;
    private String cusEmail;

    private Long cusMobileNo;
    private String cusCity;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public Long getCusMobileNo() {
        return cusMobileNo;
    }

    public void setCusMobileNo(Long cusMobileNo) {
        this.cusMobileNo = cusMobileNo;
    }

    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

}
