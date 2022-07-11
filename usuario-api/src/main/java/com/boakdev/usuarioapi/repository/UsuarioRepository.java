package com.boakdev.usuarioapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boakdev.usuarioapi.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByCpf(String cpf);

	List<Usuario> queryByNomeLike(String nome);
}
