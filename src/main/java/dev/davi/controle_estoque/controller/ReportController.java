package dev.davi.controle_estoque.controller;

import dev.davi.controle_estoque.model.ProductEntity;
import dev.davi.controle_estoque.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/relatorios")
public class ReportController {

    private final IProductService productService;

    @GetMapping("/baixo-estoque")
    public List<ProductEntity> listProductsWithLowStock(@RequestParam(defaultValue = "10") int limite) {
        return productService.findProductsLowStock(limite);
    }

    @GetMapping("/produtos-vencimento")
    public List<ProductEntity> listProductsCloseToExpiration(@RequestParam(defaultValue = "30") int dias) {
        return productService.findProductsNearExpiration(dias);
    }
}
