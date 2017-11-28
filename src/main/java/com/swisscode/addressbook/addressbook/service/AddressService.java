package com.swisscode.addressbook.addressbook.service;

import com.swisscode.addressbook.addressbook.entity.Address;
import com.swisscode.addressbook.addressbook.entity.Addressbook;
import com.swisscode.addressbook.addressbook.entity.UserAccount;
import com.swisscode.addressbook.addressbook.repository.AddressRepository;
import com.swisscode.addressbook.addressbook.repository.AddressbookRepository;
import com.swisscode.addressbook.addressbook.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressbookRepository addressbookRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    public void createAddressInBook(Address address, Long id, String identifier)
    {
        if(address != null) {
            UserAccount user = userAccountRepository.findOne(id);
            if (user != null) {
                Addressbook ad = addressbookRepository.findAddressbookByIdentifierAndUserAccount(identifier, user);
                if(ad != null)
                {
                    address.setAddressbook(ad);
                    addressRepository.save(address);
                }
            }
        }
    }

    public void changeAddress(Address address, Long id, String identifier)
    {
        if(address.getId() != null)
        {
            Address ad = addressRepository.getAddressByIdAndAddressbook_Id(address.getId(), id);
            if(ad != null){
                address.setAddressbook(ad.getAddressbook());
                addressRepository.save(address);
            }
        }
    }
}
