# Digytal - Treinamento, Consultoria e Fábrica de Software
www.digytal.com.br
(11) 95894 0362

## Springboot - Rest API 

Projeto Spring para demonstração do uso de Springboot o Apache POI.

**NOTA: NÃO é necessário o projeto ser Springboot para uso do Apache POI **

#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: Classes que represetam o modelo da aplicação na qual é necessário criar através da leitura do arquivo
- Util: pacote que contém a classe `digytal.java.util.ExcelResultSet` com toda lógica de leitura de arquivo.

> ExcelResultSet: Definição de uma classe Utilitária que lê registros através de uma planilha Excel com base na estrutura JDBC ResultSet

A configuração do Swagger é bem simples, você só precisar criar um **@Bean** de **Docket** conforme a classe `digytal.java.config.SwaggerConfig`.

> NOTA 1: Mude o nome do pacote onde estão localizados os resources conforme linha 27.

> NOTA 2: Avalie as anotações do Swagger existentes nas classes `digytal.java.model.Endereco` e `digytal.java.resource.EnderecoResource`, estas anotações ajudam a documentar a API com o Swagger


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
