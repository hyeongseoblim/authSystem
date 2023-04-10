package com.authsystem.loopy.domain.member.repository;

import com.authsystem.loopy.domain.CommonEntity;
import com.authsystem.loopy.domain.address.repository.Address;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends CommonEntity {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String sex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ADDRESS_ID")
    private Address address;
    @NotNull
    private String phoneNumber;

    private LocalDateTime expiredPassWordDate;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Builder
    public Member(Long id, String email, String password, String sex, Address address, String phoneNumber, MemberType memberType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.memberType = memberType;
    }
}
