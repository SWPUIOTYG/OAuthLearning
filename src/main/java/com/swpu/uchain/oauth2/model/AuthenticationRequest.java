package com.swpu.uchain.oauth2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
    //认证request的信息
    private String username;

    private String password;
}
