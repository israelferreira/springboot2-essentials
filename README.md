
# springboot2-essentials<br>

Esse repositório contém os arquivos do projeto **Spring Boot 2 Essentials**, desenvolvido pelo [William Suane (DevDojo)](https://github.com/devdojobr) e ensinado em um curso no [YouTube](https://www.youtube.com/c/DevDojoBrasil). Esse software tem a temática de Animes (desenhos animados japoneses).

O projeto foi desenvolvido com a arquitetura REST usando o framework **Spring Boot** 2.4 no **Java** 11.<br>

  
  

### Funcionalidades do software

  

-  #### Anime
    - Cadastrar um novo anime no banco de dados

    - Pesquisar animes pelo nome

    - Buscar os animes cadastrados usando paginação

    - Buscar todos os animes cadastrados sem usar paginação

    - Buscar um anime pelo código de identificação

   -  Remover um anime usando o código de identificação

    - Atualizar os dados de um anime

  

-  #### Segurança
 
    - Registrar usuários pelo banco de dados com diferentes privilégios de acessos às funcionalidades

  

### URLs

  
**Observação**: Para executar as requisições é necessário fazer a autenticação do tipo Basic Auth usando usuário e senha. O software já vem com um usuário que fica salvo em memória, com privilégios de ADMIN e USER.
<br>Usuário: spring
Senha: boot<br>

| URL | Método | Descrição |
|----------|--------------|--------------|
|`http://localhost:8080/animes?page=0` | GET | Retorna os animes com paginação. A página inicial é 0 (zero). Cada página retorna 20 elementos por padrão, mas é possível alterar a quantidade com o parâmetro **size**, exemplo: `/animes?page=0&size=50` |
|`http://localhost:8080/animes/all` | GET | Retorna todos os animes sem usar paginação. |
|`http://localhost:8080/animes/find/?name=Anime Name` | GET| Faz uma pesquisa nos animes por nome pelo parâmetro da URL |
|`http://localhost:8080/animes/{id}` | GET | Retorna o registro de um anime baseado no ID |
|`http://localhost:8080/animes` | POST | Registra um anime |
|`http://localhost:8080/animes/admin/{id}` | DELETE | Deleta o registro de um anime baseado no ID |
|`http://localhost:8080/animes` | PUT | Atualiza o registro de um anime baseado no ID, o número do ID deve ser passado no corpo do JSON |



### Softwares usados no desenvolvimento
    

*  [OpenJDK 11 (LTS) - JVM Eclipse OpenJ9](https://adoptopenjdk.net)

  

*  [Docker Desktop for Windows v3.0.0](https://www.docker.com/products/docker-desktop)

  

*  [Eclipse IDE 2020-09 for Enterprise Java](https://www.eclipse.org/downloads/packages)

  

*  [Project Lombok for Eclipse IDE v1.18.16](https://projectlombok.org/setup/eclipse)

  

*  [Postman 7.36](https://www.postman.com/downloads)


## Como executar o projeto

O projeto foi construído com a IDE Eclipse. Para executá-lo:


1. Baixe e instale o Docker Desktop

2. Faça o Download do zip do projeto ou clone o repositório Git e extraia o conteúdo do arquivado compactado


3. Navegue até a pasta do projeto e abra o Prompt de Comando do Windows ou Terminal do GNU/Linux

4. Execute o comando `docker-compose up`. Ele irá criar um container chamado springboot2-essentials contendo as imagens do grafana, prometheus e banco de dados mysql.

5. Para ter acesso ao banco de dados MySQL Server 8, abra outra janela do  Prompt de Comando/Terminal e execute o comando `docker exec -it mysql bash -l`, agora execute o comando `mysql -uroot -p`. O usuário do mysql nesse caso é o root, se for outro, altere o que está depois de -u. Digite a senha e pressione ENTER. Agora é possível criar e alterar *schemas*. Execute os scripts que estão no arquivo "anime-database-MySQL8.sql", ele irá criar o banco de dados com as tabelas necessárias para o funcionamento e também irá inserir alguns animes de exemplo e dois usuários para autenticação. 

6. O projeto usa o Lombok, que é uma biblioteca Java que reduz a quantidade de código Java. Ele é capaz de criar construtores, getters/setters e etc para classes Java, usando apenas anotações. Baixe o arquivo .jar do [Project Lombok](https://projectlombok.org/download) e instale na IDE Eclipse.

7. Abra o Eclipse IDE

  

8. Importe o projeto baixado: Vá em File > Open Projects from File System. Selecione a pasta pela opção "Directory" e pressione Finish.

  

9. Espere o Maven baixar todas as dependencias.

  

10. Abra a classe java "Springboot2EssentialsApplication" e execute o método main.

  

11. Para testar os recursos das URLs descritas acima, use alguma ferramenta de testes de API, como o **Postman**.

12. Esse projeto contém a ferramenta **Swagger UI**, que serve para documentar automaticamente uma API REST.<br>Com o projeto em execução no container Apache, vá na URL `htto://localhost:8080/swagger-ui.html`, faça autenticação (usuário: spring, senha: boot). Nessa página é possível ver a API com os métodos (GET, POST, etc) e para que serve cada URL.

13. 
