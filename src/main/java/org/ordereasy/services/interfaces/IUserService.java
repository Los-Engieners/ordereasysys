package org.ordereasy.services.interfaces;
import org.ordereasy.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAll();

    Optional<User> findOneById(Integer userid);

    User createOrEditOne(User user);

    void deleteOneById(Integer userid);

    Page<User> findAll(Pageable pageable);
}
