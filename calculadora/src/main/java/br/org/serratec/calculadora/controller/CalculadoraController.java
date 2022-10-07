package br.org.serratec.calculadora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@GetMapping("/soma")
	public Double soma(@RequestParam Double num1, @RequestParam Double num2) {
		return num1 + num2;
	}
	
	@GetMapping("/subtracao")
	public Double subtracao(@RequestParam Double num1, @RequestParam Double num2) {
		return num1 - num2;
	}
	
	@GetMapping("/multiplicacao")
	public Double multiplicacao(@RequestParam Double num1, @RequestParam Double num2) {
		return num1 * num2;
	}
	
	@GetMapping("/divisao")
	public Double divisao(@RequestParam Double num1, @RequestParam Double num2) {
		return num1 / num2;
	}
	
}
