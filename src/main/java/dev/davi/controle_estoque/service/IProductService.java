package dev.davi.controle_estoque.service;

import dev.davi.controle_estoque.model.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductService{

    ProductEntity saveProduct(final ProductEntity entity);

    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(UUID id);

    List<ProductEntity> findByName(String name);

    List<ProductEntity> findProductsLowStock(int limite);

    List<ProductEntity> findProductsNearExpiration(int dias);
}
