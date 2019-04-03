package com.qianjitec.gift.service;

import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.gift.document.GiftInfoDocument;
import com.qianjitec.gift.entity.GiftEntity;
import com.qianjitec.gift.model.form.FrontGiftListForm;

public interface GiftService {
    ResultPage frontGiftList(FrontGiftListForm form);

    GiftInfoDocument frontGiftInfo(String id);

    GiftEntity getOneGiftInfo(String id);
}
