package br.com.vidalsuporte.literalura.principal;

import br.com.vidalsuporte.literalura.dto.DadosResultado;
import br.com.vidalsuporte.literalura.entity.Autor;
import br.com.vidalsuporte.literalura.entity.Livro;
import br.com.vidalsuporte.literalura.repository.AutorRepository;
import br.com.vidalsuporte.literalura.repository.LivroRepository;
import br.com.vidalsuporte.literalura.service.ConectaApi;
import br.com.vidalsuporte.literalura.service.ConverteDados;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
            6 - Top 5 de Livros Baixados
            
            0 - Para Sair do Sistema
            """;

    private String endereco = "https://gutendex.com/books/?search=";
    private ConectaApi conectaApi = new ConectaApi();
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }


    public void exibirMenu() throws UnsupportedEncodingException {


        do {
            System.out.println(menu);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1: {
                    buscaLivroPorTitulo();


                    break;
                }
                case 2: {
                    listarTodosLivros();
                    break;
                }
                case 3: {
                    listarAutoresRegitrados();
                    break;
                }
                case 4: {
                    exibeAutoresVivos();
                    break;
                }
                case 5: {
                    exibeLivrosPorIdioma();
                    break;
                }
                case 6:{
                    top5Download();
                    break;
                }
                case 0: {
                    System.out.println("Saindo do sistema!");
                    break;
                }
                default: {
                    System.out.println("opção inválida!");
                }

            }


        } while (opcao != 0);


    }




    private void buscaLivroPorTitulo() throws UnsupportedEncodingException {
        System.out.println("Digite o nome do livro que deseja Buscar!");
        var nomeLivro = entrada.nextLine();
        var nomeLivroCodigicado = URLEncoder.encode(nomeLivro, "UTF-8");
        DadosResultado dadosResultado = new ConverteDados().converteDados(conectaApi.obterDados(endereco + nomeLivroCodigicado), DadosResultado.class);
        var livro = new Livro(dadosResultado.results().getFirst());
        List<Autor> autores = dadosResultado.results().getFirst().autores().stream()
                .map(d -> new Autor(d.nome(), d.anoNascimento(), d.anoFalecimento()))
                .collect(Collectors.toList());
        livro.setAutores(autores);

        livroRepository.save(livro);

        System.out.println(livro);
    }


    private void listarTodosLivros() {

        livroRepository.findAll().forEach(System.out::println);

    }


    private void listarAutoresRegitrados() {

        autorRepository.listarTodosAutores().forEach(System.out::println);

    }


    private void exibeAutoresVivos() {

        System.out.println("Digite uma ano para consulta de Autores vivos");
        var anoConsulta = entrada.nextInt();
        entrada.nextLine();

        if (!autorRepository.listaAutoresVivosNoAno(anoConsulta).isEmpty()) {
            autorRepository.listaAutoresVivosNoAno(anoConsulta).forEach(System.out::println);
        } else {
            System.out.println("Nenhum autor cadastrado vivo neste ano!");
        }
    }

    private void exibeLivrosPorIdioma() {
        var menu = """
                Selecione o idioma:
                pt - Português
                en - Inglês
                fr - Fraces
                """;

        System.out.println(menu);
        var idioma = entrada.nextLine();

        if(!livroRepository.findByIdiomaIgnoreCase(idioma).isEmpty()) {
            livroRepository.findByIdiomaIgnoreCase(idioma).forEach(System.out::println);
        }else {
            System.out.println("Nenhum Livro encontrado!");
        }
    }

    private void top5Download() {

        livroRepository.top5().forEach(System.out::println);




    }




}



