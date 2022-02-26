package com.lucieyarish.usermanagementtool.repositories;

import com.lucieyarish.usermanagementtool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, ' ', u.name, ' ', u.surname, ' ', u.email, ' ', u.createdOn, ' ', u.active) LIKE %?1%")
    List<User> search(String keyword);

}
