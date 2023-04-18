package com.authsystem.loopy.login.domain.login.service;

import com.authsystem.loopy.domain.member.facade.MemberFacade;
import com.authsystem.loopy.domain.member.repository.Member;
import com.authsystem.loopy.login.domain.login.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final MemberFacade memberFacade;
    private final RedisService redisService;

    @Override
    public String findEmailId(Map<String, String> parmaMap) {
        return memberFacade.getEmailIdByParams(parmaMap);
    }

    @Override
    public String resetPassWord(String email) {
        Map<String, String> paramMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        paramMap.put("password", uuid);
        memberFacade.updateUserInfo(email, paramMap);
        return uuid;
    }

    @Override
    public boolean loginCheck(String email, String password) {
        Optional<Member> optionalMember = memberFacade.findMemberByEmail(email);
        if (optionalMember.isEmpty()) {
            return false;
        } else {
            return password.equals(optionalMember.get().getPassword());
        }
    }

    @Override
    public void createLoginDataInRedis(String loginId) {
        String uuid = UUID.randomUUID().toString();
        Optional<Member> optionalMember = memberFacade.findMemberByEmail(loginId);
        if(optionalMember.isPresent()){
            LoginDTO loginDTO = LoginDTO.builder()
                    .loginId(loginId)
                    .uniqueSessionKey(uuid)
                    .userName(optionalMember.get().getPhoneNumber())
                    .build();
            redisService.setKey(uuid,loginDTO);
        }

    }


}
