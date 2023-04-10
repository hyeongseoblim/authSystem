package com.authsystem.loopy.domain.member.facade;

import com.authsystem.loopy.domain.member.repository.Member;
import com.authsystem.loopy.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFacadeImpl implements MemberFacade{

    private final MemberService memberService;

    public boolean checkExistEmail(String email) {
        return memberService.checkExistEmail(email);
    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return memberService.findByEmail(email);
    }

    @Override
    public String getEmailIdByParams(Map<String, String> paramMap) {
        Optional<String> key = paramMap.keySet().stream().findFirst();
        if(key.isEmpty()){
            return null;
        }else{
            switch (key.get()) {
                case "phoneNumber":
                    return memberService.findEmailIdByPhoneNumber(paramMap.get(key.get()));
                case "externalAuthSystem":
                    return "";
            }
        }
        return null;
    }

    @Override
    public void updateUserInfo(String email, Map<String, String> paramMap) {
        memberService.updateUserInfo(email,paramMap);
    }


}
