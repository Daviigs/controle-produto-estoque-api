# 📦 API de Controle de Produtos e Estoque

Este projeto é uma API REST para gerenciamento de produtos e controle de estoque, permitindo o cadastro, atualização, exclusão e consulta de produtos, além do registro de movimentações de entrada e saída de estoque.

## 🚀 Tecnologias Utilizadas

- **Java**: Linguagem de programação principal
- **Spring Boot**: Framework para desenvolvimento da API
- **PostgreSQL**: Banco de dados utilizado
- **Maven**: Gerenciador de dependências
- **Swagger**: Documentação interativa da API
- **JUnit**: Testes automatizados

## 📦 Funcionalidades

### 1. Cadastro de Produtos
Permite criar, listar, atualizar e excluir produtos.

#### 📌 Campos:
- `id` (UUID ou auto-incremento)
- `nome` (String)
- `descricao` (String)
- `preco` (BigDecimal)
- `quantidade` (Integer)
- `data_validade` (Date – para controle de vencimento)

#### 📌 Endpoints:
- `POST /produtos` ➜ Criar um novo produto
- `GET /produtos` ➜ Listar todos os produtos
- `GET /produtos/{id}` ➜ Buscar um produto por ID
- `PUT /produtos/{id}` ➜ Atualizar um produto
- `DELETE /produtos/{id}` ➜ Deletar um produto

---

### 2. Controle de Estoque
Permite registrar entrada e saída de produtos, com validação para impedir saída com estoque insuficiente.

#### 📌 Endpoints:
- `POST /estoque/entrada` ➜ Registrar entrada de estoque
- `POST /estoque/saida` ➜ Registrar saída de estoque

---

### 3. Histórico de Movimentações
Registra todas as movimentações de entrada e saída de produtos e permite consultas detalhadas.

#### 📌 Campos (Tabela de Movimentações):
- `id`
- `produto_id`
- `tipo` (entrada/saída)
- `quantidade`
- `data_movimentacao` (timestamp)

#### 📌 Endpoints:
- `GET /movimentacoes` ➜ Listar todas as movimentações (com filtros opcionais: `produto_id`, `tipo`, `data_inicial`, `data_final`)
- `GET /movimentacoes/{id}` ➜ Consultar o histórico de um produto específico

## 🔧 Como Executar o Projeto

### 📌 Pré-requisitos
Certifique-se de ter instalado:
- Java 17+
- Maven 3+
- PostgreSQL

### 📌 Configuração do Banco de Dados
No arquivo `application.properties`, configure a conexão com o banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estoque_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 📌 Rodando a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/Daviigs/controle-produto-estoque-api.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd controle-produto-estoque-api
   ```
3. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
4. A API estará disponível em: `http://localhost:8080`

## 📄 Documentação da API
A API conta com documentação interativa via Swagger. Após iniciar o projeto, acesse:
```
http://localhost:8080/swagger-ui/index.html
```

## 🤝 Contribuindo

1. Faça um **fork** do repositório.
2. Crie uma **branch** para sua feature (`git checkout -b minha-feature`).
3. Faça **commit** das suas alterações (`git commit -m 'Adicionando nova feature'`).
4. Faça **push** para a branch (`git push origin minha-feature`).
5. Abra um **Pull Request**.

## 📧 Contato
Caso tenha dúvidas ou sugestões, sinta-se à vontade para entrar em contato:

📩 **Email**: miqueiasdavi8@gmail.com  
🔗 **LinkedIn**: [Davi Miquéias](https://www.linkedin.com/in/davimiqueias/)  
💻 **GitHub**: [Daviigs](https://github.com/Daviigs)

---

🔗 **Confira o repositório no GitHub:** [API de Controle de Produtos e Estoque](https://github.com/Daviigs/controle-produto-estoque-api)

