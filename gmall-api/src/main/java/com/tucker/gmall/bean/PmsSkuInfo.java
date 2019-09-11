package com.tucker.gmall.bean;


import com.tucker.gmall.bean.PmsSkuAttrValue;
import com.tucker.gmall.bean.PmsSkuImage;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class PmsSkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;

    @Column
    String spuId;

    @Column
    BigDecimal price;

    @Column
    String skuName;

    @Column
    BigDecimal weight;

    @Column
    String skuDesc;

    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;

    @Transient
    List<PmsSkuImage> SkuImageList;

    @Transient
    List<PmsSkuAttrValue> SkuAttrValueList;

    @Transient
    List<PmsSkuSaleAttrValue> SkuSaleAttrValueList;

}
