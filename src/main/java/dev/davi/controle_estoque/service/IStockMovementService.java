package dev.davi.controle_estoque.service;

import dev.davi.controle_estoque.model.StockMovementEntity;
import dev.davi.controle_estoque.model.enums.MovementType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IStockMovementService {

    StockMovementEntity registerMovement(UUID productId, StockMovementEntity movement);

    List<StockMovementEntity> findAll();

    StockMovementEntity findById(UUID id);

    List<StockMovementEntity> findMovementsByDate(LocalDateTime startDate, LocalDateTime endDate);

    List<StockMovementEntity> findMovementsByProduct(UUID productId);

    List<StockMovementEntity> findMovementsByType(MovementType type);
}
