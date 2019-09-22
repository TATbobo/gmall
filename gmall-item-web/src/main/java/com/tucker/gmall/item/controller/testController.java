package com.tucker.gmall.item.controller;

import com.tucker.gmall.bean.PmsSkuInfo;
import com.tucker.gmall.service.RedisService;
import com.tucker.gmall.service.SkuService;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Reference(version = "${manage.service.version}")
    SkuService skuService;

    @RequestMapping("/{skuId}")
    public PmsSkuInfo test(@PathVariable("skuId") String skuId){
        return skuService.selectSkuById(skuId);
    }
}
