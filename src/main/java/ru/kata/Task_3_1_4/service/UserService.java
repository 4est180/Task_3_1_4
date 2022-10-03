package ru.kata.Task_3_1_4.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.Task_3_1_4.model.User;
import ru.kata.Task_3_1_4.model.Role;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    List<User> findAll();

    User getUserById(Long id);

    void deleteById(User user);

    User findByUsername(String username);

    List<Role> listRoles();

    UserDetails loadUserByUsername(String username);

}
