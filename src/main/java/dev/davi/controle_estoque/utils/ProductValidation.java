package dev.davi.controle_estoque.utils;

import dev.davi.controle_estoque.exception.ProdutoMessagerException;
import dev.davi.controle_estoque.model.ProductEntity;

public class ProductValidation {

    public static void validation(ProductEntity produto) {
        if (produto == null) {
            throw new ProdutoMessagerException("Produto não pode ser nulo.");
        }

        if (produto.getName() == null || produto.getName().isBlank()) {
            throw new ProdutoMessagerException("O nome do produto é obrigatório.");
        }

        if (produto.getStock() == null || produto.getStock() < 0) {
            throw new ProdutoMessagerException("A quantidade não pode ser negativa.");
        }

        if (produto.getValidity() != null && produto.getValidity().isBefore(java.time.LocalDate.now())) {
            throw new ProdutoMessagerException("A data de validade não pode ser uma data passada.");
        }
    }
}
