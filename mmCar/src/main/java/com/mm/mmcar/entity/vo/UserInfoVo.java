package com.mm.mmcar.entity.vo;

/**
 * @author 茂茂
 * @create 2022-02-12 22:30
 */
public class UserInfoVo {
    private String voName;
    private Integer voTypeId;
    private Integer lowestPrice;
    private Integer highestPrice;
    private Integer page = 1;

    public UserInfoVo() {

    }

    public UserInfoVo(String voName, Integer voTypeId, Integer lowestPrice, Integer highestPrice, Integer page) {
        this.voName = voName;
        this.voTypeId = voTypeId;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.page = page;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "voName='" + voName + '\'' +
                ", voTypeId=" + voTypeId +
                ", lowestPrice=" + lowestPrice +
                ", highestPrice=" + highestPrice +
                ", page=" + page +
                '}';
    }

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }

    public Integer getVoTypeId() {
        return voTypeId;
    }

    public void setVoTypeId(Integer voTypeId) {
        this.voTypeId = voTypeId;
    }

    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Integer getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Integer highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
