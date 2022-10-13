package org.serratec.exercicio01.repository;

import org.serratec.exercicio01.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
