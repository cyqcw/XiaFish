package com.xiafish.pojo;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.SpringVersion;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer buyerId;
    private Integer sellerId;
    private Integer goodsId;
    private Integer orderNum;
    private float orderSumPrice;
    private String orderStatus;
    private LocalDate orderDateTime;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", goodsId=" + goodsId +
                ", orderNum=" + orderNum +
                ", orderSumPrice=" + orderSumPrice +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDateTime=" + orderDateTime +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public float getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(float orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDate orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}
