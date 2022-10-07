package org.serratec.exercicio01.repository;

import org.serratec.exercicio01.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
