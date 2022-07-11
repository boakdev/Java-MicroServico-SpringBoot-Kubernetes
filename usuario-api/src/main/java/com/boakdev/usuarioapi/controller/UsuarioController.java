package com.boakdev.usuarioapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boakdev.usuarioapi.dto.UsuarioDTO;
import com.boakdev.usuarioapi.entity.Usuario;
import com.boakdev.usuarioapi.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public List<UsuarioDTO> buscarTodos() {
		return usuarioService.buscarTodos();
	}

	@GetMapping("/buscarPorId")
	public UsuarioDTO buscarPorId(Long id) {
		return usuarioService.buscarPorId(id);
	}

	@GetMapping("/buscarPorCpf/{cpf}")
	public UsuarioDTO buscarPorCpf(@PathVariable String cpf) {
		return usuarioService.buscarPorCpf(cpf);
	}
	
	@GetMapping("/buscarUsuariosPorNome/{nome}")
	public List<UsuarioDTO> buscarUsuariosPorNome(
			@RequestParam(name = "nome", required = true) String nome){
		return usuarioService.buscarUsuariosPorNome(nome);
	}

	@PostMapping("/novoUsuario")
	public UsuarioDTO adicionar(@RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.salvar(usuarioDTO);
	}

	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Long id) {
		return usuarioService.excluir(id);
	}
}
