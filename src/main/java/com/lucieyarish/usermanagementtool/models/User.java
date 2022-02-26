package com.lucieyarish.usermanagementtool.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDate createdOn;

    public User(String name, String surname, boolean active, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.active = active;
        this.email = email;
        this.phone = phone;
        this.createdOn = LocalDate.now();
    }

}
