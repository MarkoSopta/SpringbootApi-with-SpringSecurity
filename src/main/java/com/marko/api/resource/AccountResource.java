package com.marko.api.resource;

import com.marko.api.model.Account;
import com.marko.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.marko.api.resource.UserResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {
    private AccountService accountService;


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }
    @GetMapping
    public ResponseEntity<List<Account>>getAccount(){
        return ResponseEntity.ok(accountService.getAccounts());
    }
}
