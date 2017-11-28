package com.swisscode.addressbook.addressbook.controller;

import com.swisscode.addressbook.addressbook.entity.Address;
import com.swisscode.addressbook.addressbook.entity.Addressbook;
import com.swisscode.addressbook.addressbook.service.AddressbookService;
import com.swisscode.addressbook.addressbook.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressbookController {

    @Autowired
    AddressbookService addressbookService;

    @Autowired
    UserAccountService userAccountService;

    @RequestMapping(value = "/user/{id}/addressbook/{identifier}", method = RequestMethod.GET)
    public List<Address> getAddressbookByIdentifier(@PathVariable Long id, @PathVariable String identifier)
    {
        return addressbookService.getAddressByAddressbook(identifier,id);
    }

    @RequestMapping(value = "/user/{id}/addressbook", method = RequestMethod.POST)
    public void createAddressBookByUser(@PathVariable Long id, @RequestBody Addressbook addressbook)
    {
        addressbookService.createAddressbookByUser(id, addressbook);
    }
}
