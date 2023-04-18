package com.authsystem.loopy.login.domain.login.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
    private String userName;
    private String loginId;
    private String uniqueSessionKey;

    @Builder
    public LoginDTO(String userName, String loginId, String uniqueSessionKey){
        this.uniqueSessionKey = uniqueSessionKey;
        this.userName = userName;
        this.loginId = loginId;
    }
}
