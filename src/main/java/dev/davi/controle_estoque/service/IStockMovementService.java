package dev.davi.controle_estoque.service;

import dev.davi.controle_estoque.model.StockMovementEntity;

import java.util.List;
import java.util.UUID;

public interface IStockMovementService {

    StockMovementEntity registerMovement(UUID productId, StockMovementEntity movement);

    List<StockMovementEntity> findAll();

    StockMovementEntity findById(UUID id);
}
