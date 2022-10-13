package org.serratec.exercicio01;

import org.serratec.exercicio01.teste.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio01Application implements CommandLineRunner {

	@Autowired
	Pagamento pagamento;
	
	public static void main(String[] args) {
		SpringApplication.run(Exercicio01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Total a apagar: " + pagamento.calcularProcedimento(200.0, 80.0));
		
	}

}
