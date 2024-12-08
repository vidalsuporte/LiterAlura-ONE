# LiterAlura - Oracle Next Education 🚀

Bem-vindo(a) ao repositório **LiterAlura**, um projeto desenvolvido como parte do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. Este repositório contém o código-fonte do sistema de gerenciamento de livros, proporcionando uma experiência prática de aprendizado em desenvolvimento de software com Java, SpringBoot e PostgreSQL.

## 📖 Descrição

O **LiterAlura** é uma aplicação que permite buscar livros em uma API externa Gutendex  disponível em https://gutendex.com/ e gravar no banco e dados local para relização de operações de consultas.

Este projeto foi desenvolvido utilizando **Java** e segue princípios de boas práticas de programação.

## 🛠️ Tecnologias Utilizadas

-   **Linguagem**: Java
-   **Paradigma**: Orientação a Objetos
-   **Bibliotecas**:
    -   Scanner para entrada de dados do usuário.
    -   SpringBoot
    -   SpringJPA
    -   JDBC PostegreSQL
-   **IDE recomendada**: IntelliJ IDEA .


## 🚀 Como Executar o Projeto

1.  **Pré-requisitos**:
    
    -   JDK instalado (versão 17 ou superior).
    -   IDE ou editor de código compatível com Java.
2.  **Clone o repositório**:
    
    bash
    
    Copiar código
    
    `git clone https://github.com/vidalsuporte/LiterAlura-ONE.git
    cd LiterAlura-ONE/src` 
    
3.  **Compile e execute**:
    
    -   Abra o projeto em sua IDE favorita.
    -   Execute o arquivo `LiteraluraApplication.java`.

## 💡 Funcionalidades Principais

1.  **Buscar Livro**  
    O usuário pode cadastrar novos livros ao sistema informando título, que será pesquisado na API Gutendex https://gutendex.com/ encontrado o livro ele será salvo no banco e dados local
    
2.  **Listar Livros**  
    Mostra todos os livros cadastrados.
    
3.  **Listar Autores**  
    Lista todos autores cadatrados e seus respectivos Livros 
    
4.  **Lista Autores vivos em um ano expecifico**  
    Gera lista de autores que estão vivos no ano inserido.

5.  **Lista livros por idioma**  
    Gera lista de Livros no idioma escolhido.

6.  **Lista TOP 5 livros Baixados**  
    Gera lista dos 5 Livros mais baixados.
