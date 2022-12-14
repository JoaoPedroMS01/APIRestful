package org.serratec.exercicio01.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicio01.domain.Aluno;
import org.serratec.exercicio01.repository.AlunoRepository;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Aluno> buscar(@PathVariable Long matricula) {
		Optional<Aluno> aluno = alunoRepository.findById(matricula);
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		}
	return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
		Aluno alunoInserido = alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).header("x-data", "01/01/10").body(alunoInserido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
		Optional<Aluno> optionalAluno = alunoRepository.findById(id);
		if (optionalAluno.isPresent()) {
			Aluno alunoBanco = optionalAluno.get();
			alunoBanco.setNome(aluno.getNome());
			alunoBanco.setTelefone(aluno.getTelefone());
			alunoBanco.setEmail(aluno.getEmail());
			alunoBanco = alunoRepository.save(alunoBanco);
			return ResponseEntity.ok(alunoBanco);
		}
	return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (alunoRepository.existsById(id)) {
			alunoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	return ResponseEntity.notFound().build();
	}
}