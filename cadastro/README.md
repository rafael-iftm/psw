# Projeto Cadastro
Projeto de exemplo de um sistema de cadastro simples usando Spring Boot e Thymeleaf.

## Sobre o Projeto
Este projeto é um exemplo de um sistema de cadastro desenvolvido em Spring Boot, usando o Thymeleaf como mecanismo de templates.

## Tecnologias Utilizadas
- Spring Boot
- Thymeleaf
- Banco de Dados
  - Configuração no arquivo `application.properties`

        setx MYSQL_PASSWORD ${MYSQL_PASSWORD}

  - Script básico em `create-database.sql`
- Maven

## Funcionalidades
- Listagem de cadastros
- Inserção de novos cadastros
- Edição de cadastros
- Exclusão de cadastros
- Pesquisa de cadastros por nome

## Como Executar o Projeto
1- Clone o repositório do GitHub:
    
    git clone https://github.com/seu-usuario/cadastro.git
    
    
2- Navegue até a pasta do projeto:
    
    cd cadastro
    
    
3- Execute o aplicativo Spring Boot:
    
    ./mvnw spring-boot:run
    
    
O aplicativo estará disponível em http://localhost:8080.

Abra um navegador e acesse http://localhost:8080/cadastros para acessar a lista de cadastros.