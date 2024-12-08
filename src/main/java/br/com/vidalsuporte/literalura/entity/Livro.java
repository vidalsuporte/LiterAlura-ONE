package br.com.vidalsuporte.literalura.entity;

import br.com.vidalsuporte.literalura.dto.DadosAtor;
import br.com.vidalsuporte.literalura.dto.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(unique = true)
    private String titulo;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores = new ArrayList<>();

   private String idioma; // manter somente o primeiro idioma

   private int totalDownload;

    public Livro() {
    }

    public Livro(DadosLivro dadosLivro){
        this.titulo =dadosLivro.titulo();
        this.idioma = dadosLivro.idiomas().getFirst();
        this.totalDownload = dadosLivro.totalDownload();
            }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        autores.forEach( a -> a.setLivro(this));
        this.autores = autores;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(int totalDownload) {
        this.totalDownload = totalDownload;
    }

    @Override
    public String toString() {
        return " --------- LIVRO -------- \n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autores.getFirst().getNome() + "\n"+
                "Idioma: " + idioma + "\n" +
                "Total Downloads:  " + totalDownload +"\n"+
                "------------------------\n";
    }
}
