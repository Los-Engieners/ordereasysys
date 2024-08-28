package org.ordereasy.services.interfaces;

import org.ordereasy.models.OrdrDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrdrDetailService {
    Page<OrdrDetail> findAll(Pageable pageable);

    List<OrdrDetail> getAll();

    Optional<OrdrDetail> findOneById(Integer id);

    OrdrDetail createOrEditOne(OrdrDetail ordrdetail);

    void deleteOneById(Integer id);
}
