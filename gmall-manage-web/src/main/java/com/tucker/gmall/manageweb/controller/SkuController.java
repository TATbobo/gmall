package com.tucker.gmall.manageweb.controller;

import com.tucker.gmall.bean.PmsSkuInfo;
import com.tucker.gmall.service.SkuServiceImp;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SkuController {

    @Reference(version = "${manage.service.version}")
    SkuServiceImp skuServiceImp;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo skuInfo){
        skuServiceImp.insertSkuInfo(skuInfo);

        return "success";
    }
}
