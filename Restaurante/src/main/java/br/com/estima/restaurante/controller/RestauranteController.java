package br.com.estima.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estima.restaurante.model.Restaurante;
import br.com.estima.restaurante.repository.RestauranteRepository;

@Controller
@RequestMapping("restaurante")
public class RestauranteController {

	@Autowired
	RestauranteRepository restauranteRepository;

	@GetMapping("/restaurante/{id}")
	public ResponseEntity<Restaurante> restaurante(@PathVariable Long id) {
		return new ResponseEntity<Restaurante>(restauranteRepository.findOne(id), HttpStatus.OK);
	}

	@GetMapping("/restaurantes")
	public ResponseEntity<List<Restaurante>> restaurantes() {
		List<Restaurante> lista = (List<Restaurante>) restauranteRepository.findAll();
		return new ResponseEntity<List<Restaurante>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/pesquisarPorRestauranteNome")
	public ResponseEntity<List<Restaurante>> pesquisarPorRestauranteNome(@RequestParam("restauranteNome") String restauranteNome) {
		List<Restaurante> lista = (List<Restaurante>) restauranteRepository.findByRestauranteNomeContainingIgnoreCase(restauranteNome);
		return new ResponseEntity<List<Restaurante>>(lista, HttpStatus.OK);
	}

	@PostMapping("/restaurante")
	public ResponseEntity<Void> saveProduct(@RequestBody Restaurante restaurante, UriComponentsBuilder builder) {
		restauranteRepository.save(restaurante);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/restaurante/{id}").buildAndExpand(restaurante.getRestauranteId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/restaurante")
	public ResponseEntity<Restaurante> updateArticle(@RequestBody Restaurante restaurante) {
		restauranteRepository.save(restaurante);
		return new ResponseEntity<Restaurante>(restaurante, HttpStatus.OK);
	}

	@DeleteMapping("/restaurante/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
		restauranteRepository.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
