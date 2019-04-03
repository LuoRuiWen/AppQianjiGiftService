package com.qianjitec.gift.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private String id;

    private String memId;

    private String giftId;

    private Integer num;

    private Integer type;

    private Integer status;

    private Date createTime;

    private Date receiveTime;

    private Date deliverTime;

    private Date updateTime;

    private Double actualPrice;

    private Double price;

    private Double credits;

    private Double actualCredits;

    private String currency;

    private Boolean isDeleted;

    private String addresseeName;

    private String area;

    private String detailedAddress;

    private String mobile;

    private String email;
}