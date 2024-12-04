package br.com.vidalsuporte.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAtor(
        @JsonAlias("name")
        String nome,

        @JsonAlias("birth_year")
        int anoNascimento,

        @JsonAlias("death_year")
        int anoFalecimento) {
}
