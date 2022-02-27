package com.lucieyarish.usermanagementtool.services;

import com.lucieyarish.usermanagementtool.models.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    User changeUserStatus(Long id);

    void removeUser(Long id);

    List<User> listAllContainingKeyword(String keyword);

//    Page<User> findPaginated(Pageable pageable);

}
