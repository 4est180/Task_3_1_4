package my.task.SpringHTMLJS.service;

import my.task.SpringHTMLJS.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(long role_id);

    List<Role> findAll();
}
