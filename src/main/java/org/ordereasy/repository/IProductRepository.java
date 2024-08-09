package org.ordereasy.repository;

import org.ordereasy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer>{
}
