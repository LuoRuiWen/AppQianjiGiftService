package com.qianjitec.gift.controller;

import com.qianjitec.common.utils.ResultData;
import com.qianjitec.gift.entity.OrderEntity;
import com.qianjitec.gift.model.form.GenerateOderForm;
import com.qianjitec.gift.service.OrderService;
import com.qianjitec.gift.utils.ControllerRepeateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gift")
public class FrontOrderController {
    Logger logger = LoggerFactory.getLogger(FrontOrderController.class);

    @Autowired
    OrderService orderService;

    @PostMapping("/generateOneOrder")
    public ResultData generateOneOrder(@RequestBody GenerateOderForm form){
        logger.info("生成订单");
        String msg = "生成订单";
        int result = orderService.generateOneOrder(form);
        return ControllerRepeateUtil.getResultData(msg,result);
    }

    @GetMapping("/userQueryOder/{id}")
    public ResultData userQueryOder(@PathVariable String id){
        logger.info("会员获取订单详情");
        String msg = "会员获取订单详情";
        OrderEntity order = orderService.userQueryOder(id);
        return ControllerRepeateUtil.getResultData(msg,order);
    }
}
