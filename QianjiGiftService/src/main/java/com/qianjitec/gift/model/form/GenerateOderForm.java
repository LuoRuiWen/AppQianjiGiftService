package com.qianjitec.gift.model.form;

import lombok.Data;

@Data
public class GenerateOderForm {
    private String giftId;

    private Integer type;

    private String addressId;

    private String currency;

    private String addresseeName;

    private String area;

    private String detailedAddress;

    private String mobile;

    private String email;
}
