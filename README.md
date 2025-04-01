# 📦 API de Controle de Produtos e Estoque

Este é um projeto de API REST desenvolvida em **Java** com **Spring Boot**, que permite o gerenciamento de produtos e controle de estoque. A API possibilita o cadastro de produtos, movimentações de estoque e consulta do histórico de operações.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Swagger (OpenAPI 3)**
- **Maven**

## 📦 Funcionalidades

### 1️⃣ **Cadastro de Produtos**
Criar, listar, atualizar e excluir produtos.

📌 **Campos:**
- `id` (UUID)
- `name` (String)
- `category` (String)
- `validity` (Date - para controle de vencimento)
- `stock` (Integer - controle de estoque)

📌 **Endpoints:**
- **POST /product** ➜ Criar um novo produto
- **GET /product** ➜ Listar todos os produtos
- **GET /product/search/{id}** ➜ Buscar um produto por ID
- **GET /product/name/{name}** ➜ Buscar um produto pelo nome

📌 **Exemplo de payload (POST /product):**
```json
{
  "name": "Arroz",
  "category": "Alimento",
  "validity": "2025-04-29",
  "stock": 30
}
```

---

### 2️⃣ **Controle de Estoque**
Registrar entrada e saída de produtos.

📌 **Regras:**
- Permitir entrada e saída de produtos do estoque.
- Validar saída para impedir movimentação com estoque insuficiente.

📌 **Endpoints:**
- **POST /estoque/in** ➜ Registrar entrada de estoque
- **POST /estoque/out** ➜ Registrar saída de estoque

📌 **Exemplo de payload (POST /estoque/in):**
```json
{
  "productId": "123e4567-e89b-12d3-a456-426614174000",
  "quantity": 20,
  "type": "entrada"
}
```

📌 **Exemplo de payload (POST /estoque/out):**
```json
{
  "productId": "123e4567-e89b-12d3-a456-426614174000",
  "quantity": 5,
  "type": "saida"
}
```

---

### 3️⃣ **Histórico Completo de Movimentações**
Registro detalhado de todas as movimentações (entrada/saída).

📌 **Campos (Tabela de Movimentações):**
- `id` (UUID)
- `product_id` (UUID)
- `type` (entrada/saída)
- `quantity` (Integer)
- `movementDate` (timestamp)

📌 **Endpoints:**
- **GET /estoque** ➜ Listar todas as movimentações
- **GET /estoque/{id}** ➜ Consultar uma movimentação específica
- **GET /estoque/entre-datas** ➜ Consultar movimentações por intervalo de datas
- **GET /estoque/por-produto/{productId}** ➜ Consultar movimentações de um produto específico
- **GET /estoque/por-tipo/{type}** ➜ Consultar movimentações por tipo (entrada/saída)

📌 **Exemplo de requisição (GET /estoque/entre-datas):**
```http
GET /estoque/entre-datas?startDate=2024-01-01T00:00:00&endDate=2024-01-31T23:59:59
```

## 🛠 Como Executar o Projeto

### 📌 **Pré-requisitos**
- **Java 17**
- **Maven**
- **Banco de Dados PostgreSQL**

### 📌 **Passos**
1. Clone o repositório:
   ```bash
   git clone https://github.com/Daviigs/controle-produto-estoque-api.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd controle-produto-estoque-api
   ```
3. Configure o banco de dados no `application.properties` ou `application.yml`.
4. Execute o projeto com o Maven:
   ```bash
   mvn spring-boot:run
   ```

A API estará disponível em: `http://localhost:8080`

## 🔗 Documentação da API
A API conta com a documentação interativa via Swagger.
- Acesse: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

## 📧 Contato
Caso tenha dúvidas ou sugestões, sinta-se à vontade para entrar em contato:

📩 *Email*: miqueiasdavi8@gmail.com  
🔗 *LinkedIn*: [Davi Miquéias](https://www.linkedin.com/in/davimiqueias/)  
💻 *GitHub*: [Daviigs](https://github.com/Daviigs)

---
🚀 **GitHub do Projeto:** [Controle de Estoque API](https://github.com/Daviigs/controle-produto-estoque-api)

