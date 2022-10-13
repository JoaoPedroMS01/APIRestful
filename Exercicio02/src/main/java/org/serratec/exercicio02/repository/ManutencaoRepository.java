package org.serratec.exercicio02.repository;

import org.serratec.exercicio02.domain.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

}
