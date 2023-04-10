package com.authsystem.loopy.login.domain.login.service;

import java.util.Map;

public interface LoginService {

        String findEmailId(Map<String,String> parmaMap);
        String resetPassWord(String email);
        boolean loginCheck(String email, String password);


}
