package org.serratec.exercicio02.repository;

import org.serratec.exercicio02.domain.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

}
