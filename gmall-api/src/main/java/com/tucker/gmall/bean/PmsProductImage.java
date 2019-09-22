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
public class PmsProductImage implements Serializable {

    private static final long serialVersionUID = -6156085977125685574L;
    @Column
    @Id
    private String id;
    @Column
    private String productId;
    @Column
    private String imgName;
    @Column
    private String imgUrl;

}