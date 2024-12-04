package br.com.vidalsuporte.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
       @JsonAlias("title")
        String titulo,

       @JsonAlias("authors")
        List<DadosAtor> autores,

        @JsonAlias("languages")
        List<String> idiomas, // manter somente o primeiro idioma

        @JsonAlias("download_count")
        int totalDownload)  {
}
