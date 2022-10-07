package org.serratec.exercicio02.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.exercicio02.domain.Veiculo;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/veiculo")
public class VeiculoController {
	
	private static List<Veiculo> veiculos = new ArrayList<>();
	static {
		veiculos.add(new Veiculo(1, "Ford", "Mustang"));
		veiculos.add(new Veiculo(2, "Fiat", "Uno"));
		veiculos.add(new Veiculo(3, "Honda", "Civic"));
	}
	
	@GetMapping
	public List<Veiculo> listarVeiculos() {
		return veiculos;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscarVeiculo(@PathVariable Integer id) {
		for (int i = 0; i < veiculos.size(); i++) {
			Veiculo veiculo = veiculos.get(i);
			if (veiculo.getId().equals(id)) {
				return veiculo;
			}
		}
	return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@RequestBody Veiculo veiculo) {
		veiculos.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		for (int i = 0; i < veiculos.size(); i++) {
			Veiculo veiculo = veiculos.get(i);
			if (veiculo.getId().equals(id)) {
				veiculos.remove(i);
			}
		}
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@PathVariable Integer id, @RequestBody Veiculo veiulo) {
		for (int i = 0; i < veiculos.size(); i++) {
			Veiculo veiculo = veiculos.get(i);
			if (veiculo.getId().equals(id)) {
				veiculo.setMarca(veiculo.getMarca());
				veiculo.setModelo(veiculo.getModelo());
				return veiculo;
			}
		}
	return null;
	}
	
}
