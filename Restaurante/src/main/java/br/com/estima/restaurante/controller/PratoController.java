package br.com.estima.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estima.restaurante.model.Prato;
import br.com.estima.restaurante.repository.PratoRepository;

@RestController
@RequestMapping("prato")
public class PratoController {

	@Autowired
	PratoRepository pratoRepository;

	@GetMapping("/prato/{id}")
	public ResponseEntity<Prato> prato(@PathVariable Long id) {
		return new ResponseEntity<Prato>(pratoRepository.findOne(id), HttpStatus.OK);
	}

	@GetMapping("/pratos")
	public ResponseEntity<List<Prato>> restaurantes() {
		List<Prato> lista = (List<Prato>) pratoRepository.findAll();
		return new ResponseEntity<List<Prato>>(lista, HttpStatus.OK);
	}

	@PostMapping("/prato")
	public ResponseEntity<Void> saveProduct(@RequestBody Prato prato, UriComponentsBuilder builder) {
		pratoRepository.save(prato);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/prato/{id}").buildAndExpand(prato.getPratoId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/prato")
	public ResponseEntity<Prato> updateArticle(@RequestBody Prato prato) {
		pratoRepository.save(prato);
		return new ResponseEntity<Prato>(prato, HttpStatus.OK);
	}

	@DeleteMapping("prato/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
		pratoRepository.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
