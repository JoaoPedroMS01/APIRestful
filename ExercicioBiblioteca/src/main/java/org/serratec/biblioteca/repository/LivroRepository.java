package org.serratec.biblioteca.repository;

import java.util.List;

import org.serratec.biblioteca.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	List<Livro> findByIsbn(String isbn);

}
