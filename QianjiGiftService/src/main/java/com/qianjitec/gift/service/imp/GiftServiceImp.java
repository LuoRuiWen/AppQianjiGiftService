package com.qianjitec.gift.service.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.discovery.converters.Auto;
import com.qianjitec.common.exception.ServiceException;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.gift.dao.GiftEntityDao;
import com.qianjitec.gift.document.GiftInfoDocument;
import com.qianjitec.gift.entity.GiftEntity;
import com.qianjitec.gift.model.form.FrontGiftListForm;
import com.qianjitec.gift.repository.GiftInfoRepository;
import com.qianjitec.gift.service.GiftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServiceImp implements GiftService {
    Logger logger = LoggerFactory.getLogger(GiftServiceImp.class);

    @Autowired
    GiftEntityDao giftDao;

    @Autowired
    GiftInfoRepository giftInfoRepository;

    @Override
    public ResultPage frontGiftList(FrontGiftListForm form) {
        logger.info("查询礼品清单");
        try {
            ResultPage rp = new ResultPage();
            Page page = form.page();
            List<GiftEntity> gifts = giftDao.frontGiftList(page);
            rp.setTotal(page.getTotal());
            rp.setList(gifts);
            return rp;
        }catch (ServiceException e){
            logger.info("查询礼品清单失败",e);
            throw e;
        }catch (Exception e){
            logger.info("查询礼品清单失败",e);
            throw new ServiceException("查询礼品清单失败", ErrorCode.SERVICE_ERROR,e);
        }
    }

    /**
     * 从nosql中取出礼品详情
     * @param id
     * @return
     */
    @Override
    public GiftInfoDocument frontGiftInfo(String id) {
        logger.info("查询礼品详情");
        try {
            GiftInfoDocument giftInfo = giftInfoRepository.frontGiftInfo(id);
            return giftInfo;
        }catch (ServiceException e){
            logger.info("查询礼品详情失败",e);
            throw e;
        }catch (Exception e){
            logger.info("查询礼品详情失败",e);
            throw new ServiceException("查询礼品详情失败", ErrorCode.SERVICE_ERROR,e);
        }
    }

    @Override
    public GiftEntity getOneGiftInfo(String id) {
        logger.info("获取礼品信息");
        try {
            GiftEntity gift = giftDao.getOneEntityInfo(id);
            System.out.println(id);
            System.out.println(gift.getGiftName());
            return gift;
        }catch (ServiceException e){
            logger.info("获取礼品信息失败",e);
            throw e;
        }catch (Exception e){
            logger.info("获取礼品信息失败",e);
            throw new ServiceException("获取礼品信息失败", ErrorCode.SERVICE_ERROR,e);
        }
    }
}
