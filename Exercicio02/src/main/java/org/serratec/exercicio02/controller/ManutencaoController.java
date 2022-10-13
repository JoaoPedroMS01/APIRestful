package org.serratec.exercicio02.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicio02.domain.Manutencao;
import org.serratec.exercicio02.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
	@Autowired
	private ManutencaoRepository manutencaoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Manutencao inserir(@RequestBody Manutencao manutencao) {
		return manutencaoRepository.save(manutencao);
	}

	@GetMapping
	public ResponseEntity<List<Manutencao>> listar() {
		List<Manutencao> manutencoes = manutencaoRepository.findAll();
		return ResponseEntity.ok(manutencoes);
	}

	@GetMapping("{id}")
	public ResponseEntity<Manutencao> buscar(@PathVariable Long id) {
		Optional<Manutencao> manutencao = manutencaoRepository.findById(id);
		if (manutencao.isPresent()) {
			return ResponseEntity.ok(manutencao.get());
		}
		return ResponseEntity.notFound().build();
	}
}
