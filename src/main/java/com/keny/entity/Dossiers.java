package com.keny.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Dossiers {
    private String id;

    private String name;

    private Integer sex;

    private String address;

    private String phone;

    private String email;

    private Integer state;

    private Date createtime;

    private String remark;

}