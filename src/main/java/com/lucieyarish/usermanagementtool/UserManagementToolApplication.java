package com.lucieyarish.usermanagementtool;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class UserManagementToolApplication {

    private final UserRepository userRepository;

    private void addSampleData() {
        userRepository.save(new User("Darth", "Vader", true, "darthvader@starwars.com", "123456789"));
        userRepository.save(new User("Hermione", "Granger", true, "hermione@hogwarts.com", "234867039"));
        userRepository.save(new User("Lisbeth", "Salander", true, "lisbeth@hacker.com", "125364859"));
        userRepository.save(new User("Ronald", "Weasley", true, "ronweasley@hogwarts.com", "564738940"));
    }

    public void run(String... args) throws Exception {
        addSampleData();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserManagementToolApplication.class, args);
    }


}
