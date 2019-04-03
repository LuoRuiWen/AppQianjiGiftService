package com.qianjitec.gift.controller;

import com.qianjitec.common.utils.ResultData;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.gift.document.GiftInfoDocument;
import com.qianjitec.gift.model.form.FrontGiftListForm;
import com.qianjitec.gift.service.GiftService;
import com.qianjitec.gift.utils.ControllerRepeateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gift")
public class FrontGiftController {
    Logger logger = LoggerFactory.getLogger(FrontGiftController.class);

    @Autowired
    GiftService giftService;

    @GetMapping("/frontGiftList")
    public ResultData frontGiftList(FrontGiftListForm form){
        logger.info("查询礼品列表");
        String msg = "礼品列表";
        ResultPage rp = giftService.frontGiftList(form);
        return ControllerRepeateUtil.getResultData(msg,rp);
    }

    @GetMapping("/frontGiftInfo/{id}")
    public ResultData frontGiftInfo(@PathVariable String id){
        logger.info("查询礼品详情");
        String msg = "礼品详情";
        GiftInfoDocument giftInfoDocument = giftService.frontGiftInfo(id);
        return ControllerRepeateUtil.getResultData(msg,giftInfoDocument);
    }
}
