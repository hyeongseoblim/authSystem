package com.authsystem.loopy.domain.address.repository;

import com.authsystem.loopy.domain.member.repository.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long id;

    private String city;

    private String zipCode;

    private String country;

    @OneToMany(mappedBy = "MEMBER_ID")
    List<Member> members;

    @Builder
    public Address(Long id, String city, String zipCode, String country){
        this.id = id;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}
