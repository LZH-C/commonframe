package com.lzh.commonframe.common.domain;

public class SearchDTO {

    private int id;

    private byte status;

    private int associateId;

    private String associateString;

    private int begin;

    private int end;

    public SearchDTO(){};

    public SearchDTO(int id,byte status){
        this.id=id;
        this.status=status;
    };

    public SearchDTO(int id,int associateId){
        this.id=id;
        this.associateId=associateId;
    };

    public SearchDTO(int id,String associateString){
        this.id=id;
        this.associateString=associateString;
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getAssociateId() {
        return associateId;
    }

    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

    public String getAssociateString() {
        return associateString;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setAssociateString(String associateString) {
        this.associateString = associateString;
    }
}
