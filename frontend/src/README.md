# Projeto de Gestão de Clientes

Este projeto tem como objetivo criar um sistema de gestão de clientes, permitindo a criação, atualização, exclusão e listagem de clientes.

## Funcionalidades
- Adicionar um novo cliente
- Atualizar informações de um cliente
- Excluir um cliente
- Listar todos os clientes

## Tecnologias Utilizadas

**Front-end:** Angular 17, Angular Material, TypeScript, Html e CSS.
**Back-end:** Java 17, Spring Boot, PostgreSQL + DBeaver, JUnit + Mockito para testes unitários, Flyway para migrações.

## Configuração

### Para o back-end:

- Certifique-se de ter o Java e o Maven instalados em seu sistema antes de prosseguir.

```bash
  git clone https://github.com/ThallysCezar/crud-project-client
  cd pasta-do-projeto
```

- Execute o projeto usando o Maven

```bash
  mvn spring-boot:run
```

- Execute o comando para criação do banco de dados, via Flyway:

```bash
  mvn flyway:migrate
```

Certifique-se de ter configurado o Flyway corretamente, pois precisa ter o mesmo nome do banco de dados que você criou no arquivo "flyway.conf".
 

### Para o back-end:
- Abra o terminal e navegue até a pasta do projeto.
- Execute `npm install` para instalar as dependências.
- Execute `ng serve` para iniciar o servidor de desenvolvimento.
- Acesse `http://localhost:4200` no seu navegador para visualizar o projeto.
PS: O projeto do backend tem que estar rodando ja, ou senão não aparecerá nada, pois não foi iniciado o banco de dados.

## Melhorias Possíveis

- Implementar autenticação de usuários
- Adicionar paginação na listagem de clientes
- Melhorar o layout e design da aplicação
- Responsividade da aplicação no geral.
- Testes de implementações, na parte do Frontend.

## Documentação da API
- ClientController

### Recupera todas as perguntas disponíveis.

```http
  GET /api/clientes
```

### Recupera uma pergunta específica com base no ID fornecido.

```http
  GET /api/clientes/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório**. O id do seu Cliente |

### Salvar cliente

```http
  POST /api/clientes
```
```JSON
  {
	"name": "Teste create",
	"contactNumber": "123456789",
	"address": "Rua ABC, 123",
	"gender": "Masculino",
	"department": "Back-end",
	"skills": "Java, Spring, Angular",
	"isActive": true
}
```

### Cria uma nova pergunta. JSON exemplo:

```http
  PUT /api/clientes/updateClient/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório**. O id do seu Cliente |


### deletar cliente:

```http
  DELETE /api/clientes/deleteClient/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório**. O id do seu Cliente |
 


## Contribuindo

Contribuições são sempre bem-vindas!

Se você encontrar problemas ou tiver sugestões de melhorias, sinta-se à vontade para abrir um problema ou enviar uma solicitação pull.