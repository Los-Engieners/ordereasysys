package org.ordereasy.services.interfaces;


import org.ordereasy.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    List<Product> getAll();

    Optional<Product> findOneById(Integer id);

    Product createOrEditOne(Product product);

    void deleteOneById(Integer id);
}
