package com.accenture.livroCaixa.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.accenture.livroCaixa.model.UsuarioModel;
import com.accenture.livroCaixa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	//Cadastrar
	
	public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {
		if (usuarioRepository.findByNome(usuario.getNome()).isPresent())
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		
		return usuarioRepository.save(usuario);
	}
	
	//Atualizar
	
	public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuario) {
		if (usuarioRepository.findById(usuario.getId()).isPresent()) {
			return Optional.of(usuarioRepository.save(usuario));

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		}
	}
	

			
	
	

}
