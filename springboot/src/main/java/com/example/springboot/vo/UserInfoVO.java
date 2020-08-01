package com.example.springboot.vo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Description: VO类，封装请求参数
 * Author: zhongds
 * Date : 2020/7/31 0:03
 */

public class UserInfoVO {

    @NotNull
    private Integer id;

    @NotBlank(message = "用户名称不能为空")
    private String name;

    @Pattern(regexp = "^[0-9]{6,10}$", message = "密码格式检验失败,必须6位到10位的数字")
    private String password;

    @NotNull
    private String region;

    @NotNull
    private String gender;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", region='" + region + '\'' +
                ", gender='" + gender + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
