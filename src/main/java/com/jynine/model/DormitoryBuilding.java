package com.jynine.model;

import java.util.Date;

public class DormitoryBuilding {
    private Integer dbId;

    private String dbName;

    private String dbDesc;

    private Integer dbNum;

    private Integer dbRoomNum;

    private Date dbTime;

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName == null ? null : dbName.trim();
    }

    public String getDbDesc() {
        return dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc == null ? null : dbDesc.trim();
    }

    public Integer getDbNum() {
        return dbNum;
    }

    public void setDbNum(Integer dbNum) {
        this.dbNum = dbNum;
    }

    public Integer getDbRoomNum() {
        return dbRoomNum;
    }

    public void setDbRoomNum(Integer dbRoomNum) {
        this.dbRoomNum = dbRoomNum;
    }

    public Date getDbTime() {
        return dbTime;
    }

    public void setDbTime(Date dbTime) {
        this.dbTime = dbTime;
    }
}