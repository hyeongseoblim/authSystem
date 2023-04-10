package com.authsystem.loopy.login.domain.login.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String userId;
    private String userPassword;
    private Long loginAttemptCount;
}
