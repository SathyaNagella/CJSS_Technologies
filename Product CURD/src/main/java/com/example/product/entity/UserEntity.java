package com.example.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String userMobileNo;

    private String userPassWord;

    public UserEntity() {}

    public UserEntity(String userId, String userName, String userMobileNo, String userPassWord) {
        this.userId = userId;
        this.userName = userName;
        this.userMobileNo = userMobileNo;
        this.userPassWord = userPassWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }
}
