<div align="center">

# 👥 User API - Sistema de Gerenciamento de Usuários

### Uma API REST simples e eficiente para gerenciamento de usuários

[![Java](https://img.shields.io/badge/Java-17-red.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

</div>

---

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Execução](#instalação-e-execução)
- [Endpoints da API](#endpoints-da-api)
- [Exemplos de Uso](#exemplos-de-uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Testando a API](#testando-a-api)
- [Melhorias Futuras](#melhorias-futuras)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

---

## 🎯 Sobre o Projeto

**User API** é uma API REST desenvolvida em **Java com Spring Boot** que permite o gerenciamento completo de usuários. Este projeto foi desenvolvido como parte do meu portfólio para demonstrar conhecimentos em desenvolvimento back-end, APIs RESTful e boas práticas de programação.

### Características
- 📦 **Armazenamento em memória** - Simples e rápido para demonstração
- 🔄 **CRUD completo** - Todas as operações de manipulação de dados
- 🚀 **Leve e rápido** - Sem dependência de banco de dados externo
- 📝 **Código bem estruturado** - Organização em camadas (Controller, Service, Model)

---

## ✨ Funcionalidades

### CRUD Completo de Usuários
- ✅ **Criar usuário** - Adicionar novos usuários ao sistema
- 📖 **Listar usuários** - Visualizar todos os usuários cadastrados
- 🔍 **Buscar por ID** - Encontrar um usuário específico
- ✏️ **Atualizar usuário** - Modificar dados de um usuário existente
- 🗑️ **Deletar usuário** - Remover usuários do sistema

### Dados do Usuário
- ID único (gerado automaticamente)
- Nome completo
- E-mail
- Idade

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-------------|
| **Java** | 17 | Linguagem de programação |
| **Spring Boot** | 3.1.5 | Framework principal |
| **Spring Web** | - | Criação de APIs REST |
| **Maven** | 3.8+ | Gerenciador de dependências |

---

## 📦 Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- [✅ Java JDK 17 ou superior](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [✅ Apache Maven 3.6+](https://maven.apache.org/download.cgi)

### Verificando as instalações
```bash
# Verificar versão do Java
java -version

1️⃣ Clone o repositório (ou crie os arquivos)

git clone https://github.com/seu-usuario/user-api.git
cd user-api

2️⃣ Execute a aplicação com Maven
bash
mvn spring-boot:run
3️⃣ Aguarde a inicialização
text
====================================
API de Usuários iniciada com sucesso!
Endpoints disponíveis em: http://localhost:8080
====================================
✅ Alternativa - Gerar e executar JAR
bash
# Gerar o arquivo JAR
mvn clean package

# Executar o JAR
java -jar target/user-api-1.0.0.jar
📍 Endpoints da API
Método	Endpoint	Descrição	Status Code
GET	/api/usuarios	Lista todos os usuários	200 OK
GET	/api/usuarios/{id}	Busca usuário por ID	200 OK / 404 Not Found
POST	/api/usuarios	Cria novo usuário	201 Created
PUT	/api/usuarios/{id}	Atualiza usuário existente	200 OK / 404 Not Found
DELETE	/api/usuarios/{id}	Remove usuário	204 No Content / 404 Not Found
📝 Exemplos de Uso
1️⃣ Criar um novo usuário (POST)
Requisição:

bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao.silva@email.com",
    "idade": 30
  }'
Resposta (201 Created):

json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "idade": 30
}
2️⃣ Listar todos os usuários (GET)
Requisição:

bash
curl http://localhost:8080/api/usuarios
Resposta (200 OK):

json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@email.com",
    "idade": 30
  },
  {
    "id": 2,
    "nome": "Maria Santos",
    "email": "maria.santos@email.com",
    "idade": 25
  }
]
3️⃣ Buscar usuário por ID (GET)
Requisição:

bash
curl http://localhost:8080/api/usuarios/1
Resposta (200 OK):

json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "idade": 30
}
Usuário não encontrado (404 Not Found):

json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Usuário não encontrado"
}
4️⃣ Atualizar um usuário (PUT)
Requisição:

bash
curl -X PUT http://localhost:8080/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva Atualizado",
    "email": "joao.atualizado@email.com",
    "idade": 31
  }'
Resposta (200 OK):

json
{
  "id": 1,
  "nome": "João Silva Atualizado",
  "email": "joao.atualizado@email.com",
  "idade": 31
}
5️⃣ Deletar um usuário (DELETE)
Requisição:

bash
curl -X DELETE http://localhost:8080/api/usuarios/1
Resposta: 204 No Content (sem corpo)

📋 Exemplos de criação em massa
bash
# Criar múltiplos usuários para teste
curl -X POST http://localhost:8080/api/usuarios -H "Content-Type: application/json" -d '{"nome":"Ana Paula","email":"ana@email.com","idade":28}'
curl -X POST http://localhost:8080/api/usuarios -H "Content-Type: application/json" -d '{"nome":"Carlos Eduardo","email":"carlos@email.com","idade":35}'
curl -X POST http://localhost:8080/api/usuarios -H "Content-Type: application/json" -d '{"nome":"Fernanda Lima","email":"fernanda@email.com","idade":27}'
📁 Estrutura do Projeto
text
user-api/
│
├── pom.xml                          # Dependências e configurações do Maven
├── README.md                        # Documentação do projeto
│
└── src/
    └── main/
        └── java/
            └── com/
                └── exemplo/
                    └── api/
                        ├── ApiApplication.java              # Classe principal
                        │
                        ├── controller/
                        │   └── UsuarioController.java       # Endpoints da API
                        │
                        ├── model/
                        │   └── Usuario.java                 # Modelo de dados
                        │
                        └── service/
                            └── UsuarioService.java          # Regras de negócio
Arquitetura do Projeto
text
┌─────────────────────────────────────────────────────┐
│                    Cliente (HTTP)                    │
└──────────────────────┬──────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────┐
│    Controller (UsuarioController)                    │
│    - Recebe requisições HTTP                         │
│    - Valida dados de entrada                         │
│    - Retorna respostas JSON                          │
└──────────────────────┬──────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────┐
│    Service (UsuarioService)                          │
│    - Implementa regras de negócio                    │
│    - Gerencia IDs automaticamente                    │
│    - Manipula a lista em memória                     │
└──────────────────────┬──────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────┐
│    Model (Usuario)                                   │
│    - Representa os dados do usuário                  │
│    - Contém getters e setters                        │
└─────────────────────────────────────────────────────┘
📝 Detalhamento dos Pacotes

Pacote	Responsabilidade
controller	Controladores REST, endpoints da API
model	Entidades/objetos de domínio
service	Lógica de negócio e regras de aplicação

🧪 Testando a API
Opção 1: Thunder Client (VS Code)
Instale a extensão Thunder Client no VS Code

Crie uma nova requisição

Configure o método e a URL

Envie e veja a resposta

Opção 2: Postman
Abra o Postman

Crie uma nova coleção

Adicione as requisições conforme os exemplos acima

Salve e teste os endpoints

Opção 3: cURL (terminal)
bash
# Teste rápido com cURL
curl http://localhost:8080/api/usuarios
Opção 4: Insomnia
Similar ao Postman, interface intuitiva para testar APIs

💡 Exemplos de Uso no Front-end (JavaScript)
Criar usuário via fetch
javascript
fetch('http://localhost:8080/api/usuarios', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({
    nome: 'João Silva',
    email: 'joao@email.com',
    idade: 30
  })
})
.then(response => response.json())
.then(data => console.log('Usuário criado:', data));
Listar usuários
javascript
fetch('http://localhost:8080/api/usuarios')
  .then(response => response.json())
  .then(usuarios => console.log('Lista de usuários:', usuarios));

🔧 Possíveis Erros e Soluções

Erro	Causa	Solução
Connection refused	API não está rodando	Execute mvn spring-boot:run
404 Not Found	Endpoint incorreto	Verifique a URL e o método HTTP
Port 8080 already in use	Porta ocupada	Feche o programa usando a porta ou mude no application.properties

🚀 Melhorias Futuras
Adicionar banco de dados (PostgreSQL/MySQL)

Implementar autenticação com JWT

Adicionar validações mais robustas

Criar testes unitários e de integração

Documentação com Swagger/OpenAPI

Adicionar paginação nas listagens

Implementar DTOs para respostas

Adicionar logging com SLF4J

Criar Dockerfile para containerização

🤝 Contribuição
Contribuições são bem-vindas! Siga os passos:

Fork o projeto

Crie uma branch para sua feature (git checkout -b feature/AmazingFeature)

Commit suas mudanças (git commit -m 'Add some AmazingFeature')

Push para a branch (git push origin feature/AmazingFeature)

Abra um Pull Request

📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

👨‍💻 Autor
Kauã Gomes Barbosa Pereira - DevKauaGB

GitHub: @kauagg

LinkedIn: Kauã Gomes

Portfolio: [Meu Portifolio](https://devkaua.vercel.app/)

📧 Contato
Dúvidas ou sugestões? Entre em contato:

📧 Email: devkauagb@.com

💬 Issues: Abrir issue

<div align="center">
⭐ Se este projeto foi útil, deixe uma estrela no GitHub! ⭐
Desenvolvido com ☕ e Spring Boot

</div> ```

# Verificar versão do Maven
mvn -version
