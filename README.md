# Finder - o site para verificar a posição dos seus carros!

**Este é um projeto básico, que simplesmente mostra alguns dados em tabela a respeito do posicionamento de alguns veículos, como placa do carro, nome do ponto de interesse, horário de chegada do veículo próximo do ponto de interesse, horário de saída e por quanto tempo ele permaneceu próximo daquele POI. É possível também filtrar por placa do veículo e por data, utilizando os filtros disponíveis acima da tabela.**

# Navegação

A home page é bem simples, apenas mostra uma frase a respeito do sistema. No menu superior, clicando em **Find car**, é possível acessar a tabela com os dados disponibilizados pelo sistema, bem como realizar os filtros.

# Tecnologias utilizadas

**Back end:** Spring Boot e Java 8
**Banco de Dados:** H2 (Java SQL DataBase)
**Front end:** Angular 11, Angular Material e Bootstrap
**Web server:** Tom Cat, disponível no próprio Spring Tool Suite.

# Como executar

**Back end:** Importar o projeto no Spring Tool Suite como Projeto Maven, aguardar o download das dependências, e por fim clicar com o botão direito do mouse no arquivo **FinderApplication.java** -> Run As -> Spring Boot App.

**Banco de Dados:** Com o Back end em execução, acessar a URL http://localhost:8080/h2-console/ pelo navegador de internet. Os dados de acesso, caso não sejam preenchidos automaticamente, são os seguintes:
|Chave        |Valor              |
|-------------|------------------ |
|Driver Class |org.h2.Driver      |
|JDBC URL:    |jdbc:h2:mem:testdb |
|User Name:   |sa                 |
|Password:    |*vazio*            |

Dentro do console do banco de dados, copiar todo o conteúdo disponível no script *populate_database.sql*, disponível na pasta *scripts* no projeto do **Back end**, colar no console do H2 e clicar em Run. That's all.

**Front end:** Dentro do diretório do Front end, abrir o console (cmd, git bash, terminal, powershell, what ever) e rodar o comando `npm i`. Após instaladas todas as dependências, rodar o comando `ng serve`, então o Front end estará disponível na url http://localhost:4200/.

# Pontos de melhoria identificados

### Fuso Horário
Ainda não foi tratado na aplicação, o que pode acabar atrapalhando na utilização.

### User Interface (UI)
Necessário ainda dar uma atenção especial à UI do sistema, foi feita uma estilização básica para permitir a visualização dos recursos, porém ainda há tudo pra melhorar.

### Responsividade
Graças aos recursos de Bootstrap utilizados, já há certa responsividade na aplicação, porém ainda muito aquém do que deve ser uma aplicação no mercado.

### Banco de dados
O Data Base H2 é ótimo para desenvolvimento e testes, facilita no ramp up de projetos, pois com poucas linhas de configuração já se tem um banco de dados SQL rodando. Porém ele não serve para persistência de dados, tudo vai pro espaço quando se interrompe a execução do Back end, então se faz necessária adoção de outro sistema de banco de dados.

### Internacionalização
É necessário configurar melhor o formato das datas, tanto como é apresentado na UI como a forma que é tratado no Front end e no Back end.