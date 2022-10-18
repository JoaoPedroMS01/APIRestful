package org.serratec.projeto.controller;

import java.util.List;

import org.serratec.projeto.domain.Funcionario;
import org.serratec.projeto.dto.FuncionarioSalarioDTO;
import org.serratec.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@GetMapping
	public ResponseEntity<List<Funcionario>> listar() {
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}

	@GetMapping("/pagina")
	public ResponseEntity<Page<Funcionario>> listarPage(
			@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 3, size = 8) Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/salario")
	public ResponseEntity<Page<Funcionario>> listarSalarios(@RequestParam Double valorMinimo,
			@RequestParam Double valorMaximo, Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.findBySalarioBetween(valorMinimo, valorMaximo, pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/nome")
	public ResponseEntity<Page<Funcionario>> buscarPorNome(@RequestParam(defaultValue = "") String paramNome,
			Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.findByNomeContainingIgnoreCase(paramNome, pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/salarios-por-idade")
	public ResponseEntity<List<FuncionarioSalarioDTO>> buscaSalariosPorIdade() {
		return ResponseEntity.ok(funcionarioRepository.buscaSalariosPorIdade());
	}
}
