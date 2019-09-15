package com.tucker.gmall.test.controller;

import com.tucker.gmall.bean.PmsSkuInfo;
import com.tucker.gmall.service.SkuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin
public class SkuController {

    @Reference(version = "${manage.service.version}")
    SkuService skuServiceImp;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo skuInfo){

        skuServiceImp.insertSkuInfo(skuInfo);

        return "success";
    }
}
