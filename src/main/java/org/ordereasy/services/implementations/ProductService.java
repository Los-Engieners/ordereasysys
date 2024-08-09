package org.ordereasy.services.implementations;


import org.ordereasy.models.Product;
import org.ordereasy.services.interfaces.IProductService;
import org.ordereasy.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Service

public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findOneById(Integer productid) {
        return productRepository.findById(productid);
    }

    @Override
    public Product createOrEditOne(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteOneById(Integer productid) {
        productRepository.deleteById(productid);
    }
}
