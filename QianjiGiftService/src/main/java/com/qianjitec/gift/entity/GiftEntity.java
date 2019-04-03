package com.qianjitec.gift.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GiftEntity {
    private String id;

    private String giftName;

    private Double credits;

    private String pictureCoverPath;

    private String currency;

    private Date createTime;

    private Date updateTime;
}