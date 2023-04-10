package com.authsystem.loopy.domain.member.service;

import com.authsystem.loopy.domain.member.dto.MemberDTO;
import com.authsystem.loopy.domain.member.repository.Member;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberService {

    boolean checkExistEmail(String email);

    String findEmailIdByPhoneNumber(String phoneNumber);

    Optional<Member> findByEmail(String email);
    List<Member> getSexAndAddressSortedList(String sex, String address);
    void createMember(MemberDTO memberDTO);
    void updateUserInfo(String email, Map<String,String> changeInfoMap);
}
