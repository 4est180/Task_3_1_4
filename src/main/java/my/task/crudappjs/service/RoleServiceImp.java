package my.task.crudappjs.service;

import my.task.crudappjs.model.Role;
import my.task.crudappjs.repository.RoleRepository;
import org.springframework.stereotype.Service;

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
