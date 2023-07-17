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
}
