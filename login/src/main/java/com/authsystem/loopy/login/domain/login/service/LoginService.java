package com.authsystem.loopy.login.domain.login.service;

import com.authsystem.loopy.domain.member.repository.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {

        String findEmailId(Map<String,String> parmaMap);
        String resetPassWord(String email);
        boolean loginCheck(String email, String password);
        void createLoginDataInRedis(String loginId);


}
