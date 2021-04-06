# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

## Java Desktop Utils

Biblioteca de componentes para desenvolvimento desktop com Java Swing.

#### Colaboradores
- [Frank Marlon](https://github.com/fmarlon)
- [Gleyson Sampaio](https://github.com/glysns)

#### Principais Compenentes
Em Java os camponentes desktop também são classes com a finalidade de gerar interface gráfica.

- SSBotao
- SSCampoTexto
- SSCampoDataHora
- SSCaixaCombinacao
- SSGrade
- SSCabecalho
- SSRodape

#### Configuração do WindowBuilder (Editor Visual de Telas para Eclipse)

**Help -> Install New Software**
http://download.eclipse.org/windowbuilder/latest/

![](https://github.com/glysns/java-exemplos/blob/main/java-swing/desktop-utils/src/main/resources/window-builder-install.png)


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
