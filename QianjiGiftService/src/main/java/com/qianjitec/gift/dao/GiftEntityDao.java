package com.qianjitec.gift.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.gift.entity.GiftEntity;

import java.util.List;

public interface GiftEntityDao {
    int deleteByPrimaryKey(String id);

    int insert(GiftEntity record);

    int insertSelective(GiftEntity record);

    GiftEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GiftEntity record);

    int updateByPrimaryKey(GiftEntity record);

    List<GiftEntity> frontGiftList(Page page);

    GiftEntity getOneEntityInfo(String id);
}