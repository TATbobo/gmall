package com.tucker.gmall.manageweb.controller;

import com.tucker.gmall.bean.PmsBaseCatalog1;
import com.tucker.gmall.bean.PmsBaseCatalog2;
import com.tucker.gmall.bean.PmsBaseCatalog3;
import com.tucker.gmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Reference(version = "${manage.service.version}")
    CatalogService catalogService;

    @PostMapping("getCatalog1")
        public List<PmsBaseCatalog1>  getCatalog1(){
            return catalogService.getCatalog1();
        }

    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2>  getCatalog2(@RequestParam("catalog1Id") String catalog1Id){
        return catalogService.getCatalog2ByC1Id(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3>  getCatalog3(@RequestParam("catalog2Id") String catalog2Id){
        return catalogService.getCatalog3ByC2Id(catalog2Id);
    }

    }

