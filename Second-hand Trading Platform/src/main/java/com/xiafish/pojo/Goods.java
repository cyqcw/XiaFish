package com.xiafish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private Float oriPrice;
    private Float curPrice;
    private Integer goodsCategoryId;
    private Integer sellerId;
    private LocalDateTime releaseTime;
    private Integer inventory;
    private String  goodsProfile;
    private Integer categoryId;
    private String categoryName;
}
