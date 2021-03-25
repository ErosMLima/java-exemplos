# Digytal - Treinamento, Consultoria e Fábrica de Software
www.digytal.com.br
(11) 95894 0362

# Springboot - JPA -  Security - JWT

Projeto Spring para demonstração do uso de Spring Security, Spring Data JPA e JWT

## Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

## Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: onde definimos os modelos ou seja as classes dos objetos que usamos no sistema
- Repository: onde definimos o JPA para acessar os dados do BD
- Service: onde definimos as regras de negócio para manipulação dos Models
- Resource: também chamado de Controller foi onde definimos a exponsição dos recursos via API por meio da definição dos endpoints
- Doc: onde definimos as configurações do Swagger para documentar a API
- Security: onde definimos as configurações de segurança do Spring Security e JWT

# Implementações de segurança
A api faz uso de Json Web Token (JWT) para autenticação de endpoints durante o uso
da mesma além do Spring Security para configurações internas de BackEnd.

# Como funciona?

Ao criar o usuário, o sistema de login fica disponível, habilitando o acesso pelo
endpoint

Após o login o endpoint retornará uma resposta contendo os dados de autenticação,
contendo um token bearer que será filtrado pela implemetação do JWT no Java, o que
permitirá o acesso as demais funcionalidades.

# Configuração do Swagger

A configuração do Swagger é bem simples, você só precisar criar um **@Bean** de **Docket** conforme a classe `springjwt.doc.SwaggerConfig`.

> NOTA: Mude o nome do pacote onde estão localizados os resources conforme linha 43.

# Configuração de Segurança

Toda a configuração do Spring Security com JWT está centralizado na classe `springjwt.security.WebSecurityConfig`, nesta classe podemos observar que somente o link do swagger e o endpoint de login estão disponíveis o acesso sem autenticação.

# Iniciando a aplicação

1. Execute a classe `springjwt.SpringJwtApplication`: A aplicação será iniciada e um registro de usuário será inserido na base de dados através do comando: `public CommandLineRunner run(UsuarioRepository r, PasswordEncoder encoder) ...`

1. Digite no navegador `http://localhost:8080/swagger-ui.html`
1. Faça o login em : `http://localhost:8080/login`

```
{
  "usuario": "admin",
  "senha": "admin123"
}
```

> Será retornado a sessão com dados de token para usar nos damais serviços.

```
{
  "login": "admin",
  "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MTQ1MzM5NDMsImV4cCI6MTYxNDUzNzU0M30.nG-1iR34OkLdvklLZAmPhvg-T8MnV79jwpBMGWAOPKoGc8HNrn-8SbLqrChPi_Zpn5Brbff4l1hP4oGhEFtkug",
  "dataInicio": "2021-02-28T17:39:03.342+00:00",
  "dataFim": "2021-02-28T18:39:03.342+00:00"
}
```

