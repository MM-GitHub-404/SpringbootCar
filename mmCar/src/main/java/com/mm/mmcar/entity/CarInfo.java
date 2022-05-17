package com.mm.mmcar.entity;

import java.util.Date;

public class CarInfo {
    private Integer cId;

    private String cName;

    private String cContent;

    private Integer cPrice;

    private String cImage;

    private Integer cNumber;

    private Integer typeId;

    private Date cDate;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent == null ? null : cContent.trim();
    }

    public Integer getcPrice() {
        return cPrice;
    }

    public void setcPrice(Integer cPrice) {
        this.cPrice = cPrice;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage == null ? null : cImage.trim();
    }

    public Integer getcNumber() {
        return cNumber;
    }

    public void setcNumber(Integer cNumber) {
        this.cNumber = cNumber;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cContent='" + cContent + '\'' +
                ", cPrice=" + cPrice +
                ", cImage='" + cImage + '\'' +
                ", cNumber=" + cNumber +
                ", typeId=" + typeId +
                ", cDate=" + cDate +
                '}';
    }
}