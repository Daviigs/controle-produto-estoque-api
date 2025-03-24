package dev.davi.controle_estoque.service.impl;

import dev.davi.controle_estoque.model.ProductEntity;
import dev.davi.controle_estoque.model.StockMovementEntity;
import dev.davi.controle_estoque.model.enums.MovementType;
import dev.davi.controle_estoque.repository.ProductRepository;
import dev.davi.controle_estoque.repository.StockMovementRepository;
import dev.davi.controle_estoque.service.IProductService;
import dev.davi.controle_estoque.service.IStockMovementService;
import dev.davi.controle_estoque.utils.ProductValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final IStockMovementService movementService;

    public ProductEntity saveProduct(ProductEntity entity){
        ProductValidation.validation(entity);
        entity.setName(entity.getName().toLowerCase());
        entity.setCategory(entity.getCategory().toLowerCase());

        ProductEntity existing = productRepository.findByNameValidity(entity.getName(), entity.getValidity());

        if(existing != null){
            StockMovementEntity stockMovement = new StockMovementEntity();
            stockMovement.setProduct(existing);
            stockMovement.setType(MovementType.IN);
            stockMovement.setQuantity(entity.getStock());  // Quantidade que está sendo inserida
            stockMovement.setMovementDate(LocalDateTime.now());

            // Registra a movimentação de entrada
            movementService.registerMovement(existing.getId(), stockMovement);
        }

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
