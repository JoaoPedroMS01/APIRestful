package br.org.serratec.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.serratec.biblioteca.domain.Livro;
import br.org.serratec.biblioteca.dto.AutorTotalLivrosDTO;
import br.org.serratec.biblioteca.dto.LivroCategoriaDTO;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long>{
	public Optional<Livro> findByIsbn(String isbn);
	
	@Query("select l.titulo as titulo , c.nome as categoria  from Livro l join l.categoria c  order by c.nome")
	public List<LivroCategoriaDTO> listaLivroCategoria();
	
	@Query("select a.nome as autor, count(l.id) as total from Livro l join l.autores a group by a.nome")
	public List<AutorTotalLivrosDTO> listaTotalLivrosAutor();
	
	@Query("select l from Livro l where l.categoria.nome like :paramCategoria")
	public List<Livro> listaPorCategoria(String paramCategoria);
}
