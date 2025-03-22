package dev.davi.controle_estoque.controller;

import dev.davi.controle_estoque.model.ProductEntity;
import dev.davi.controle_estoque.service.IProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService service;

    @PostMapping
    public ProductEntity createProduct(ProductEntity entity){
        return service.saveProduct(entity);
    }

    @GetMapping
    public List<ProductEntity> findAll(){
        return service.findAll();
    }

    @GetMapping("/search/{id}")
    public Optional<ProductEntity> findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @GetMapping("name/{name}")
    public List<ProductEntity> findByName(@PathVariable String name){
        return service.findByName(name);
    }
}
