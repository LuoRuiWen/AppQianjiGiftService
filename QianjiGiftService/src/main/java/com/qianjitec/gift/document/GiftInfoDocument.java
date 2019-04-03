package com.qianjitec.gift.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="GiftInfoDocument")
@Data
public class GiftInfoDocument {
    @Id
    private String id;

    private String giftId;

    private String[] picturePath;

    private String describe;

    private String content;

    private Date createTime;

    private Date updateTime;
}
