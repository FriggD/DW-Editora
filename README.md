### Trabalho de Desenvolvimento Web 2021/22
### Alunas: Emili Everz Golombiéski e Gláucia Dias

#### Requisitos para rodar a Aplicação secauth:

1. Instalar o Java 8 ou versão superior;
2. Instalar o Apache Maven;
3. Instalar o Apache Tomcat 8.5 ou superior;
4. Instalar o SGBD PostgreSQL.

Instruções:

1. Altere as configurações de conexão com seu PostgreSql pelo arquivo application.properties (api apenas)
2. Suba a api com o comando: 
    ```console
        $ mvn spring-boot:run
    ```
2. Suba o client com o comando: 
    ```console
        $ mvn spring-boot:run
    ```

# API:
### Cadastrar Artigo
##### Request
`POST /api/artigos` 
body {
    titulo, resumo
}
##### Response
    Artigo
    
### Listar todos os Artigos
##### Request
`GET /api/artigos` 
##### Response
    Artigo[]

### Buscar artigo por Id
##### Request
`GET /api/artigos/:id` 
##### Response
    Artigo

### Remover artigo
##### Request
`DEL /api/artigos/:id` 

### Remover todos os artigos
##### Request
`DEL /api/artigos` 