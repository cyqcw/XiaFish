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
}
