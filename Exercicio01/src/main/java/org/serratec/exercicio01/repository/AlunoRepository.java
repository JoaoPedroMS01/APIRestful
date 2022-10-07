package org.serratec.exercicio01.repository;

import org.serratec.exercicio01.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
