package com.authsystem.loopy.domain.member.service;

import com.authsystem.loopy.domain.address.facade.AddressFacade;
import com.authsystem.loopy.domain.address.repository.Address;
import com.authsystem.loopy.domain.member.dto.MemberDTO;
import com.authsystem.loopy.domain.member.repository.Member;
import com.authsystem.loopy.domain.member.repository.MemberRepository;
import com.authsystem.loopy.domain.member.repository.MemberType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final AddressFacade addressFacade;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean checkExistEmail(String email) {
        Optional<Member> existMember = memberRepository.findMemberByEmail(email);
        return existMember.isPresent();
    }

    @Override
    public String findEmailIdByPhoneNumber(String phoneNumber) {
        Optional<Member> optionalMember= memberRepository.findByPhoneNumber(phoneNumber);
        if(optionalMember.isEmpty()){
            return null;
        }else{
            return optionalMember.get().getEmail();
        }
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findMemberByEmail(email);
    }

    @Override
    public List<Member> getSexAndAddressSortedList(String sex, String inputAddress) {
        Address address = addressFacade.findByAddressAtString(inputAddress);
        List<Member> result = memberRepository.findAllBySexAndAddress_Id(sex, address.getId());
        return result;
    }

    @Override
    public void createMember(MemberDTO memberDTO) {
        Address address = addressFacade.findByAddressAtString(memberDTO.getAddress());
        Member newMember = Member.builder()
                .email(memberDTO.getEmail())
                .password(memberDTO.getPassword())
                .sex(memberDTO.getSex())
                .address(address)
                .phoneNumber(memberDTO.getPhoneNumber())
                .memberType(MemberType.COMMON)
                .build();
        entityManager.persist(newMember);
        entityManager.flush();
        log.info("----- CREATE MEMBER ----- EMAIL" + newMember.getEmail());
    }

    @Override
    public void updateUserInfo(String email, Map<String, String> changeInfoMap) {
        Member member = memberRepository.findMemberByEmail(email).orElseThrow();

        Set<String> keySets = changeInfoMap.keySet();

        String password = member.getPassword();
        Address address = member.getAddress();
        String phoneNumber = member.getPhoneNumber();
        MemberType memberType = member.getMemberType();

        for (String key : keySets) {
            switch (key){
                case "password":
                    password = changeInfoMap.get(key);
                    break;
                case "phoneNumber":
                    phoneNumber= changeInfoMap.get(key);
                    break;
                case "memberType":
                    memberType=MemberType.valueOf(changeInfoMap.get(key));
                    break;
                case "address":
                    address = addressFacade.findByAddressAtString(changeInfoMap.get(key));
                    break;
            }
        }

        Member updateMember = Member.builder().memberType(memberType)
                .id(member.getId())
                .address(address)
                .email(member.getEmail())
                .password(password)
                .phoneNumber(phoneNumber).build();

        memberRepository.save(updateMember);
    }
}
