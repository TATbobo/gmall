package com.tucker.gmall.service;

import com.tucker.gmall.bean.PmsBaseAttrInfo;
import com.tucker.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrInfoService {
    List<PmsBaseAttrInfo> getAttrInfoByC3Id(String catalog3);

    void insertAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueById(String attrId);
}
