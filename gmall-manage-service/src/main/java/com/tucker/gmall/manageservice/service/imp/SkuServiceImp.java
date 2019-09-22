package com.tucker.gmall.manageservice.service.imp;


import com.tucker.gmall.bean.*;
import com.tucker.gmall.manageservice.mapper.*;
import com.tucker.gmall.manageservice.utils.RedisCache;
import com.tucker.gmall.service.RedisService;
import com.tucker.gmall.service.SkuService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@Service(version = "${manage.service.version}")
public class SkuServiceImp implements SkuService {

    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Autowired
    SkuImageMapper skuImageMapper;

    @Reference(version = "${manage.service.version}")
    RedisService redisService;

    @Override
    public void insertSkuInfo(PmsSkuInfo skuInfo) {

        skuInfoMapper.insertSelective(skuInfo);
        PmsSkuInfo skuInfo1 = skuInfoMapper.selectOne(skuInfo);
        String skuId = skuInfo1.getId();

        List<PmsSkuAttrValue> skuAttrValues = skuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue skuAttrValue : skuAttrValues) {
            skuAttrValue.setSkuId(skuId);
            skuAttrValueMapper.insertSelective(skuAttrValue);
        }

        List<PmsSkuImage> skuImages = skuInfo.getSkuImageList();
        for (PmsSkuImage skuImage : skuImages) {
            skuImage.setSkuId(skuId);
            skuImageMapper.insertSelective(skuImage);
        }

        List<PmsSkuSaleAttrValue>  skuSaleAttrValues = skuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValues) {
            skuSaleAttrValue.setSkuId(skuId);
            skuSaleAttrValueMapper.insertSelective(skuSaleAttrValue);
        }
    }

    @Override
    public PmsSkuInfo selectSkuById(String skuId) {

        String key  = "skuId:" + skuId+":info";

        if(!StringUtils.isEmpty(key)&&!StringUtils.isEmpty(redisService.get(key))){
            return (PmsSkuInfo) redisService.get(key);
        }

        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo skuInfo = skuInfoMapper.selectOne(pmsSkuInfo);

        if(!StringUtils.isEmpty(skuInfo)) {
            PmsSkuImage pmsSkuImage = new PmsSkuImage();
            pmsSkuImage.setSkuId(skuId);
            List<PmsSkuImage> pmsSkuImages = skuImageMapper.select(pmsSkuImage);

            skuInfo.setSkuImageList(pmsSkuImages);

            redisService.set(key, skuInfo);
        }
        else{
            redisService.set(key,null,60*3);
        }
        return skuInfo;
    }

    @Override
    public List<PmsSkuImage> selectImageBySkuId(String skuId) {

        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        return  skuImageMapper.select(pmsSkuImage);
    }

    @Override
    public List<PmsSkuSaleAttrValue> selectAttrValueBySkuId(String skuId) {

        PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();
        pmsSkuSaleAttrValue.setSkuId(skuId);

        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues = skuSaleAttrValueMapper.select(pmsSkuSaleAttrValue);

        return pmsSkuSaleAttrValues;
    }

    @Override
    public List<PmsSkuInfo> selectAttrValueBySpuId(String spuId) {
        return skuInfoMapper.selectAttrValueBySpuId(spuId);
    }
}
