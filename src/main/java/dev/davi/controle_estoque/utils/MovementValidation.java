package dev.davi.controle_estoque.utils;

import dev.davi.controle_estoque.model.ProductEntity;

public class MovementValidation {
    public static void validation(ProductEntity produto, Integer quantidade) {
        if (produto.getStock() < quantidade) {
            throw new RuntimeException("Estoque insuficiente para a saída");
        }
    }
}
