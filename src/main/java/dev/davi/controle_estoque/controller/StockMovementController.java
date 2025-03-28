package dev.davi.controle_estoque.controller;

import dev.davi.controle_estoque.model.StockMovementEntity;
import dev.davi.controle_estoque.model.enums.MovementType;
import dev.davi.controle_estoque.service.IStockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController("/estoque")
@RequiredArgsConstructor
public class StockMovementController {

    private final IStockMovementService service;

    @PostMapping("/in")
    public ResponseEntity<StockMovementEntity> registerStockEntry(@RequestParam UUID productId, @RequestBody StockMovementEntity movement){
        StockMovementEntity created = service.registerMovement(productId, movement);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/out")
    public ResponseEntity<StockMovementEntity> registerStockExit(@RequestParam UUID productId, @RequestBody StockMovementEntity movement) {
        StockMovementEntity created = service.registerMovement(productId, movement);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/")
    public List <StockMovementEntity> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StockMovementEntity findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @GetMapping("/entre-datas")
    public List<StockMovementEntity> findByMovementDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return service.findMovementsByDate(startDate, endDate);
    }

    @GetMapping("/por-produto/{productId}")
    public List<StockMovementEntity> findByProductId(@PathVariable UUID productId) {
        return service.findMovementsByProduct(productId);
    }

    @GetMapping("/por-tipo/{type}")
    public List<StockMovementEntity> findByType(@PathVariable MovementType type) {
        return service.findMovementsByType(type);
    }
}
