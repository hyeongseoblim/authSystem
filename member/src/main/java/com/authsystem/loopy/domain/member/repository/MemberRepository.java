package com.authsystem.loopy.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @QueryHints(value = @QueryHint(name = "org.hibernate.comment", value = "com.authsystem.loopy.member.repository.MemberRepository.findbyEmail"))
    Optional<Member> findMemberByEmail(String email);
    @QueryHints(value = @QueryHint(name = "org.hibernate.comment", value = "com.authsystem.loopy.member.repository.MemberRepository.findAllBySexAndAddress_Id"))
    List<Member> findAllBySexAndAddress_Id(String sex, Long address_id);
    @QueryHints(value = @QueryHint(name = "org.hibernate.comment", value = "com.authsystem.loopy.member.repository.MemberRepository.findByPhoneNumber"))
    Optional<Member> findByPhoneNumber(String phoneNumber);
}
