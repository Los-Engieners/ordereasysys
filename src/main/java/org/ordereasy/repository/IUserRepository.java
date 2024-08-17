package org.ordereasy.repository;

import org.ordereasy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer>  {
}
