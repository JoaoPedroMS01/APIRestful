package org.serratec.biblioteca.repository;

import org.serratec.biblioteca.domain.EmprestimoLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Long> {

}
