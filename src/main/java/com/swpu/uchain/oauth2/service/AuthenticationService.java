package com.swpu.uchain.oauth2.service;

import com.swpu.uchain.oauth2.model.AuthenticationRequest;
import com.swpu.uchain.oauth2.model.UserDto;

public interface AuthenticationService {
    /**
     * 用户验证
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
