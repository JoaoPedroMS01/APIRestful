package org.serratec.biblioteca.dto;

import org.serratec.biblioteca.domain.Categoria;

public class LivroDTO {
	private Long id;
	private String titulo;
	private Categoria categoria;

	public LivroDTO() {
	}

	public LivroDTO(Long id, String titulo, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
