package com.tucker.gmall.manageservice.service.imp;

import com.tucker.gmall.bean.*;
import com.tucker.gmall.manageservice.mapper.*;
import com.tucker.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "${manage.service.version}")
public class SpuServiceImp implements SpuService {

    @Autowired
    SpuMapper spuMapper;

    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    SaleAttrMapper saleAttrMapper;

    @Autowired
    SaleAttrValueMapper saleAttrValueMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    SpuImageMapper spuImageMapper;


    @Override
    public List<PmsProductInfo> selectSpuByC3Id(String catalog3Id) {

        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);

        return spuMapper.select(pmsProductInfo);
    }

    @Override
    public List<PmsBaseSaleAttr> selectSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    @Override
    public void insertSpuInfo(PmsProductInfo pmsProductInfo) {
        spuMapper.insertSelective(pmsProductInfo);
        String productId = spuMapper.selectOne(pmsProductInfo).getId();

        List<PmsProductImage> pmsProductImages = pmsProductInfo.getSpuImageList();
        if (!pmsProductImages.isEmpty()){
        for (PmsProductImage pmsProductImage:pmsProductImages){

            pmsProductImage.setProductId(productId);
            imageMapper.insertSelective(pmsProductImage);
        }
        }

        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductInfo.getSpuSaleAttrList();
        if (!pmsProductSaleAttrs.isEmpty()){
        for (PmsProductSaleAttr pmsProductSaleAttr:pmsProductSaleAttrs){

            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues =  pmsProductSaleAttr.getSpuSaleAttrValueList();
            if(!pmsProductSaleAttrValues.isEmpty()){
                for (PmsProductSaleAttrValue pmsProductSaleAttrValue:pmsProductSaleAttrValues){
                    pmsProductSaleAttrValue.setProductId(productId);
                    saleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
                }
            }

            pmsProductSaleAttr.setProductId(productId);
            saleAttrMapper.insertSelective(pmsProductSaleAttr);
        }
        }
    }

    @Override
    public List<PmsProductSaleAttr> selectSaleAttrById(String spuId) {

        PmsProductSaleAttr saleAttr = new PmsProductSaleAttr();
        saleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> saleAttrs = saleAttrMapper.select(saleAttr);
        for (PmsProductSaleAttr saleAttr1 : saleAttrs) {
            PmsProductSaleAttrValue saleAttrValue = new PmsProductSaleAttrValue();
            saleAttrValue.setProductId(spuId);
            saleAttrValue.setSaleAttrId(saleAttr1.getSaleAttrId());
            List<PmsProductSaleAttrValue> saleAttrValues1 = saleAttrValueMapper.select(saleAttrValue);

            saleAttr1.setSpuSaleAttrValueList(saleAttrValues1);
        }
        return saleAttrs;
    }

    @Override
    public List<PmsProductImage> selectSpuImage(String spuId) {

        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);

        List<PmsProductImage> spuImages = spuImageMapper.select(pmsProductImage);
        return spuImages;
    }

}
