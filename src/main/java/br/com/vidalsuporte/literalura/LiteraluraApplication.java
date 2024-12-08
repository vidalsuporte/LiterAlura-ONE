package br.com.vidalsuporte.literalura;

import br.com.vidalsuporte.literalura.principal.Principal;
import br.com.vidalsuporte.literalura.repository.AutorRepository;
import br.com.vidalsuporte.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	LivroRepository repository;
	@Autowired
	AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {



		Principal principal = new Principal(repository, autorRepository);

		principal.exibirMenu();

	}
}
