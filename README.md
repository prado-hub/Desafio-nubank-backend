**Desafio**  
construa uma API REST para gerenciamento de clientes e seus contatos. Cada cliente pode ter um ou mais contatos associados.

**Requisitos técnicos:**
- Cadastro de Cliente(POST /clientes) ✅
- Cadastro de Contato(POST /contatos) associado a um cliente existente ✅
- Listagem de todos os clientes com seus contatos (GET /clientes) ✅
- Listagem de contaos de um cliente específico (GET /clientes/{id}/contatos) ✅
- Uso de Spring boot + Spring Data JPA ✅
- Banco de dados PostgreSQL ✅
- Entidades Cliente e Contato com relacionamento OneToMany / ManyToOne ✅


**Requisitos de Código:**
- Separação de responsabilidades(camadas: controller,service,repository) ✅
- Uso de DTOs para entrada e saída de dados ✅
- Tratamento adequado de erros
- Usar lombok ✅

**Diferenciais do projeto:**
- Uso de Docker para subir o PostgreSQL (docker-compose) ✅
- Uso de Docker para empacotar a aplicação (Dockerfile) ✅
- Uso de Mappers ✅
- Separação de responsabilidades mais elaborada ✅
	1. ContatoController e ClienteController
	2. ContatoService e ClienteService
	3. DTO(ContatoResponse,ContatoRequest)
	4. DTO(ClienteResponse,ClienteRequest)
- Testes automatizados
- Documentação com Swagger ✅

**Tecnologias usadas:**
- Java 21
- Spring boot + Spring Data JPA
- PosgresSQL
- Docker
