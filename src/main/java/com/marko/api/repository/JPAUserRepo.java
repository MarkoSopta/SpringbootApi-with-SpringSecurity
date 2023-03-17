package com.marko.api.repository;

import com.marko.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserRepo extends JpaRepository<User, Integer> {
    // More methods could be defined if needed
}
