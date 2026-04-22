package com.sarni.springmvc.pojo;

import lombok.Data;

@Data
public class Address {
    //username=231&password=123&cellphone=123123
    // &address.province=天津&address.city=天津&address.area=滨海新区
    //&sex=男&hobby=篮球&hobby=乒乓球&grade=四年级&agreement=on
    private String province;
    private String city;
    private String area;
}
