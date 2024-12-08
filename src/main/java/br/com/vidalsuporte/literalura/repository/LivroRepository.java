package br.com.vidalsuporte.literalura.repository;

import br.com.vidalsuporte.literalura.entity.Autor;
import br.com.vidalsuporte.literalura.entity.Livro;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByIdiomaIgnoreCase(String idioma);

    @Query("SELECT l FROM Livro l ORDER BY l.totalDownload DESC LIMIT 5")
    List<Livro> top5();
}
