# springboot2-essentials<br>

Esse repositório contém os arquivos do projeto **Spring Boot 2 Essentials**, desenvolvido pelo [William Suane (DevDojo)](https://github.com/devdojobr) e ensinado em um curso no [YouTube](https://www.youtube.com/c/DevDojoBrasil). Esse software tem a temática de Animes (desenhos animados japoneses).

O projeto foi desenvolvido com a arquitetura REST usando o framework **Spring Boot** 2.4 no **Java** 11.<br>

### Funcionalidades do software  

- #### Anime
    - Cadastrar um novo anime no banco de dados
    - Pesquisar animes pelo nome
    - Buscar os animes cadastrados usando paginação
    - Buscar todos os animes cadastrados sem usar paginação
    - Buscar um anime pelo código de identificação
    - Remover um anime usando o código de identificação
    - Atualizar os dados de um anime

-  #### Segurança
    - Registrar usuários pelo banco de dados com diferentes privilégios de acessos às funcionalidades

---

### URLs  

**Observação**: Para executar as requisições é necessário fazer a autenticação do tipo Basic Auth usando usuário e senha. O software já vem com um usuário que fica salvo em memória, com privilégios de ADMIN e USER.
Usuário: spring<br>
Senha: boot<br>  

| URL | Método | Descrição |
|----------|--------------|--------------|
|`http://localhost:8080/animes?page=0` | GET | Retorna os animes com paginação. A página inicial é 0 (zero). Cada página retorna 20 elementos por padrão, mas é possível alterar a quantidade com o parâmetro **size**, exemplo: `/animes?page=0&size=50` |
|`http://localhost:8080/animes/all` | GET | Retorna todos os animes sem usar paginação. |
|`http://localhost:8080/animes/find/?name=Anime Name` | GET| Faz uma pesquisa nos animes por nome pelo parâmetro da URL |
|`http://localhost:8080/animes/{id}` | GET | Retorna os dados de um anime baseado no ID |
|`http://localhost:8080/animes` | POST | Salva um anime no banco de dados |
|`http://localhost:8080/animes/admin/{id}` | DELETE | Deleta um anime baseado no ID |
|`http://localhost:8080/animes` | PUT | Atualiza os dados de um anime baseado no ID, o número do ID deve ser passado no corpo do JSON |

---
### Softwares usados no desenvolvimento

*  [OpenJDK 11 (LTS) - JVM HotSpot](https://adoptopenjdk.net)
*  [Docker Desktop for Windows v3.0.0](https://www.docker.com/products/docker-desktop)
*  [Eclipse IDE 2020-09 for Enterprise Java](https://www.eclipse.org/downloads/packages)
*  [Project Lombok for Eclipse IDE v1.18.16](https://projectlombok.org/setup/eclipse)
*  [Postman 7.36](https://www.postman.com/downloads)
*  [Apache Maven 3.6.3](https://maven.apache.org/download.cgi)
---
### Como executar o projeto

O projeto foi construído com a IDE Eclipse. Para executá-lo:

1. Baixe e instale o Docker Desktop

2. Faça o Download do zip do projeto ou clone o repositório Git e extraia o conteúdo do arquivado compactado

3. Navegue até a pasta do projeto e abra o Prompt de Comando do Windows ou Terminal do GNU/Linux

4. Execute o comando `docker-compose up`. Ele irá criar um container chamado springboot2-essentials contendo as imagens do grafana, prometheus e banco de dados mysql.

![docker-compose up](https://user-images.githubusercontent.com/37079133/101959871-f8578680-3be4-11eb-8816-8bc44f8a396c.PNG)<br>

5. Para ter acesso ao banco de dados MySQL Server 8, abra outra janela do Prompt de Comando/Terminal e execute o comando `docker exec -it mysql bash -l`, agora execute o comando `mysql -uroot -p`. O usuário do mysql nesse caso é o root, se for outro, altere o que está depois de -u. Digite a senha e pressione ENTER. Agora é possível criar e alterar *schemas*. Execute os scripts que estão no arquivo "anime-database-MySQL8.sql", eles irão criar o banco de dados com as tabelas necessárias para o funcionamento e também irá inserir alguns animes de exemplo e dois usuários para autenticação.<br>
![docker exec](https://user-images.githubusercontent.com/37079133/101959874-f988b380-3be4-11eb-9aea-d13103274e33.PNG)<br>
![mysql -u](https://user-images.githubusercontent.com/37079133/101959875-fa214a00-3be4-11eb-9f08-a470b04ef548.PNG)<br>
![create database](https://user-images.githubusercontent.com/37079133/101959876-fa214a00-3be4-11eb-88e2-0debd5ddb5c0.PNG)<br>

6. O projeto usa o Lombok, que é uma biblioteca que reduz a quantidade de código-fonte escrito. Ele é capaz de criar construtores, getters/setters e etc para classes Java usando apenas anotações. Baixe o arquivo .jar do [Project Lombok](https://projectlombok.org/download) e instale na IDE Eclipse.


7. Abra o Eclipse IDE

8. Importe o projeto baixado: Vá em File > Open Projects from File System. Selecione a pasta pela opção "Directory" e pressione Finish.

9. Espere o Maven baixar todas as dependências.

10. Abra a classe java "Springboot2EssentialsApplication" e execute o método main.

11. Para testar os recursos das URLs descritas acima, use alguma ferramenta de testes de API, como o **Postman**.


12. Esse projeto contém a ferramenta **Swagger UI**, que serve para documentar automaticamente uma API REST.<br>Com o projeto em execução no container Apache, vá na URL `htto://localhost:8080/swagger-ui.html`, faça autenticação (usuário: spring, senha: boot). Nessa página é possível ver a API com os métodos (GET, POST, etc) e para que serve cada URL.<br>
![swagger ui](https://user-images.githubusercontent.com/37079133/101959884-fbeb0d80-3be4-11eb-8724-5efedaacf1cf.PNG)<br>
![swagger ui](https://user-images.githubusercontent.com/37079133/101959885-fbeb0d80-3be4-11eb-9e30-c25a191a6976.PNG)<br>

13. O projeto contém o Spring Actuator, que é uma ferramente que auxilia a visualização de dados como saúde e métricas da aplicação.<br>
Também é possível adicionar informações importantes na API para outras pessoas lerem. Exemplo:<br>
![Actuator](https://user-images.githubusercontent.com/37079133/101959878-fab9e080-3be4-11eb-929c-56d8aed10848.PNG)<br>
---
### Monitoramento inteligente do sistema

O projeto contém o [Prometheus](https://prometheus.io), um serviço de monitoramento de métricas para a aplicação.

Ele é usado em conjunto com o [Grafana](https://grafana.com), uma ferramenta que permite a visualização de informações em Dashboards dos dados coletados pelo Prometheus.<br>

Nesse exemplo irei usar o dashboard [**JVM (Micrometer)**](https://grafana.com/grafana/dashboards/4701), que foi criado para monitorar softwares desenvolvidos em Java.

Acesse a URL `http://localhost:3000`, o usuário e senha por padrão é **admin** nos dois campos. Agora crie o data source do Prometheus ao clicar no ícone de engrenagem (**⚙**) na barra lateral e acessar a opção Data Sources. Configure do mesmo modo que está na imagem abaixo, e clique em Save & Test.<br>

![datasource](https://user-images.githubusercontent.com/37079133/101959880-fab9e080-3be4-11eb-836a-05c61520fbeb.png)<br>
Após isso acesse na barra lateral o botão **+** e selecione Import. Cole o link do dashboard JVM Micrometer ou use o ID (4701) e selecione o data source do Prometheus que já foi configurado.<br>
Clique em Import.

![jvm micrometer](https://user-images.githubusercontent.com/37079133/101959883-fb527700-3be4-11eb-810a-6b5005b6f998.PNG)<br>

Agora é possível monitorar as informações sobre a aplicação, uso de processamento e memória RAM pela JVM sem muito esforço!
![grafana](https://user-images.githubusercontent.com/37079133/101996031-a7f82b80-3cad-11eb-902f-aa2cf6676732.PNG)

---
### Como executar os testes de integração

1. Para executar os testes de integração da classe "AnimeControllerIT" é necessário ter o [Apache Maven](https://maven.apache.org/download.cgi) instalado no computador.

2. Após ter instalado, navegue até a pasta do projeto, abra o Prompt de Comando ou PowerShell e execute o comando `mvn test -Pintegration-tests`.

3. Espere o Maven baixar todas as dependências.
  
4. Os testes de integração serão executados automaticamente.

![](https://user-images.githubusercontent.com/37079133/101987185-529e2900-3c71-11eb-9448-fa78cd95db8b.png)<br>
![Fim dos testes de integração](https://user-images.githubusercontent.com/37079133/101987188-53cf5600-3c71-11eb-82e7-0949d17a351e.PNG)<br>

---
### Autor

Feito por Israel Ferreira. 👋🏽 Entre em contato!
[![Email Badge](https://img.shields.io/badge/-israelferreira5@outlook.com-c14438?style=for-the-badge&color=blue&link=mailto:israelferreira5@outlook.com)](mailto:israelferreira5@outlook.com)

