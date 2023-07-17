package com.xiafish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private  Integer goodsId;
    private String goodsName;
    private float oriPrice;
    private float curPrice;
    private Integer goodsCategoryId;
    private Integer sellerId;
    private LocalDateTime releaseTime;
    private Integer inventory;
    String  goodsProfile;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(float oriPrice) {
        this.oriPrice = oriPrice;
    }

    public float getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(float curPrice) {
        this.curPrice = curPrice;
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getGoodsProfile() {
        return goodsProfile;
    }

    public void setGoodsProfile(String goodsProfile) {
        this.goodsProfile = goodsProfile;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", oriPrice=" + oriPrice +
                ", curPrice=" + curPrice +
                ", goodsCategoryId=" + goodsCategoryId +
                ", sellerId=" + sellerId +
                ", releaseTime=" + releaseTime +
                ", inventory=" + inventory +
                ", goodsProfile='" + goodsProfile + '\'' +
                '}';
    }
}
