package dev.davi.controle_estoque.repository;

import dev.davi.controle_estoque.model.StockMovementEntity;
import dev.davi.controle_estoque.model.enums.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovementEntity, UUID> {

    List<StockMovementEntity> findByMovementDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<StockMovementEntity> findByProductId(UUID productId);

    List<StockMovementEntity> findByType(MovementType type);

}
