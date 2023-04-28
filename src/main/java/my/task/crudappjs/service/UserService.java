package my.task.crudappjs.service;

import my.task.crudappjs.model.Role;
import org.springframework.security.core.userdetails.UserDetails;
import my.task.crudappjs.model.User;

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
