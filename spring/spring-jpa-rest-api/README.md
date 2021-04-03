# Digytal - Treinamento, Consultoria e Fábrica de Software
www.digytal.com.br
(11) 95894 0362

# Springboot - Web API - Exemplos de Request

Projeto Spring para demonstração do uso de Springboot e requisições Web

## Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

## Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: onde definimos os modelos ou seja as classes dos objetos que usamos no sistema
- Repository: onde definimos o JPA para acessar os dados do BD ou Repositorio Fake
- Resource: também chamado de Controller foi onde definimos a exponsição dos recursos via API por meio da definição dos endpoints
- Config: onde definimos as configurações do Swagger para documentar a API

# Configuração do Swagger

A configuração do Swagger é bem simples, você só precisar criar um **@Bean** de **Docket** conforme a classe `digytal.java.config.SwaggerConfig`.

> NOTA 1: Mude o nome do pacote onde estão localizados os resources conforme linha 27.

> NOTA 2: Avalie as anotações do Swagger existentes nas classes digytal.java.model.Endereco e digytal.java.resource.EnderecoResource, estas anotações ajudam a documentar a API com o Swagger


# Iniciando a aplicação

1. Execute a classe `digytal.java.SpringRestApiApplication`: A aplicação será iniciada.

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