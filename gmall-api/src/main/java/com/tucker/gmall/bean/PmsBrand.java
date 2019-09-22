package com.tucker.gmall.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class PmsBrand implements Serializable {

    private static final long serialVersionUID = 8614052095701882949L;
    @Id
    private String id;
    private String name;
    private String firstLetter;
    private int sort;
    private int factoryStatus;
    private int showStatus;
    private int productCount;
    private String productCommentCount;
    private String logo;
    private String bigPic;
    private String brandStory;

}
