package dev.davi.controle_estoque.service.impl;

import dev.davi.controle_estoque.model.ProductEntity;
import dev.davi.controle_estoque.model.StockMovementEntity;
import dev.davi.controle_estoque.model.enums.MovementType;
import dev.davi.controle_estoque.repository.ProductRepository;
import dev.davi.controle_estoque.repository.StockMovementRepository;
import dev.davi.controle_estoque.service.IStockMovementService;
import dev.davi.controle_estoque.utils.MovementValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StockMovementService implements IStockMovementService {

    private final StockMovementRepository movementRepository;
    private final ProductRepository productRepository;

    @Transactional
    public StockMovementEntity registerMovement(UUID productId, StockMovementEntity movement) {
        ProductEntity product = productRepository.findById(productId).
                orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (movement.getType() == MovementType.OUT){
            MovementValidation.validation(product, movement.getQuantity());
            product.setStock(product.getStock() - movement.getQuantity());
        }else product.setStock(product.getStock() + movement.getQuantity());

        productRepository.save(product);
        movement.setProduct(product);
        return movementRepository.save(movement);
    }

    public List<StockMovementEntity> findAll(){
        return movementRepository.findAll();
    }

    public StockMovementEntity findById(UUID id){
        return movementRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
    }
}
