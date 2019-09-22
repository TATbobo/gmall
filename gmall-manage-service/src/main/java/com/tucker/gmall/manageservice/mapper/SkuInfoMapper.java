package com.tucker.gmall.manageservice.mapper;


import com.tucker.gmall.bean.PmsSkuInfo;
import com.tucker.gmall.manageservice.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/*@CacheNamespace(implementation = RedisCache.class)*/
public interface SkuInfoMapper extends Mapper<PmsSkuInfo> {
    List<PmsSkuInfo> selectAttrValueBySpuId(@Param("spuId") String spuId);
}
