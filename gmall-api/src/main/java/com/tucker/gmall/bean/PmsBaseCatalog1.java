package com.tucker.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class PmsBaseCatalog1 implements Serializable {
    private static final long serialVersionUID = -1735417747380935616L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @Transient
    private List<PmsBaseCatalog2> catalog2s;

}

