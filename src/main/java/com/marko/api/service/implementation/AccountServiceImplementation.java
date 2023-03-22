package com.marko.api.service.implementation;

import com.marko.api.model.Account;
import com.marko.api.model.Roles;
import com.marko.api.repository.AccountRepository;
import com.marko.api.repository.RolesRepository;
import com.marko.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class AccountServiceImplementation implements AccountService {
    private final AccountRepository accountRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder encoder;
    @Override
    public Account createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        Roles roles = rolesRepository.findByName("ROLE_USER");
        Set<Roles> _roles = new HashSet<>();
        _roles.add(roles);
        account.setRoles(_roles);
        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
