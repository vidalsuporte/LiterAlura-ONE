package br.com.vidalsuporte.literalura.entity;

import br.com.vidalsuporte.literalura.dto.DadosAtor;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int anoNascimento;

    private int anoFalecimento;

    @ManyToOne
    private Livro livro;


    public Autor() {
    }

    public Autor(DadosAtor dadosAtor){
    this.nome = dadosAtor.nome();
    this.anoNascimento = dadosAtor.anoNascimento();
    this.anoFalecimento = dadosAtor.anoFalecimento();

    }

    public Autor(String nome, int anoNascimento, int anoFalecimento) {
    this.nome = nome;
    this.anoNascimento = anoNascimento;
    this.anoFalecimento = anoFalecimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    @Override
    public String toString() {
        return " Autor{" +
                "id= " + id +
                ", nome= '" + nome + '\'' +
                ", anoNascimento= " + anoNascimento +
                ", anoFalecimento= " + anoFalecimento +
                "} ";
    }
}
