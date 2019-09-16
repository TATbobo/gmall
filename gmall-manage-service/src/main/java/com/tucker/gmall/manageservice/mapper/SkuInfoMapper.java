package com.tucker.gmall.manageservice.mapper;


import com.tucker.gmall.bean.PmsSkuInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SkuInfoMapper extends Mapper<PmsSkuInfo> {
    List<PmsSkuInfo> selectAttrValueBySpuId(@Param("spuId") String spuId);
}
