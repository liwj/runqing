package com.jynine.model;

public class DormitoryRoom {
    private Integer dbId;

    private String drNum;

    private String drDesc;

    private String drEmp;

    private Integer drStatus;

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getDrNum() {
        return drNum;
    }

    public void setDrNum(String drNum) {
        this.drNum = drNum == null ? null : drNum.trim();
    }

    public String getDrDesc() {
        return drDesc;
    }

    public void setDrDesc(String drDesc) {
        this.drDesc = drDesc == null ? null : drDesc.trim();
    }

    public String getDrEmp() {
        return drEmp;
    }

    public void setDrEmp(String drEmp) {
        this.drEmp = drEmp == null ? null : drEmp.trim();
    }

    public Integer getDrStatus() {
        return drStatus;
    }

    public void setDrStatus(Integer drStatus) {
        this.drStatus = drStatus;
    }
}