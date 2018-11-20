package com.example.shane.model;

/**
 * Created by Shane on 06-Apr-18.
 */

public class Data {

    private String expDate;
    private String expType;
    private int expCatId;
    private String expDesc;
    private int expAmt;
    private int usrId;


    public Data(String expDate, String expType, int expCatId, String expDesc, int expAmt, int usrId) {
        this.expDate = expDate;
        this.expType = expType;
        this.expCatId = expCatId;
        this.expDesc = expDesc;
        this.expAmt = expAmt;
        this.usrId = usrId;
    }


    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public int getExpCatId() {
        return expCatId;
    }

    public void setExpCatId(int expCatId) {
        this.expCatId = expCatId;
    }

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }

    public int getExpAmt() {
        return expAmt;
    }

    public void setExpAmt(int expAmt) {
        this.expAmt = expAmt;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }
}
