package br.com.vidalsuporte.literalura.repository;

import br.com.vidalsuporte.literalura.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
