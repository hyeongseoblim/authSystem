package com.authsystem.loopy.login.domain.login.service;

import com.authsystem.loopy.domain.member.facade.MemberFacade;
import com.authsystem.loopy.domain.member.repository.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginValidationServiceImpl implements LoginValidationService {

    private final MemberFacade memberFacade;


    @Override
    public boolean expiredPasswordCheck(String email) {
        Optional<Member> optionalMember = memberFacade.findMemberByEmail(email);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            LocalDate currentDate = LocalDate.now();
            if (member.getExpiredPassWordDate().isBefore(ChronoLocalDateTime.from(currentDate.minus(60, ChronoUnit.DAYS)))) {
                return true;
            }
        }
        return false;
    }
}
