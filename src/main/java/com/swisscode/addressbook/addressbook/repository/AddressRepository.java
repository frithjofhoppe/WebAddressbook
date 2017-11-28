package com.swisscode.addressbook.addressbook.repository;

import com.swisscode.addressbook.addressbook.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    public List<Address> getAddressesByAddressbook_Id(Long id);
    public Address getAddressByIdAndAddressbook_Id(Long addressId, Long addressbookId);
}
