package com.swisscode.addressbook.addressbook.controller;

import com.swisscode.addressbook.addressbook.entity.Information;
import com.swisscode.addressbook.addressbook.entity.UserAccount;
import com.swisscode.addressbook.addressbook.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAccountController
{
    @Autowired
    UserAccountService userAccountService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody UserAccount userAccount)
    {
        userAccountService.createUser(userAccount);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void changeUser(@RequestBody UserAccount userAccount)
    {
        try {
            userAccountService.changeUser(userAccount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserAccount logIn(@RequestBody Information info)
    {
        String email;
        String pw;

        email = info.getData().get(0)[1];
        pw = info.getData().get(1)[1];

       return userAccountService.getAuthorizedUserAccount(email, pw);
    }
}
