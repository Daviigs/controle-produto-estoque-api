package dev.davi.controle_estoque.repository;

import dev.davi.controle_estoque.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findByName(String name);

    ProductEntity findByNameAndValidity(String name, LocalDate validity);

    List<ProductEntity> findByStockLessThan(int limite);

    List<ProductEntity> findByValidityBefore(LocalDate dataLimite);
}
