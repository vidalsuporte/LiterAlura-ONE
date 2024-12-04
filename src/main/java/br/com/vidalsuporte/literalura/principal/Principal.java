package br.com.vidalsuporte.literalura.principal;

import br.com.vidalsuporte.literalura.service.ConectaApi;

import java.util.Scanner;

public class Principal {
   private Scanner entrada = new Scanner(System.in);
   private int opcao = -1;
   private String menu = """
                        Bem Vindo ao LiterAlura
                Catálogo de livros nacionais e internacionais
                
                SELECIONE UMA OPÇÃO:
                1 - Buscar Livro pelo Título
                2 - Listar Livros Registrado
                3 - Listar Autores Registrados
                4 - Listar Autores Vivos em um Determinado Ano
                5 - Listar Livros em um Determinado Idioma
                
                0 - Para Sair do Sistema
                    """;

   private  String endereco  = "https://gutendex.com/books/?search=";
   private ConectaApi conectaApi = new ConectaApi();
    public void exibirMenu(){

        do{
            System.out.println(menu);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao){
                case 1:{

                    System.out.println("Digite o nome do livro que deseja Buscar!");
                   var nomeLivro = entrada.nextLine();
                   endereco+= nomeLivro.replaceAll(" ","+");
                    var dadosLivro = conectaApi.obterDados(endereco);
                    System.out.println(dadosLivro);

                    break;
                }
                case 2:{
                    System.out.println("opção 2!");
                    break;
                }
                case 3:{
                    System.out.println("opção 3!");
                    break;
                }
                case 4:{
                    System.out.println("opção 4!");
                    break;
                }
                case 5:{
                    System.out.println("opção 5!");
                    break;
                }
                case 0:{
                    System.out.println("Saindo do sistema!");
                    break;
                }
                default:{
                    System.out.println("opção inválida!");
                }

            }


        }while (opcao !=0);




    }






}
