package my.task.crudappjs.service;

import my.task.crudappjs.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(long role_id);

    List<Role> findAll();
}
