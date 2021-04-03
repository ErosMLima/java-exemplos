# Digytal - Treinamento, Consultoria e Fábrica de Software
www.digytal.com.br
(11) 95894 0362

## Springboot - Web API - Exemplos de Integração com Banco de Dados

Projeto Spring para demonstração do uso de Springboot, API Rest e Integração com banco de dados com Spring Data Jpa


#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: onde definimos os modelos ou seja as classes dos objetos que usamos no sistema
- Repository: onde definimos o JPA para acessar os dados do BD
- Resource: também chamado de Controller foi onde definimos a exponsição dos recursos via API por meio da definição dos endpoints
- Config: onde definimos as configurações do Swagger para documentar a API

#### Configuração do Banco para usar o Spring Data Jpa

1. Precisamos adicionar duas novas dependencias em nosso projeto: O starter do Spring Data Jpa e o banco de sua preferencia, no exemplo estamos usando o H2

```
<!-- RECURSOS DO JPA COM SPRING -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- BANCO EM MEMORIA -->
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
    
```
1. Agora precisamos informar os dados de conexão no arquivo `application.properties`
  * Habilitar o H2 Console em http://localhost:8080/h2-console:
  ``` 
  spring.h2.console.enabled=true
  spring.h2.console.path=/h2-console
  ```
  
  * Testando em:
  ``` 
  JDBC URL: jdbc:h2:mem:testdb
  User Name: sa
  Pasword: <deixa vazio>
  ``` 
  
  * Exibir as intruções SQL executadas pela aplicação
  ``` 
  spring.jpa.show-sql=true
  ```
  
  * Algumas versões do Spring tem exigido adicionar estas configurações no `application.properties`
  ``` 
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  ```

#### Configuração do Swagger

A configuração do Swagger é bem simples, você só precisar criar um **@Bean** de **Docket** conforme a classe `digytal.java.config.SwaggerConfig`.

> NOTA 1: Mude o nome do pacote onde estão localizados os resources conforme linha 27.

> NOTA 2: Avalie as anotações do Swagger existentes nas classes digytal.java.model.Endereco e digytal.java.resource.EnderecoResource, estas anotações ajudam a documentar a API com o Swagger


#### Iniciando a aplicação

1. Execute a classe `digytal.java.SpringRestApiApplication`: A aplicação será iniciada.
1. Digite no navegador `http://localhost:8080/swagger-ui.html`

##### Será disponível a pagina do Swagger exibindo todos os recursos da API.

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-api/src/main/resources/swagger.png)

##### Realizando um teste de cadastro de CEP
```
POST: http://localhost:8080/enderecos
{
  "bairro": "Norte",
  "cep": "65180000",
  "localidade": "Humberto de Campos",
  "logradouro": "Rua da Consolação"
}
```

> Deverá retornar status 200

