package com.example.handmade.security_authentication.service;

import com.example.handmade.model.AppUser;
import com.example.handmade.repository.IAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountDetailService implements UserDetailsService {

    @Autowired
  private IAccountRepository iAccountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        AppUser account = iAccountRepository.findAccountByEmployeeEmail(username);
        if(account==null){
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return AccountDetails.build(account);
    }
}
