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
}
