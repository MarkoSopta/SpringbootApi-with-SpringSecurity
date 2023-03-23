package com.marko.api.init;

import com.marko.api.model.Roles;
import com.marko.api.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;


@RequiredArgsConstructor
@Component
public class AppStartup implements CommandLineRunner {
    private final RolesRepository rolesRepository;
    @Override
    public void run(String... args) throws Exception {
        Roles roleUser = new Roles(1L,"1","ROLE_USER");
        Roles roleAdmin = new Roles(2L,"2","ROLE_ADMIN");
        rolesRepository.saveAll(asList(roleUser,roleAdmin));
    }
}
