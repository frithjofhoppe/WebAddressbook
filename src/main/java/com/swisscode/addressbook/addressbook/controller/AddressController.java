package com.swisscode.addressbook.addressbook.controller;

import com.swisscode.addressbook.addressbook.entity.Address;
import com.swisscode.addressbook.addressbook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController
{
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/user/{id}/addressbook/{identifier}/address", method = RequestMethod.POST)
    public void createAddressInAddressbook(@RequestBody Address address, @PathVariable Long id, @PathVariable String identifier)
    {
        addressService.createAddressInBook(address, id, identifier);
    }

    @RequestMapping(value = "/user/{id}/addressbook/{identifier}/address", method = RequestMethod.PUT)
    public void changeAddress(@RequestBody Address address, @PathVariable Long id, @PathVariable String identifier)
    {
        addressService.changeAddress(address, id, identifier);
    }
}
