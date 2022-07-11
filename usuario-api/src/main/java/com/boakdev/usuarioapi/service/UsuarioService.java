package com.boakdev.usuarioapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boakdev.usuarioapi.dto.UsuarioDTO;
import com.boakdev.usuarioapi.entity.Usuario;
import com.boakdev.usuarioapi.repository.UsuarioRepository;

@Service
@Transactional(readOnly = true)
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> buscarTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
	}

	public UsuarioDTO buscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return new UsuarioDTO(usuario.get());
		}
		return null;
	}

	@Transactional(readOnly = false)
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepository.save(new Usuario(usuarioDTO));
		return new UsuarioDTO(usuario);
	}

	public Boolean excluir(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());
			return true;
		}
		return false;
	}
	
	public UsuarioDTO buscarPorCpf(String cpf) {
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		if(usuario != null) {
			return new UsuarioDTO(usuario);
		}
		return null;
	}
	
	public List<UsuarioDTO> buscarUsuariosPorNome(String nome){
		List<Usuario> usuarios = usuarioRepository.queryByNomeLike(nome);
		return usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
	}

}
