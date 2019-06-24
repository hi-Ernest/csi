package edu.team.entity;

import java.util.Date;

/**
 * 用户类 对应 user_inf表
 * @author dailiwen
 * @date 2019/06/24
 */
public class User {
    private String id;
    private String loginName;
    private String password;
    private Integer status;
    private Date createDate;
    private String userName;
    private String faceUrl;
    private String facePath;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getFacePath() {
        return facePath;
    }

    public void setFacePath(String facePath) {
        this.facePath = facePath;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", userName='" + userName + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", facePath='" + facePath + '\'' +
                '}';
    }
}
