package org.ordereasy.services.implementations;

import org.ordereasy.models.Role;
import org.ordereasy.repository.IRoleRepository;
import org.ordereasy.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository rolerepository;

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return rolerepository.findAll(pageable);
    }

    @Override
    public List<Role> getAll() {
         return rolerepository.findAll();
    }

    @Override
    public Optional<Role> findOneById(Integer roleId) {
        return rolerepository.findById(roleId);
    }

    @Override
    public Role createOrEditOne(Role role) {
        return rolerepository.save(role);
    }

    @Override
    public void deleteOneById(Integer roleId) {
        rolerepository.deleteById(roleId);
    }
}
