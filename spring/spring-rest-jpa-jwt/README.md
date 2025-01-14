# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

## Springboot - Exemplo de Uso de Spring Boot, Spring Security e JWT

Projeto Spring para demonstração do uso de Springboot, API Rest, Spring Security com JWT e Integração com banco de dados com Spring Data Jpa


#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Requisitos
###### [Criando uma Rest API com Springboot](https://github.com/glysns/java-exemplos/tree/main/spring/spring-rest-api)
###### [Criando uma JPA Rest API com Springboot](https://github.com/glysns/java-exemplos/tree/main/spring/spring-jpa-rest-api)
###### [Criando uma Rest API e Conversor Entity to Dto com Springboot](https://github.com/glysns/java-exemplos/tree/main/spring/spring-rest-entity-to-dto)


#### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: onde definimos os modelos ou seja as classes dos objetos que usamos no sistema
- Dto: onde definimos as classes que reperesentam modelo de nossas requisições e respostas HTTP.
- Repository: onde definimos o JPA para acessar os dados do BD
- Service: camada que contém regras de negócio e lógica de conversão e validação de persistência
- Resource: também chamado de Controller foi onde definimos a exposição dos recursos via API por meio da definição dos endpoints
- Config: onde definimos as configurações do Swagger para documentar a API, nosso @Bean ModelMapper para converter Entity to Dto e agora o PasswordEncoder para criptografar a senhas.
- Security: Definimos toda a configuração necessária atuar com Spring Security e JWT.

#### Como habilitar o Spring Security e JWT

##### Precisamos adicionar as dependências do Spring Security e JWT conforme código abaixo.
```
<!-- SPRING SECURITY -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<!-- JWT -->
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.7.0</version>
</dependency>
```
##### Para disponibilizar uma instancia de PasswordEndecor para o Spring criamos um Bean de PasswordEndecor.

Veja a classe: `digytal.java.config.Beans`

#### Configurando o Spring Security com JWT

- Criamos a classe `digytal.java.security.WebSecurityConfig` que contém toda a configuração de segurança necessária.
- Criamos a classe `digytal.java.security.JWTAuthorizationFilter` que é responsável para analisar o token recebido e aplicar as regras de validação implementada.
- Criamos a classe `digytal.java.security.JWTUtils` que nos auxiliará a criar token e depois obter os dados do token nas requisições com os parametros de segurança como: {KEY:Chave de Criptografia, PREFIX:Prefixo Token, TOKEN_EXPIRATION:Tempo expiração do Token}. 
- Criamos a classe `digytal.java.security.JWTObject` esta classe para ser um Objeto representado pelo JWT em sua criação. **O JWT encripta um objeto qualquer com uma convenção de subject, authorities, createDate, expirationDate**

##### Considerações:
1. Na classe `digytal.java.security.WebSecurityConfig` utilizamos as anotações abaixo para determinar ao Spring que as configurações de segurança serão de forma manual:
   - @EnableWebSecurity
   - @Configuration
   - @EnableGlobalMethodSecurity(prePostEnabled = true)
1. Na classe `digytal.java.security.WebSecurityConfig` informamos uma lista de paths relacionados o Swagger, assim não exige autenticação para visualizar a documentação:
```
private static final String[] SWAGGER_WHITELIST = {
			"/v2/api-docs","/swagger-resources", "/swagger-resources/**",
			"/configuration/ui", "/configuration/security", "/swagger-ui.html", "/webjars/**" 
			};
```
1. Ainda na classe `digytal.java.security.WebSecurityConfig` vamos sobrescrever o método configure para determinar as rotas que não precisão passar por autenticação, nosso caso só o path do Swagger e login estarão disponível.
```
@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable()
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(SWAGGER_WHITELIST).permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
```
- Agora vamos as regras aplicadas em nosso filtro de requisições na classe `digytal.java.security.JWTAuthorizationFilter`:  **NOTA: Este é um exemplo de validação de token simples**.

- A classe `digytal.java.security.JWTAuthorizationFilter` tem forte dependência a classe `digytal.java.security.JWTUtils` que é o CORE da nossa implementação JWT

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-jpa-jwt/src/main/resources/jwt-core-utils.png)

- Com a segurança devidamente configurada, vamos criar nosso token com base em um usuário do banco de dados.
- Surgirão novas classes que representarão o usuário e as ações de interação com o banco de dados, são elas.
  1. digytal.java.model.Login
  1. digytal.java.repository.LoginRepository
  1. digytal.java.service.LoginService
  1. digytal.java.resource.LoginResource
  1. digytal.java.dto.Sessao
- Modificamos a classe `digytal.java.config.SwaggerConfig` para começar a permitir um parametro `Authorization`
- Implementamos a verificação dos dados Login na requisição com base nas informações que estão no banco de dados.
![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-jpa-jwt/src/main/resources/login-service.png)


#### Iniciando a aplicação

1. Execute a classe `digytal.java.SpringRestJwtApiApplication`: A aplicação será iniciada.
   * Esta classe contém um Bean que realizar uma instrução de exemplo de inclusão de Endereço.
   ```
	@Bean
	public CommandLineRunner run(EnderecoRepository repository) throws Exception {
		return args -> {
			Endereco end = new Endereco("01001000", "Praça da Sé", "Sé", "São Paulo");
			repository.save(end);
		};
	}
   ```
   
3. Digite no navegador `http://localhost:8080/swagger-ui.html`

##### Será disponível a pagina do Swagger exibindo todos os recursos da API e POST para adicionar Endereço e Realizar Login.

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-jpa-jwt/src/main/resources/login-logar.png)

##### Realizando um teste de cadastro de Login
```
POST: http://localhost:8080/login
{
  "password": "gso",
  "username": "gso"
}
```

> Deverá retornar status 200 com o token conforme imagem abaixo:

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-jpa-jwt/src/main/resources/login-token.png)

##### Realizando um teste de cadastro de CEP com Token
```
POST: http://localhost:8080/enderecos
{
  "bairro": "Norte",
  "cep": "65180000",
  "localidade": "Humberto de Campos",
  "logradouro": "Rua da Consolação"
}
```

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-jpa-jwt/src/main/resources/token-endereco-post.png)

