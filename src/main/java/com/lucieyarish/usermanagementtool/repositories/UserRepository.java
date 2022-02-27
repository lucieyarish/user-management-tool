package com.lucieyarish.usermanagementtool.repositories;

import com.lucieyarish.usermanagementtool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, ' ', u.name, ' ', u.surname, ' ', u.email, ' ', u.createdOn, ' ', u.active, ' ') " +
            "LIKE %?1%")
    List<User> search(String keyword);

    @Query("SELECT u FROM User u WHERE u.createdOn >= :startDate AND u.createdOn <= :endDate")
    List<User> getAllBetweenDates(LocalDate startDate, LocalDate endDate);

}
