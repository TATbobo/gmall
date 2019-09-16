package com.tucker.gmall.item.controller;

import com.alibaba.fastjson.JSON;
import com.tucker.gmall.bean.*;
import com.tucker.gmall.service.SkuService;
import com.tucker.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class ItemController {

    @Reference(version = "${manage.service.version}")
    SkuService skuService;

    @Reference(version = "${manage.service.version}")
    SpuService spuService;

    @RequestMapping(value = "{skuId}.html")
    public String getItem(@PathVariable String skuId, ModelMap map){
        PmsSkuInfo pmsSkuInfo = skuService.selectSkuById(skuId);
        String spuId = pmsSkuInfo.getSpuId();

        Map<String,String> skuSaleAttrHash = new HashMap<>();
        List<PmsProductSaleAttr> saleAttrs = spuService.spuSaleAttrListCheckBySku(spuId,skuId);
        List<PmsSkuInfo> skuInfos = skuService.selectAttrValueBySpuId(spuId);

        for (PmsSkuInfo skuInfo : skuInfos) {
            String k = "";
            String v = skuInfo.getId();

            List<PmsSkuSaleAttrValue> skuSaleAttrValues = skuInfo.getSkuSaleAttrValueList();

            for (PmsSkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValues) {
                k += skuSaleAttrValue.getSaleAttrValueId() + "|";
            }
            skuSaleAttrHash.put(k,v);
        }

        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);

        map.put("skuInfo",pmsSkuInfo);
        map.put("spuSaleAttrListCheckBySku",saleAttrs);
        map.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);

        return "item";
    }
}
