package com.tucker.gmall.manageservice.service.imp;

import com.tucker.gmall.bean.PmsBaseCatalog1;
import com.tucker.gmall.bean.PmsBaseCatalog2;
import com.tucker.gmall.bean.PmsBaseCatalog3;
import com.tucker.gmall.manageservice.mapper.Catalog1Mapper;
import com.tucker.gmall.manageservice.mapper.Catalog2Mapper;
import com.tucker.gmall.manageservice.mapper.Catalog3Mapper;
import com.tucker.gmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "${manage.service.version}")
public class CatalogServiceImp implements CatalogService {

    @Autowired
    Catalog1Mapper catalog1Mapper;

    @Autowired
    Catalog2Mapper catalog2Mapper;

    @Autowired
    Catalog3Mapper catalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2ByC1Id(String catalog1Id) {

        PmsBaseCatalog2 catalog2 = new PmsBaseCatalog2();
        catalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = catalog2Mapper.select(catalog2);

        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3ByC2Id(String catalog2Id) {
        PmsBaseCatalog3 catalog3 = new PmsBaseCatalog3();
        catalog3.setCatalog2_id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = catalog3Mapper.select(catalog3);

        return pmsBaseCatalog3s;
    }


}
