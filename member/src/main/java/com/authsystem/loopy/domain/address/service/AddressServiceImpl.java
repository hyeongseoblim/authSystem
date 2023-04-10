package com.authsystem.loopy.domain.address.service;

import com.authsystem.loopy.domain.address.repository.Address;
import com.authsystem.loopy.domain.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address findByString(String addressString) {
        Optional<Address> address = addressRepository.findByCountry(addressString);
        address = address.isPresent() ? address : addressRepository.findByZipCodeContains(addressString);
        address = address.isPresent() ? address : addressRepository.findByCityContains(addressString);
        return address.orElseGet(Address::new);
    }
}
