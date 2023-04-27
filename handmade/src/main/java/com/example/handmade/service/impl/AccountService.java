package com.example.handmade.service.impl;

import com.example.handmade.model.AppUser;
import com.example.handmade.repository.IAccountRepository;
import com.example.handmade.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public AppUser findAccountByEmployeeEmail(String username) {
        return accountRepository.findAccountByEmployeeEmail(username);
    }
}
