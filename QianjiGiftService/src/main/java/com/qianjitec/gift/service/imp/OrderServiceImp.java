package com.qianjitec.gift.service.imp;

import com.qianjitec.common.exception.ServiceException;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.security.UserInfo;
import com.qianjitec.common.security.UserInfoService;
import com.qianjitec.common.utils.IdUtils;
import com.qianjitec.credits.service.CreditOperatIface;
import com.qianjitec.gift.dao.OrderEntityDao;
import com.qianjitec.gift.entity.GiftEntity;
import com.qianjitec.gift.entity.OrderEntity;
import com.qianjitec.gift.model.form.GenerateOderForm;
import com.qianjitec.gift.service.GiftService;
import com.qianjitec.gift.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrderServiceImp implements OrderService{
    Logger logger = LoggerFactory.getLogger(OrderServiceImp.class);

    @Autowired
    private OrderEntityDao orderEntityDao;

    @Autowired
    private GiftService giftService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired(required = false)
    private CreditOperatIface creditOperatIface;

    /**
     *
     * 生成一条新订单
     * @param form
     * @return
     */
    @Override
    public int generateOneOrder(GenerateOderForm form) {
        logger.info("生成一条新订单");
        try {
            OrderEntity order = new OrderEntity();
            System.out.println(form.getGiftId());
            BeanUtils.copyProperties(form,order);
            GiftEntity gift = giftService.getOneGiftInfo(order.getGiftId());
            if(gift == null){
                throw new ServiceException("找不到礼品");
            }
            UserInfo user = userInfoService.getUserInfo();
            String id  = IdUtils.nextId();
            String memId = user.getId();
            Date createTime = new Date();
            Double credits = gift.getCredits();
            Double actualCredits = credits;
            Integer num = new Integer(1);
            Integer status = new Integer(1);

            order.setId(id);
            order.setMemId(memId);
            order.setCreateTime(createTime);
            order.setCredits(credits);
            order.setActualCredits(actualCredits);
            order.setNum(num);
            order.setStatus(status);

            //调用扣除积分接口
            creditOperatIface.subPoints("cost_for_gift",memId,actualCredits);

            //插入订单记录
            int result = orderEntityDao.generateOneOrder(order);
            return result;
        }catch (ServiceException e){
            logger.info("生成新订单失败",e);
            throw e;
        }catch (Exception e){
            logger.info("生成新订单失败",e);
            throw new ServiceException("生成新订单失败", ErrorCode.SERVICE_ERROR,e);
        }
    }

    /**
     * 会员获取订单详情
     * @param id
     * @return
     */
    @Override
    public OrderEntity userQueryOder(String id) {
        logger.info("获取订单详情");
        try{
            OrderEntity order = orderEntityDao.userOrderInfo(id);
            return order;
        }catch (ServiceException e){
            logger.info("获取订单详情失败",e);
            throw e;
        }catch (Exception e){
            logger.info("获取订单详情失败",e);
            throw new ServiceException("获取订单详情失败", ErrorCode.SERVICE_ERROR,e);
        }
    }
}
