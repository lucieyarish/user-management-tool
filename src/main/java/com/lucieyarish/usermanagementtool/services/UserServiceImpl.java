package com.lucieyarish.usermanagementtool.services;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void saveUser(User user){

        try {
            userRepository.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {

        try {
            List<User> users = new ArrayList<>();
            userRepository
                    .findAll(Sort.by(Sort.Direction.ASC, "id"))
                    .forEach(user -> users.add(user));
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserById(Long id) {

        try {
             return userRepository.findUserById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User changeUserStatus(Long id) {
        try {
            User currentUser = getUserById(id);

            if (currentUser.isActive()){
                currentUser.setActive(false);
            }
            else {
                currentUser.setActive(true);
            }

            userRepository.save(currentUser);
            return currentUser;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void removeUser(Long id) {

        try {
            User currentUser = userRepository.findUserById(id);
            userRepository.delete(currentUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method for filtering
    @Override
    public List<User> listAllContainingKeyword(String keyword) {

        try {
            if (keyword != null) {
                return userRepository.search(keyword);
            }

            return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Page<User> findPage(int pageNumber) {

        try {
            Pageable pageable = PageRequest.of(pageNumber - 1, 5);
            Page<User> listOfUsers = userRepository.findAll(pageable);

            return listOfUsers;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // method for filtering by date
    @Override
    public List<User> searchByDate(LocalDate startDate, LocalDate endDate) {

        try {
            List<User> users = userRepository.getAllBetweenDates(startDate, endDate);

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
