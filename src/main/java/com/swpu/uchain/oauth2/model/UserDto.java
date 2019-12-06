package com.swpu.uchain.oauth2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    //用户身份信息
    private String id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;

    private Set<String> authorities; //存储用户权限

}
