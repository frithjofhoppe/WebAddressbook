package com.swisscode.addressbook.addressbook.service;

import com.swisscode.addressbook.addressbook.entity.Address;
import com.swisscode.addressbook.addressbook.entity.Addressbook;
import com.swisscode.addressbook.addressbook.entity.UserAccount;
import com.swisscode.addressbook.addressbook.repository.AddressRepository;
import com.swisscode.addressbook.addressbook.repository.AddressbookRepository;
import com.swisscode.addressbook.addressbook.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressbookService {

    @Autowired
    AddressbookRepository addressbookRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    AddressRepository addressRepository;

    public Addressbook getAddressbookByIdentifier(Long id, String identifier) {
        return addressbookRepository.getAddressbookByIdentifierAndId(identifier, id);
    }

    public void createAddressbookByUser(Long id, Addressbook addressbook) {
        UserAccount uar = userAccountRepository.findOne(id);

        if(uar != null) {
            addressbook.setUserAccount(uar);
            addressbookRepository.save(addressbook);
        }
    }

    public List<Address> getAddressByAddressbook(String identifier, Long id) {
        Addressbook ad = addressbookRepository.getAddressbookByIdentifierAndId(identifier, id);
        if(ad != null) {
            return addressRepository.getAddressesByAddressbook_Id(ad.getId());
        }
        return null;
    }
}
