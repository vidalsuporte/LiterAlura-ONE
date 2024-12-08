package br.com.vidalsuporte.literalura.repository;

import br.com.vidalsuporte.literalura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {

@Query(value = """
        SELECT MAX(id) as id, nome, MAX(ano_nascimento) as ano_nascimento,
        Max(ano_falecimento) as ano_falecimento, MAX(livro_id) as
         livro_id FROM autores GROUP BY nome
        """, nativeQuery = true)
    List<Autor> listarTodosAutores();

@Query("SELECT a FROM Autor a WHERE a.anoFalecimento > :anoConsulta AND a.anoNascimento <= :anoConsulta")
    List<Autor> listaAutoresVivosNoAno(int anoConsulta);
}
