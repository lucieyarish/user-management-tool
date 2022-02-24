package com.lucieyarish.usermanagementtool.services;

import com.lucieyarish.usermanagementtool.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    User changeUserStatus(Long id);
}
