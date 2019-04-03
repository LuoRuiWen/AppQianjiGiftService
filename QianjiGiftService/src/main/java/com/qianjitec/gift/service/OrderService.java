package com.qianjitec.gift.service;

import com.qianjitec.gift.entity.OrderEntity;
import com.qianjitec.gift.model.form.GenerateOderForm;

public interface OrderService {
    int generateOneOrder(GenerateOderForm form);

    OrderEntity userQueryOder(String id);
}
