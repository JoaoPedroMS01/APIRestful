package org.serratec.exercicio01.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.exercicio01.domain.Produto;
import org.serratec.exercicio01.repository.ProdutoRepository;
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
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaId(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
	return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto produto) {
		Produto produtoInserido = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).header("x-data", "01/01/10").body(produtoInserido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			Produto produtoBanco = optionalProduto.get();
			produtoBanco.setDescricao(produto.getDescricao());
			produtoBanco.setValor(produto.getValor());
			produtoBanco.setDataCadastro(produto.getDataCadastro());
			produtoBanco = produtoRepository.save(produtoBanco);
			return ResponseEntity.ok(produtoBanco);
		}
	return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	return ResponseEntity.notFound().build();
	}
}
