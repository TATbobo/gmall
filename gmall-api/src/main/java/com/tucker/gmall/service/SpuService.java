package com.tucker.gmall.service;

import com.tucker.gmall.bean.PmsBaseSaleAttr;
import com.tucker.gmall.bean.PmsProductImage;
import com.tucker.gmall.bean.PmsProductInfo;
import com.tucker.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> selectSpuByC3Id(String catalog);

    List<PmsBaseSaleAttr> selectSaleAttrList();

    void insertSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> selectSaleAttrById(String spuId);

    List<PmsProductImage> selectSpuImage(String spuId);
}
