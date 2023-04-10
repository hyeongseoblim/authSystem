package com.authsystem.loopy.domain.address.service;


import com.authsystem.loopy.domain.address.repository.Address;

public interface AddressService {

    Address findByString(String addressString);
}
