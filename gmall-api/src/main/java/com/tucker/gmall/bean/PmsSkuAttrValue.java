package com.tucker.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class PmsSkuAttrValue implements Serializable {

    private static final long serialVersionUID = 5511675162308681098L;
    @Id
    @Column
    String id;

    @Column
    String attrId;

    @Column
    String valueId;

    @Column
    String skuId;

}
