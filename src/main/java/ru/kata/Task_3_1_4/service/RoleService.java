package ru.kata.Task_3_1_4.service;

import ru.kata.Task_3_1_4.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(long role_id);

    List<Role> findAll();
}
