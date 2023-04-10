package com.authsystem.loopy.domain.member.facade;

import com.authsystem.loopy.domain.member.repository.Member;

import java.util.Map;
import java.util.Optional;

public interface MemberFacade {
    boolean checkExistEmail(String email);

    Optional<Member> findMemberByEmail(String email);

    String getEmailIdByParams(Map<String,String> paramMap);

    void updateUserInfo(String email, Map<String,String> paramMap);

}
