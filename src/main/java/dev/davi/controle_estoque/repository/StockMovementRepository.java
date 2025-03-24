package dev.davi.controle_estoque.repository;

import dev.davi.controle_estoque.model.StockMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovementEntity, UUID> {
}
