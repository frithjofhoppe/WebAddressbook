package com.swisscode.addressbook.addressbook.service;

import com.swisscode.addressbook.addressbook.entity.Address;
import com.swisscode.addressbook.addressbook.entity.Addressbook;
import com.swisscode.addressbook.addressbook.entity.UserAccount;
import com.swisscode.addressbook.addressbook.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountService
{
    @Autowired
    UserAccountRepository userAccountRepository;

    public void createUser(UserAccount userAccount) {
        UserAccount ua = new UserAccount();
        userAccount.setEmailAddress(userAccount.getEmailAddress());
        userAccountRepository.save(userAccount);
    }

    public void changeUser(UserAccount userAccount) throws CloneNotSupportedException {
        UserAccount ua = userAccountRepository.getUserAccountByEmailAddress(userAccount.getEmailAddress());

        if(ua != null ) {
            UserAccount u = new UserAccount(ua.getId(), userAccount.getFirstName(), userAccount.getLastName(), userAccount.getPhoneNumber(), userAccount.getEmailAddress(), userAccount.getPassword());
            userAccountRepository.save(u);
        }
    }

    public UserAccount getAuthorizedUserAccount(String email, String pw) {

        UserAccount ua = userAccountRepository.getUserAccountByEmailAddress(email);

        if(ua != null)
        {
            if(ua.getPassword().equals(pw))
            {
                return ua;
            }
        }

        return null;
    }

}
