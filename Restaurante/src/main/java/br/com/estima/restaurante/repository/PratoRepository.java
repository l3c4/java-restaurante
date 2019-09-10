package br.com.estima.restaurante.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.estima.restaurante.model.Prato;

public interface PratoRepository extends PagingAndSortingRepository<Prato, Long> {

}
