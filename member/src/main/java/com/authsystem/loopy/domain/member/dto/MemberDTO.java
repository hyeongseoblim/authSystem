package com.authsystem.loopy.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String email;
    private String password;
    private String sex;
    private String address;
    private String phoneNumber;
}
