package dev.davi.controle_estoque.controller;

import dev.davi.controle_estoque.model.StockMovementEntity;
import dev.davi.controle_estoque.service.IStockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
