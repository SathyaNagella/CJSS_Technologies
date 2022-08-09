package com.example.product.model;

public class UserModel {
    private String userId;
    private String userName;
    private String userMobileNo;
    private String userPassWord;

    public UserModel() {}

    public UserModel(String userId, String userName, String userMobileNo, String userPassWord) {
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

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userMobileNo='" + userMobileNo + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                '}';
    }
}
