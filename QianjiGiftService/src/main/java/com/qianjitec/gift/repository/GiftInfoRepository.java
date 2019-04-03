package com.qianjitec.gift.repository;

import com.qianjitec.gift.document.GiftInfoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GiftInfoRepository extends MongoRepository<GiftInfoDocument,String> {

    @Query(value="{\"giftId\":?0}")
    GiftInfoDocument frontGiftInfo(String id);

    //@Query(value="qianji.GiftInfoDocument.insert({tile:\"nb\",name:\"xuekun xue\"})")
   /* @Query("insert into GiftInfoDocument(tile,name) g values("")")
    int addOne();*/
}
