package org.generation.vidaplan.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.vidaplan.model.Categorias;
import org.generation.vidaplan.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping ("/categorias")
@CrossOrigin ("*")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> GetById (@PathVariable Long id){
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categorias>> GetByTipo(@PathVariable String tipo){
		return ResponseEntity.ok
				(repository.findAllByTipoContainingIgnoreCase(tipo));
	}
	@PostMapping
	public ResponseEntity<Categorias>post(@Valid @RequestBody Categorias categorias){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categorias));
	}
	@PutMapping
	public ResponseEntity<Categorias>put(@Valid @RequestBody Categorias categorias){
		return repository.findById(categorias.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(repository.save(categorias)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categorias>categorias = repository.findById(id);
		if (categorias.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		repository.deleteById(id);
	}
}
