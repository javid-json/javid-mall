package pers.javid.mall.entity;

import java.util.Date;

public class UserLog {

    private Integer userId;

    private String userName;

    private String operation;

    private String data;

    private Date createTime;

    private Date updateTime;

    public UserLog(){

    }

    public UserLog(String userName,String operation,String data){
        this.userName = userName;
        this.operation = operation;
        this.data = data;
    }

    @Override
    public String toString(){
        return "UserLog{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", operation='" + operation + '\'' +
                ", data='" + data + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
