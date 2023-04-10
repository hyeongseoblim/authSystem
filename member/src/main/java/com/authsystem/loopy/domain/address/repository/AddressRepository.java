package com.authsystem.loopy.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @QueryHints(value = {@QueryHint(name = "org.hibernate.readOnly", value = "AddressRepository.findByCityContains")})
    Optional<Address> findByCityContains(String addressString);
    @QueryHints(value = {@QueryHint(name = "org.hibernate.readOnly", value = "AddressRepository.findByZipCodeContains")})
    Optional<Address> findByZipCodeContains(String addressString);
    @QueryHints(value = {@QueryHint(name = "org.hibernate.readOnly", value = "AddressRepository.findByCountry")})
    Optional<Address> findByCountry(String addressString);

}
