package com.qianjitec.gift.model.form;

import com.alibaba.fastjson.annotation.JSONField;
import com.qianjitec.common.security.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryOrderForm {
    private String id;

    private UserInfo memId;

    private GiftForOrderForm giftId;

    private Integer num;

    private Integer type;

    private Integer status;

    private AddressForOrderForm address;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receiveTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deliverTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Double price;

    private Double actualPrice;

    private Double credits;

    private Double actualCredits;

    private String currency;
}
