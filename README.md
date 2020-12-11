
# springboot2-essentials<br>

Esse repositório contém os arquivos do projeto **Spring Boot 2 Essentials**, desenvolvido pelo [William Suane (DevDojo)](https://github.com/devdojobr) e ensinado em um curso no [YouTube](https://www.youtube.com/c/DevDojoBrasil). Esse software tem a temática de Animes (desenhos animados japoneses).

  

<br>O projeto foi desenvolvido com a arquitetura REST usando o framework **Spring Boot** 2.4 no **Java** 11.

  
  

### Funcionalidades do software

  

-  #### Anime
    - Cadastrar um novo anime no banco de dados

    - Pesquisar animes pelo nome

    - Buscar os animes cadastrados usando paginação

    - Buscar todos os animes cadastrados sem usar paginação

    - Buscar um anime pelo código de identificação

   - Remover um anime usando o código de identificação

    - Atualizar os dados de um anime

  

-  #### Segurança

  

    - Registrar usuários pelo banco de dados com diferentes privilégios de acessos às funcionalidades

  

  

### Softwares usados no desenvolvimento

  

  

*  [OpenJDK 11 (LTS) - JVM Eclipse OpenJ9](https://adoptopenjdk.net)

  

*  [Docker Desktop for Windows v3.0.0](https://www.docker.com/products/docker-desktop)

  

*  [Eclipse IDE 2020-09 for Enterprise Java](https://www.eclipse.org/downloads/packages)

  

*  [Project Lombok for Eclipse IDE](https://projectlombok.org/setup/eclipse)

  

*  [Postman 7.36](https://www.postman.com/downloads)

  

  

### URLs

  
**Observação**: Para executar as requisições é necessário fazer a autenticação do tipo Basic Auth usando usuário e senha. O software já vem com um usuário que fica salvo em memória, com privilégios de ADMIN e USER.
Usuário: spring
Senha: boot<br><br>

| URL | Método | Descrição |

  

|----------|--------------|--------------|

    

|`http://localhost:8080/animes?page=0` | GET | Retorna os animes com paginação. A página inicial é 0 (zero). Cada página retorna 20 elementos por padrão, mas é possível alterar a quantidade com o parâmetro **size**, exemplo: `/animes?page=0&size=50` |

|`http://localhost:8080/animes/all` | GET | Retorna todos os animes sem usar paginação. |

|`http://localhost:8080/animes/find/?name=Anime Name` | GET| Faz uma pesquisa nos animes por nome pelo parâmetro da URL |
  

|`http://localhost:8080/animes/{id}` | GET | Retorna o registro de um anime baseado no ID|


|`http://localhost:8080/animes` | POST | Registra um anime |

  
  

|`http://localhost:8080/animes/admin/{id}` | DELETE | Deleta o registro de um anime baseado no ID|

  

|`http://localhost:8080/animes` | PUT | Atualiza o registro de um anime baseado no ID, o número do ID deve ser passado no corpo do JSON|

  
  

## Como executar o projeto

  

