package com.lucieyarish.usermanagementtool.services;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        userRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).forEach(user -> users.add(user));
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User changeUserStatus(Long id) {

        User currentUser = getUserById(id);

        if(currentUser.isActive()){
            currentUser.setActive(false);
        }
        else{
            currentUser.setActive(true);
        }

        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public void removeUser(Long id){
        User currentUser = userRepository.findUserById(id);
        userRepository.delete(currentUser);
    }

    // method for filtering
    @Override
    public List<User> listAll(String keyword){
        if (keyword != null) {
            return userRepository.search(keyword);
        }
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
