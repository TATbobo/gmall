package com.tucker.gmall.manageweb.controller;

import com.tucker.gmall.bean.PmsBaseSaleAttr;
import com.tucker.gmall.bean.PmsProductInfo;
import com.tucker.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {


    @Reference(version = "${manage.service.version}")
    SpuService spuService;

    @RequestMapping(value = "spuList")
    public List<PmsProductInfo> getSpuList(@RequestParam("catalog3Id") String catalog3Id){
        return spuService.selectSpuByC3Id(catalog3Id);
    }

    @RequestMapping(value = "baseSaleAttrList")
    public List<PmsBaseSaleAttr> getSaleAttrList(){
        return spuService.selectSaleAttrList();
    }

    @RequestMapping(value = "saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        spuService.insertSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping(value = "fileUpload")
    public String fileUpload(){

        return "success";
    }
}
