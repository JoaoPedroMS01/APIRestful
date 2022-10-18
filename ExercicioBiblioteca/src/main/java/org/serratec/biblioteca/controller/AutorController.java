package org.serratec.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.biblioteca.domain.Autor;
import org.serratec.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
	@Autowired
	AutorRepository autorRepository;

	@GetMapping
	public List<Autor> listaAutors() {
		return autorRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> pesquisar(@PathVariable Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isPresent()) {
			return ResponseEntity.ok(autor.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor inserir(@Valid @RequestBody Autor autor) {
		return autorRepository.save(autor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> alterar(@PathVariable Long id, @Valid @RequestBody Autor autor) {

		if (!autorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		autor.setId(id);
		return ResponseEntity.ok(autorRepository.save(autor));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (!autorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		autorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
