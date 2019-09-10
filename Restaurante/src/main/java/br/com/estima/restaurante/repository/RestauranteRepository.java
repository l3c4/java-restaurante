package br.com.estima.restaurante.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.estima.restaurante.model.Restaurante;

public interface RestauranteRepository extends PagingAndSortingRepository<Restaurante, Long> {
	
	void delete(Restaurante restaurante);
	
	boolean exists(Long restauranteId);
	
	List<Restaurante> findByRestauranteNomeContainingIgnoreCase(String restauranteNome);

}
