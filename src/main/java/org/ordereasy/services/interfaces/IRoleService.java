package org.ordereasy.services.interfaces;
import org.ordereasy.models.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Page<Role> findAll(Pageable pageable);

    List<Role> getAll();

    Optional<Role> findOneById(Integer roleid);

    Role createOrEditOne(Role role);

    void deleteOneById(Integer roleid);
}
