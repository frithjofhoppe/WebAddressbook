package com.swisscode.addressbook.addressbook.repository;

import com.swisscode.addressbook.addressbook.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    public UserAccount getUserAccountByEmailAddress(String emailAddress);
}
