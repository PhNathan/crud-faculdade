# crud-faculdade

## Tecnologias Utilizadas

* Postgresql

* Java 16

* Bootstrap 5

* Springboot



## O que é necessário para rodar ?

* Postgresql 9.5

* Java 11 ou 16

* Tomcat 10

* IDE Eclipse


## Como utilizar ?

 Baixe e Instale o postgresql 9.5
 Utilize o PgAdmin 3 (Basta procurá-lo na barra de pesquisa do windows após a instalação do postgres 9.5).

Crie um banco de dados no postgresql chamado - Crud 
* como senha coloque - admin
* como owner coloque - postgres
* Conecte este banco a porta 5432

## proximo passo

* Abra o eclipse importe o projeto diponível neste repositório
* Certifique-se de que seu tomcat está conectado a porta 8000 - se não estiver altere a porta do tomcat ou altere o projeto na area "Application.properties" (dentro de src/main/resources)altere o server.port para porta correta

Ao iniciar o projeto, ele vai criar a tabela Usuario no banco de dados do postgres com todas as colunas

Feito isto agora inicie o projeto rodando a "Application.java"(localizado em src/main/java -  na pasta br\com\projeto_faculdade\projeto_faculdade_crud), isto vai iniciar o servidor e a aplicação, vá no navegador e digite - http://localhost:8000/projeto-faculdade-crud/



Com isso você terá acesso a aplicação

 Caso deseje apenas ver ela em funcionamento, eu hospedei o projeto <a href="http://crud-faculdade.herokuapp.com/projeto-faculdade-crud/" target="_blank">Projeto completo</a>
