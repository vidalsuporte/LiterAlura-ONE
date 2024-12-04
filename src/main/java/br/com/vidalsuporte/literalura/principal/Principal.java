package br.com.vidalsuporte.literalura.principal;

import br.com.vidalsuporte.literalura.dto.DadosAtor;
import br.com.vidalsuporte.literalura.dto.DadosResultado;
import br.com.vidalsuporte.literalura.entity.Autor;
import br.com.vidalsuporte.literalura.entity.Livro;
import br.com.vidalsuporte.literalura.repository.LivroRepository;
import br.com.vidalsuporte.literalura.service.ConectaApi;
import br.com.vidalsuporte.literalura.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
   private LivroRepository livroRepository;
   public Principal(LivroRepository livroRepository){
       this.livroRepository = livroRepository;
   }




    public void exibirMenu(){



        do{
            System.out.println(menu);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao){
                case 1:{
                    buscaLivroPorTitulo();


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

    private void buscaLivroPorTitulo() {
        System.out.println("Digite o nome do livro que deseja Buscar!");
        var nomeLivro = entrada.nextLine();
        endereco+= nomeLivro.replaceAll(" ","+");
        DadosResultado dadosResultado = new ConverteDados().converteDados(conectaApi.obterDados(endereco), DadosResultado.class);
        var livro = new Livro(dadosResultado.results().getFirst());
        List<Autor> autores = dadosResultado.results().getFirst().autores().stream()
                .map(d  -> new Autor(d.nome(), d.anoNascimento(), d.anoFalecimento()))
                .collect(Collectors.toList());
        livro.setAutores(autores);

        livroRepository.save(livro);

        System.out.println(livro);
    }


}
