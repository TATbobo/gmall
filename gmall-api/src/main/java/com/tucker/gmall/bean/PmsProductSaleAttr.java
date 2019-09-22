package com.tucker.gmall.bean;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
public class PmsProductSaleAttr implements Serializable {

    private static final long serialVersionUID = -9103096029504018935L;
    @Id
    @Column
    String id;

    @Column
    String productId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrName;

    @Transient
    List<PmsProductSaleAttrValue> spuSaleAttrValueList;

}
