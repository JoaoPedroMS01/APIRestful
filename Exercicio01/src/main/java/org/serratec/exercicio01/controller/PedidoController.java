package org.serratec.exercicio01.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicio01.domain.Pedido;
import org.serratec.exercicio01.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();
	}
}
