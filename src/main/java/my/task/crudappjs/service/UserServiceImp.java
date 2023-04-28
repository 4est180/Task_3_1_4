package my.task.crudappjs.service;

import my.task.crudappjs.model.Role;
import my.task.crudappjs.model.User;
import my.task.crudappjs.repository.RoleRepository;
import my.task.crudappjs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImp implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (user.getPassword().startsWith("$2a$10$") && user.getPassword().length() == 60) {
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.merge(user);
    }

    @Override
    @Transactional(readOnly=true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteById(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly=true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user" + " " + username);
        }
        return user;
    }
}
