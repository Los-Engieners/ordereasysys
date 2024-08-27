package org.ordereasy.services.interfaces;

import org.ordereasy.models.Ordr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrdrService {
    Page<Ordr> findAll(Pageable pageable);

    List<Ordr> getAll();

    Optional<Ordr> findOneById(Integer id);

    Ordr createOrEditOne(Ordr ordr);

    void deleteOneById(Integer id);
}
