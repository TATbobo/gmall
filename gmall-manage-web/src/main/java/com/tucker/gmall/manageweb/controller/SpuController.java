package com.tucker.gmall.manageweb.controller;

import com.tucker.gmall.bean.PmsBaseSaleAttr;
import com.tucker.gmall.bean.PmsProductImage;
import com.tucker.gmall.bean.PmsProductInfo;
import com.tucker.gmall.bean.PmsProductSaleAttr;
import com.tucker.gmall.manageweb.util.PmsUploadUtil;
import com.tucker.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> getSupSaleAttrList(@RequestParam("spuId")String spuId){
        return spuService.selectSaleAttrById(spuId);
    }

    @RequestMapping("spuImageList")
    public List<PmsProductImage> getSpuImage(@RequestParam("spuId")String spuId){
        return spuService.selectSpuImage(spuId);
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
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){

        String imageUrl = PmsUploadUtil.fileUpload(multipartFile);

        return imageUrl;
    }
}
