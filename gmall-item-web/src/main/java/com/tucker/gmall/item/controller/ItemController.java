package com.tucker.gmall.item.controller;

import com.tucker.gmall.bean.*;
import com.tucker.gmall.service.SkuService;
import com.tucker.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

        List<PmsProductSaleAttr> saleAttrs = spuService.selectSaleAttrById(pmsSkuInfo.getSpuId());

        map.put("skuInfo",pmsSkuInfo);
        map.put("spuSaleAttrListCheckBySku",saleAttrs);

        return "item";
    }
}
