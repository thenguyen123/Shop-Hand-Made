package com.example.handmade.service;

import com.example.handmade.model.AppUser;
import com.example.handmade.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public AppUser findAccountByEmployeeEmail(String username) {
        return accountRepository.findAccountByEmployeeEmail(username);
    }
}
