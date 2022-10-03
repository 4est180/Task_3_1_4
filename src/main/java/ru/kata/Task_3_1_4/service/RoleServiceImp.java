package ru.kata.Task_3_1_4.service;

import org.springframework.stereotype.Service;
import ru.kata.Task_3_1_4.model.Role;
import ru.kata.Task_3_1_4.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(long role_id) {
        return roleRepository.findById(role_id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
