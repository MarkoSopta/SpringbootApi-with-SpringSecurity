package com.marko.api.repository;

import com.marko.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account,Long>{

    Account findByUsername (String username);
}
