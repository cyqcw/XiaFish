package com.xiafish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsImg {
    private Integer goodsImgId;
    private Integer goodsId;
    private String goodsImgUrl;

    @Override
    public String toString() {
        return "GoodsImg{" +
                "goodsImgId=" + goodsImgId +
                ", goodsId=" + goodsId +
                ", goodsImgUrl='" + goodsImgUrl + '\'' +
                '}';
    }

    public Integer getGoodsImgId() {
        return goodsImgId;
    }

    public void setGoodsImgId(Integer goodsImgId) {
        this.goodsImgId = goodsImgId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }
}
