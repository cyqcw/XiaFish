package com.xiafish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsComment {
    private Integer goodsCommentId;
    private Integer goodsId;
    private Integer buyerId;
    private String goodsCommentContent;

    @Override
    public String toString() {
        return "GoodsComment{" +
                "goodsCommentId=" + goodsCommentId +
                ", goodsId=" + goodsId +
                ", buyerId=" + buyerId +
                ", goodsCommentContent='" + goodsCommentContent + '\'' +
                '}';
    }

    public Integer getGoodsCommentId() {
        return goodsCommentId;
    }

    public void setGoodsCommentId(Integer goodsCommentId) {
        this.goodsCommentId = goodsCommentId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getGoodsCommentContent() {
        return goodsCommentContent;
    }

    public void setGoodsCommentContent(String goodsCommentContent) {
        this.goodsCommentContent = goodsCommentContent;
    }
}
