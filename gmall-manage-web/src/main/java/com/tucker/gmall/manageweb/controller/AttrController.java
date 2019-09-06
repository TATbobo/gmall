package com.tucker.gmall.manageweb.controller;

import com.tucker.gmall.bean.PmsBaseAttrInfo;
import com.tucker.gmall.bean.PmsBaseAttrValue;
import com.tucker.gmall.service.AttrInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AttrController {


    @Reference(version = "${manage.service.version}")
    AttrInfoService attrInfoService;

    @RequestMapping(value = "attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfo(@RequestParam("catalog3Id" ) String catalog3Id){
        return attrInfoService.getAttrInfoByC3Id(catalog3Id);
    }

    @RequestMapping(value = "saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        attrInfoService.insertAttrInfo(pmsBaseAttrInfo);

        return "success";
    }

    @RequestMapping(value = "getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValue(@RequestParam("attrId") String attrId){

        return attrInfoService.getAttrValueById(attrId);
    }
}
