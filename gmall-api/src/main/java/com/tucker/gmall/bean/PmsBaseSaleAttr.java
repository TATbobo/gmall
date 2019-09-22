package com.tucker.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @param
 * @return
 */
@Data
public class PmsBaseSaleAttr implements Serializable {

    private static final long serialVersionUID = 5102801687909493144L;
    @Id
    @Column
    String id;

    @Column
    String name;

}