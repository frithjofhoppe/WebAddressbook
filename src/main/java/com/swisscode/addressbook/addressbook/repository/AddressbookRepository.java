package com.swisscode.addressbook.addressbook.repository;

import com.swisscode.addressbook.addressbook.entity.Address;
import com.swisscode.addressbook.addressbook.entity.Addressbook;
import com.swisscode.addressbook.addressbook.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressbookRepository extends CrudRepository<Addressbook, Long> {
    public Addressbook getAddressbookByIdentifierAndId(String identifier, Long id);
    public Addressbook findAddressbookByIdentifierAndUserAccount(String identifier, UserAccount userAccount);
}
