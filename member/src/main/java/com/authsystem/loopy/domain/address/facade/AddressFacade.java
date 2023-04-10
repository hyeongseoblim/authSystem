package com.authsystem.loopy.domain.address.facade;

import com.authsystem.loopy.domain.address.repository.Address;

public interface AddressFacade {

    Address findByAddressAtString(String addressString);
}
