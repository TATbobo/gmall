package com.tucker.gmall.service;

import com.tucker.gmall.bean.PmsSkuImage;
import com.tucker.gmall.bean.PmsSkuInfo;
import com.tucker.gmall.bean.PmsSkuSaleAttrValue;

import java.util.List;

public interface SkuService {
    void insertSkuInfo(PmsSkuInfo skuInfo);

    PmsSkuInfo selectSkuById(String skuId);

    List<PmsSkuImage> selectImageBySkuId(String id);

    List<PmsSkuSaleAttrValue> selectAttrValueBySkuId(String skuId);

    List<PmsSkuInfo> selectAttrValueBySpuId(String spuId);
}
