package com.accenture.livroCaixa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.livroCaixa.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
		public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
	   
		public Optional<UsuarioModel> findById(Long id);
	    public Optional<UsuarioModel> findByLogin(String login);
	    public Optional<UsuarioModel> findByNome(String nome);
	   
}
