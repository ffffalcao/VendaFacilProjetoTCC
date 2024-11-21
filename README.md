# **Venda Fácil**

## **Descrição**
O **Venda Fácil** é um sistema de gerenciamento de vendas desenvolvido para pequenas lojas varejistas, como mercados, boutiques e lojas de conveniência. O objetivo do sistema é oferecer uma ferramenta simples e eficiente para o controle de estoque, registro de vendas e gerenciamento de clientes, ajudando pequenos comerciantes a otimizar suas operações e aumentar a competitividade. Este projeto foi desenvolvido como parte do Trabalho de Conclusão de Curso (TCC) do Bacharelado em Engenharia de Software.

## **Contexto do Projeto**
Este software foi criado com o intuito de resolver a problemática enfrentada por pequenas lojas varejistas, que muitas vezes não possuem ferramentas acessíveis e eficazes para gerenciar suas vendas e estoque. A aplicação do **Venda Fácil** contribui para a organização das operações de vendas e para a melhoria no atendimento ao cliente, proporcionando maior eficiência e controle para os lojistas. 

O desenvolvimento do sistema seguiu a **metodologia ágil Scrum**, adaptada para um projeto individual, garantindo entregas contínuas e iterativas das funcionalidades, focando sempre nos requisitos mais importantes para o cliente final.

## **Funcionalidades**
- **Gerenciar Categorias**: Adicionar, editar e excluir categorias de produtos.
- **Gerenciar Produtos**: Adicionar, editar e excluir produtos no inventário.
- **Gerenciar Usuários**: Cadastrar, editar e excluir usuários do sistema.
- **Gerenciar Pedidos**: Criar pedidos, adicionar produtos ao carrinho e salvar detalhes dos pedidos.
- **Visualizar Pedidos**: Consultar pedidos realizados e visualizar detalhes completos de cada um.

## **Tecnologias Utilizadas**
- **Java**: Linguagem principal utilizada para o desenvolvimento.
- **Swing**: Biblioteca para criação da interface gráfica do usuário (GUI).
- **SQLite**: Banco de dados utilizado para armazenamento de informações.
- **iText**: Biblioteca usada para a geração de relatórios em PDF.

## **Como Executar o Projeto**
1. **Pré-requisitos**:
   - **Java JDK 8+** instalado.
   - **IDE** como Apache NetBeans.
   - **SQLite** e **driver JDBC para SQLite**.

2. **Passos para Compilar e Executar**:
   - Clone o repositório: `git clone <url-do-repositório>`
   - Importe o projeto para sua IDE preferida.
   - Configure o caminho do banco de dados no arquivo `ProvedorConexao.java`.
   - Compile e execute a classe `Login` para acessar o sistema.

## **Estrutura do Projeto**
O sistema **Venda Fácil** foi estruturado seguindo uma separação em camadas para garantir uma melhor organização e manutenibilidade do código. A estrutura segue o modelo tradicional de aplicações desktop, com a divisão entre:

- **Camada de Apresentação**: Responsável pela interface gráfica e interação com o usuário. Desenvolvida utilizando a biblioteca Swing do Java, esta camada contém as classes que compõem a interface do sistema.
  - **Classes principais**: `GerenciarCategoria`, `GerenciarCliente`, `GerenciarPedido`, `GerenciarProduto`, `GerenciarUsuario`, `Login` e `Menu`.

- **Camada de Lógica de Negócios**: Esta camada implementa as regras de negócio, como validação de entradas, cálculos e controle dos fluxos de operação do sistema. No sistema atual, a lógica de negócios está parcialmente integrada às classes da camada de apresentação. No entanto, ela é implementada nas seguintes funcionalidades:
  - **Gerenciamento de Estoque**: Métodos em classes como `GerenciarProduto` e `GerenciarPedido` verificam a disponibilidade de estoque e atualizam as quantidades dos produtos conforme necessário.
  - **Validação de Dados**: Métodos como `validarCampos` em várias classes verificam a validade dos dados de entrada dos usuários, garantindo que todas as informações necessárias sejam fornecidas antes de prosseguir.
  - **Controle de Processos de Venda**: Classes como `GerenciarPedido` contêm lógica para calcular o preço total de um pedido, gerenciar a inclusão de produtos no carrinho e processar o pagamento.
  - **Geração de Documentos**: A classe `GerenciarPedido` também é responsável pela geração de relatórios em PDF utilizando a biblioteca iText, representando um exemplo claro de lógica de negócios ao gerar documentos com informações do pedido.

- **Camada de Persistência de Dados**: Responsável pela comunicação com o banco de dados SQLite através do JDBC. Nessa camada, as classes são responsáveis pelo acesso, manipulação e armazenamento dos dados no banco. 
  - **Exemplo de classe**: `ProvedorConexao` gerencia as conexões com o banco de dados, enquanto classes como `tables` realizam a criação das tabelas necessárias no banco.

Além dessas camadas principais, o projeto utiliza algumas bibliotecas complementares:
- **JDBC**: Para a conexão e transações com o banco de dados SQLite.
- **iText**: Para a geração de relatórios em formato PDF, facilitando a exportação dos dados.

## **Metodologia de Desenvolvimento**
Este projeto foi desenvolvido utilizando a **metodologia ágil Scrum**, adaptada para um projeto individual. A abordagem Scrum permitiu a divisão do desenvolvimento em sprints curtas, onde a cada ciclo eram entregues funcionalidades incrementais. Essa metodologia garantiu flexibilidade e eficiência no processo de desenvolvimento, permitindo ajustes rápidos conforme as funcionalidades eram implementadas e testadas.

## **Contribuindo**
- Faça um fork do projeto.
- Crie um branch para sua feature (`git checkout -b feature/nova-feature`).
- Faça commit de suas alterações (`git commit -m 'Minha nova feature'`).
- Faça push para o branch (`git push origin feature/nova-feature`).
- Abra um Pull Request para revisão.

## **Licença**
Este projeto é distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

## **Autores**
- **Noel Lucas Santos Souza** - Desenvolvedor principal do sistema Venda Fácil.

