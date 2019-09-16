package com.tucker.gmall.manageservice.service.imp;


import com.tucker.gmall.bean.*;
import com.tucker.gmall.manageservice.mapper.*;
import com.tucker.gmall.service.SkuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

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

        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo skuInfo = skuInfoMapper.selectOne(pmsSkuInfo);

        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> pmsSkuImages = skuImageMapper.select(pmsSkuImage);

        skuInfo.setSkuImageList(pmsSkuImages);
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
