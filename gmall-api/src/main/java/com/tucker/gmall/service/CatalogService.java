package com.tucker.gmall.service;

import com.tucker.gmall.bean.PmsBaseCatalog1;
import com.tucker.gmall.bean.PmsBaseCatalog2;
import com.tucker.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2ByC1Id(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3ByC2Id(String catalog2Id);
}
