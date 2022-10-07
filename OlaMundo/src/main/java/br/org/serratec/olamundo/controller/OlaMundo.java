package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OlaMundo {
	
	@GetMapping("/ola")
	public String olaMundo() {
		return "Oi Suminda! rs";
	}
	
	@GetMapping("/resposta")
	public String resposta(){
	return "Voce vem sempre aqui?";
	}
	
	@GetMapping("/maiuscula")
	public String maiuscula(@RequestParam String texto, @RequestParam Integer idade) {
		return texto.toUpperCase() + " - " + idade.toString();
	}
}