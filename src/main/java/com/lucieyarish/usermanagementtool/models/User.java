package com.lucieyarish.usermanagementtool.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private boolean active;

    @NotNull
    private String email;

    private String phone;

    @NotNull
    private LocalDateTime createdOn;

    public User(String name, String surname, boolean active, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.active = active;
        this.email = email;
        this.phone = phone;
        this.createdOn = LocalDateTime.now();
    }

}
