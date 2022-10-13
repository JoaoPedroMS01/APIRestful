package org.serratec.exercicio02.repository;

import org.serratec.exercicio02.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
