### 📌 **API de Gerenciamento de Usuários**

A Spring Role Guard é responsável pelo cadastro, atualização, recuperação e remoção de usuários no sistema. Ela segue o padrão RESTful e suporta operações para diferentes tipos de usuários, incluindo **Administradores, Entregadores, Comerciantes e Clientes**.

### 🔧 **Funcionalidades**

✅ **Criar Usuário** (`POST /users`)  
Cria um novo usuário no sistema com as informações fornecidas no corpo da requisição.

✅ **Buscar Todos os Usuários** (`GET /users`)  
Retorna uma lista de todos os usuários cadastrados no sistema.

✅ **Buscar Usuário por ID** (`GET /users/{id}`)  
Obtém os detalhes de um usuário específico com base no seu identificador único.

✅ **Atualizar Usuário** (`PUT /users/{id}`)  
Atualiza os dados de um usuário existente. Algumas restrições são aplicadas, como a impossibilidade de alterar o tipo de usuário após a criação.

✅ **Excluir Usuário** (`DELETE /users/{id}`)  
Remove um usuário do sistema com base no seu ID.

### 🔒 **Regras de Negócio**

- Cada usuário possui um **papel (role)** específico: `ADMIN`, `DELIVERYMAN`, `MERCHANT` ou `CUSTOMER`.
- Algumas informações são obrigatórias dependendo do tipo de usuário (exemplo: `CNH` para entregadores, `CNPJ` para comerciantes e `CPF` para clientes).
- **Não é permitido alterar o papel do usuário** após a criação.
- Para clientes, **é obrigatório ter pelo menos um endereço cadastrado**.

### 🛠 **Tecnologias Utilizadas**

- **Java 17+**
- **Spring Boot** (Spring MVC, Spring Data JPA, Spring Validation, Spring Security)
- **Banco de Dados**: MySQL ou PostgreSQL
- **Mapeamento de Objetos**: DTOs e ModelMapper
- **Logs e Monitoramento**: SLF4J / Logback

---
