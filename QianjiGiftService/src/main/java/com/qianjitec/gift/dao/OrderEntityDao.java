package com.qianjitec.gift.dao;

import com.qianjitec.gift.entity.OrderEntity;

import java.util.List;

public interface OrderEntityDao {
    int generateOneOrder(OrderEntity order);

    OrderEntity userOrderInfo(String id);

    int deleteByPrimaryKey(String id);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);
}