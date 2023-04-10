package com.authsystem.loopy.domain.address.facade;

import com.authsystem.loopy.domain.address.repository.Address;
import com.authsystem.loopy.domain.address.service.AddressService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressFacadeImpl implements AddressFacade{

    private final AddressService addressService;
    @Override
    public Address findByAddressAtString(String addressString) {
        return addressService.findByString(addressString);
    }
}
