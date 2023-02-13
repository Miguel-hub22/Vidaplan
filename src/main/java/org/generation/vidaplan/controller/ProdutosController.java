package org.generation.vidaplan.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.vidaplan.model.Produtos;
import org.generation.vidaplan.repository.ProdutosRepository;
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
@RequestMapping ("/produtos")
@CrossOrigin ("*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> GetById (@PathVariable Long id){
		return repository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> GetByNome
	(@PathVariable String nome){
		return ResponseEntity.ok
				(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produtos>> GetByPreco
	(@PathVariable BigDecimal preco){
		return ResponseEntity.ok
				(repository.findAllByPreco(preco));
	}
	@GetMapping("/regiao/{regiao}")
	public ResponseEntity<List<Produtos>> GetByRegiao
	(@PathVariable String regiao){
		return ResponseEntity.ok
				(repository.findAllByRegiaoContainingIgnoreCase(regiao));
	}
	@PostMapping
	public ResponseEntity<Produtos>post(@Valid @RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produtos));
	}
	@PutMapping
	public ResponseEntity<Produtos>put(@Valid @RequestBody Produtos produtos){
		return repository.findById(produtos.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(repository.save(produtos)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produtos>produtos = repository.findById(id);
		if (produtos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		repository.deleteById(id);
	}
}