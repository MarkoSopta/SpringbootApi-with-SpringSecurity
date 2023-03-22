package com.marko.api.service.implementation;

import com.marko.api.model.Account;
import com.marko.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {
    private final AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if(account==null){
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        if (account.getRoles()==null || account.getRoles().isEmpty()) {
            throw new RuntimeException("User has no roles");
        }
        Collection<GrantedAuthority> authorities = account
                .getRoles()
                .stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getName()))
                .collect(Collectors.toList());

        return new User(account.getUsername()
                ,account.getPassword()
                ,account.isEnabled()
                ,!account.isExpired()
                ,!account.isCredentialsExpired()
                ,!account.isLocked()
                ,authorities );
    }
}
