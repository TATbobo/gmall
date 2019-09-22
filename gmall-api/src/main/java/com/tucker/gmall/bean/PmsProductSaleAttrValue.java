package com.tucker.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
public class PmsProductSaleAttrValue implements Serializable {
    private static final long serialVersionUID = -2821521822051327358L;
    @Id
    @Column
    String id;

    @Column
    String productId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrValueName;

    @Transient
    String isChecked;


}
