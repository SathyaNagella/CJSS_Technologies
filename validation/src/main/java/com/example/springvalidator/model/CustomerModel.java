package com.example.springvalidator.model;
import com.example.springvalidator.validation.MyValid;
import javax.validation.constraints.*;
public class CustomerModel {
    @Min(value = 1,message = "Id must be in Positive Numbers")
    private Integer cusId;
    private String cusFirstName;
    @NotEmpty(message = "cusLast Name is Required")
    private String cusLastName;
    @Email(message = "Must end with @gmail.com")
    private String cusEmail;
    private Long cusMobileNo;
    @MyValid()
    private String cusCity;
    public CustomerModel() {
    }

    public CustomerModel(Integer cusId, String cusFirstName, String cusLastName, String cusEmail, Long cusMobileNo, String cusCity) {
        this.cusId = cusId;
        this.cusFirstName = cusFirstName;
        this.cusLastName = cusLastName;
        this.cusEmail = cusEmail;
        this.cusMobileNo = cusMobileNo;
        this.cusCity = cusCity;
    }

    public Integer getCusId() { return cusId;}

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

    @Override
    public String toString() {
        return "CustomerModel{" +
                "cusId=" + cusId +
                ", cusFirstName='" + cusFirstName + '\'' +
                ", cusLastName='" + cusLastName + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusMobileNo=" + cusMobileNo +
                ", cusCity='" + cusCity + '\'' +
                '}';
    }
}
