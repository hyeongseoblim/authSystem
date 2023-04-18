package com.authsystem.loopy.login.interfaces;

import com.authsystem.loopy.login.domain.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/authSystem/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody HttpRequest httpRequest,
                                @RequestParam("loginId") String loginId, @RequestParam("password") String password) {
        boolean existMember = loginService.loginCheck(loginId, password);
        if (existMember) {

        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/findPassword")
    public ResponseEntity findPassWord() {
        return new ResponseEntity(HttpStatus.OK);
    }

}
