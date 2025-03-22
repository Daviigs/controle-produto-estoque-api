package dev.davi.controle_estoque.service.impl;

import dev.davi.controle_estoque.model.ProductEntity;
import dev.davi.controle_estoque.repository.ProductRepository;
import dev.davi.controle_estoque.service.IProductService;
import dev.davi.controle_estoque.utils.ProductValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity entity){
        ProductValidation.validation(entity);
        entity.setName(entity.getName().toLowerCase());
        entity.setCategory(entity.getCategory().toLowerCase());

        return productRepository.save(entity);
    }

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(UUID id){
        return productRepository.findById(id);
    }

    public List<ProductEntity> findByName(String name){
        return productRepository.findByName(name);
    }
}
