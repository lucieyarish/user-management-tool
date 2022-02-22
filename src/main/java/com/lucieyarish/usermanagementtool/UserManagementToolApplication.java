package com.lucieyarish.usermanagementtool;

import com.lucieyarish.usermanagementtool.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementToolApplication {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        addSampleData();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserManagementToolApplication.class, args);
    }


}
