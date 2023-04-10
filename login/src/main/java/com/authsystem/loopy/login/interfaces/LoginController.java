package com.authsystem.loopy.login.interfaces;

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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody HttpRequest httpRequest){
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
