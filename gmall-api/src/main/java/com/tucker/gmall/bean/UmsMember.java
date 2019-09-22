package com.tucker.gmall.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class UmsMember implements Serializable {

    private static final long serialVersionUID = 7152340199173975629L;
    @Id
    private String id;
    private String memberLevelId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int status;
    private Date createTime;
    private String icon;
    private int gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private int sourceType;
    private int integration;
    private int growth;
    private int luckeyCount;
    private int historyIntegration;

}
