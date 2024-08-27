package org.ordereasy.repository;

import org.ordereasy.models.Ordr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdrRepository extends JpaRepository<Ordr, Integer> {
}
