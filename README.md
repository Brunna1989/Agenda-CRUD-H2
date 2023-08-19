**_API Agenda de Contatos com SpringBoot + Banco de Dados H2 + Docker:_**

_Nesse tema extra, realizamos o desenvolvimento de um tema livre,
para que pudessemos exercitar um pouco mais de contâiners docker's._

_Esse desenvolvimento trata-se de uma API de Agenda de Contatos,
aonde implementei um CRUD completo dos mesmos. Dessa forma é possível:_

* Adicionar um novo contato;
* Atualizar um contato;
* Remover um contato;
* Listar os contatos.

_Essa API, pode ser executada e testada tanto através do RUN da aplicação quanto com a execução do contâiner docker._

_Em sua configuração properties,também está configurado o banco de dados **H2**, o qual
utilizei apenas para melhor visualização de todos os testes em conjunto._

**O que é Docker e para que serve?**

_Docker é uma plataforma de virtualização de contêineres que permite empacotar, distribuir e executar aplicativos e seus ambientes isolados. Ele é projetado para simplificar o desenvolvimento, implantação e execução de aplicativos, garantindo que eles funcionem consistentemente em diferentes ambientes, independentemente das diferenças nas configurações do sistema e das dependências._

**_Como executar essa API via contâiner docker?_**

_1. Instale Docker na sua máquina local. Siga o
tutorial de instalação de acordo com seu sistema operacional
no site oficial do Docker a partir do link abaixo:
https://docs.docker.com/get-docker/_


_2. Clone este repositório e salve-o numa pasta de livre escolha._

**_Criando a imagem:_**

_Na pasta raiz do projeto, execute o comando abaixo para efetivamente criar a imagem. A flag -t refere-se à opção de tag, ou seja, pode-se alterar o nome e a etiqueta da aplicação conforme escolha própria. No caso deste tema,
foi escolhido:_

**docker build -t agenda .**

_Em seguida, rode o contâiner com o seguinte comando:_

**docker run -p 8080:8080 agenda**

_Seu contâiner estará em execução e já será possível testar todas as funcionalidades da API._

**_Para testar no Postman, abra o aplicativo em sua máquina e execute os seguintes passos:_**

1. GET - Listar Contatos

   Método: GET
   URL: http://localhost:8080/api/contatos


2. GET - Obter Contato por ID
Método: GET
URL: http://localhost:8080/api/contatos/{id}
Substitua {id} pelo ID do contato que você deseja obter.


3. POST - Adicionar Contato

   Método: POST
   URL: http://localhost:8080/api/contatos
   Selecione o corpo da requisição como "raw" e certifique-se de selecionar o tipo "JSON (application/json)". Insira um objeto JSON representando um novo contato no corpo da requisição.


4. PUT - Atualizar Contato

   Método: PUT
   URL: http://localhost:8080/api/contatos/{id}
   Substitua {id} pelo ID do contato que você deseja atualizar.
   Insira o objeto JSON atualizado no corpo da requisição, semelhante ao exemplo do POST.


5. DELETE - Remover Contato

   Método: DELETE
   URL: http://localhost:8080/api/contatos/{id}
   Substitua {id} pelo ID do contato que você deseja remover.


**_Como testar a API no banco de dados H2?_**

_Abra o navegador e acesse o console H2 usando a URL fornecida pelo Spring Boot, que normalmente é http://localhost:8080/h2-console. Certifique-se de que a porta seja a mesma em que sua aplicação está sendo executada._

_No console H2, preencha os campos da seguinte maneira:_

    JDBC URL: jdbc:h2:mem:contatos
    User Name: sa
    Password: (deixe em branco)

_Certifique-se de que a URL JDBC corresponde à mesma fornecida nas propriedades do application.properties._

_Clique no botão "Connect" para se conectar ao banco de dados H2._

_Você deve ser redirecionado para uma interface de gerenciamento do banco de dados H2, onde você pode visualizar as tabelas, executar consultas etc._

_Agora você pode usar o Postman para testar as rotas da sua API. Certifique-se de que as URLs das requisições no Postman correspondam às rotas que você definiu em seu controller._


_Lembre-se de que o banco de dados H2 em memória é reiniciado sempre que a aplicação é encerrada, o que significa que os dados serão perdidos. Portanto, você precisará repopular o banco de dados toda vez que iniciar a aplicação. Se você deseja manter os dados persistentes entre reinicializações da aplicação, considere usar um banco de dados diferente ou configurar o H2 para armazenar os dados em disco._