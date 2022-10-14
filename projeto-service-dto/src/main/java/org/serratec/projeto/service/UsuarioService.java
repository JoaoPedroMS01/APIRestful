package org.serratec.projeto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.serratec.projeto.domain.Perfil;
import org.serratec.projeto.domain.Usuario;
import org.serratec.projeto.domain.UsuarioPerfil;
import org.serratec.projeto.dto.UsuarioDTO;
import org.serratec.projeto.dto.UsuarioInserirDTO;
import org.serratec.projeto.exception.EmailException;
import org.serratec.projeto.exception.SenhaException;
import org.serratec.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilService perfilService;

	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for (Usuario usuario : usuarios) {
			usuariosDTO.add(new UsuarioDTO(usuario));
		}
		
		return usuariosDTO;
	}

	public UsuarioDTO inserir(UsuarioInserirDTO user) throws EmailException {
		if (!user.getSenha().equalsIgnoreCase(user.getConfirmaSenha())) {
			throw new SenhaException("Senha e Confirma Senha não são iguais");
		}
		
		if (usuarioRepository.findByEmail(user.getEmail()) != null) {
			throw new EmailException("Email já existente");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(user.getNome());
		usuario.setEmail(user.getEmail());
		usuario.setSenha(user.getSenha());
		
		Set<UsuarioPerfil> perfis = new HashSet<>();
		
		for(Perfil perfil: user.getPerfis()) {
		perfil = perfilService.buscar(perfil.getId());
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
		perfis.add(usuarioPerfil);
		}
		
		usuario.setUsuarioPerfis(perfis);
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}
}
