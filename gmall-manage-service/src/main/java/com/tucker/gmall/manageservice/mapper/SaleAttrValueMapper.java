package com.tucker.gmall.manageservice.mapper;

import com.tucker.gmall.bean.PmsProductSaleAttr;
import com.tucker.gmall.bean.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SaleAttrValueMapper extends Mapper<PmsProductSaleAttrValue> {
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(@Param("spuId") String spuId,@Param("skuId") String skuId);
}
