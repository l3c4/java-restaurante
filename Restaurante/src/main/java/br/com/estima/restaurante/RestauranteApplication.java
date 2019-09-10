package br.com.estima.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estima.restaurante.model.Prato;
import br.com.estima.restaurante.model.Restaurante;
import br.com.estima.restaurante.repository.PratoRepository;
import br.com.estima.restaurante.repository.RestauranteRepository;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {

	@Autowired
	RestauranteRepository restauranteRepository;

	@Autowired
	PratoRepository pratoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.pratoRepository.deleteAll();
		this.restauranteRepository.deleteAll();

		Restaurante restaurante1 = new Restaurante(1L, "Oswaldo");
		Restaurante restaurante2 = new Restaurante(2L, "A CHAPA");
		Restaurante restaurante3 = new Restaurante(3L, "33333333333");
		Restaurante restaurante4 = new Restaurante(4L, "A 44444444");

		this.restauranteRepository.save(restaurante1);
		this.restauranteRepository.save(restaurante2);
		this.restauranteRepository.save(restaurante3);
		this.restauranteRepository.save(restaurante4);

		Prato prato1 = new Prato(1L, restaurante1, "X-Salda", 15.50);
		Prato prato2 = new Prato(2L, restaurante1, "Coca-Cola", 5.00);

		pratoRepository.save(prato1);
		pratoRepository.save(prato2);

	}

}
