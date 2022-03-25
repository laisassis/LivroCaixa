package com.accenture.livroCaixa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.accenture.livroCaixa.model.ClienteModel;
import com.accenture.livroCaixa.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteModel cadastrarUsuario(ClienteModel cliente) {
		if (clienteRepository.findByNome(cliente.getNome()).isPresent())
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		
		return clienteRepository.save(cliente);
	}
	
	public Optional<ClienteModel> atualizarCliente(ClienteModel cliente) {

		if (clienteRepository.findById(cliente.getId()).isPresent()) {
			
			return Optional.of(clienteRepository.save(cliente));

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		}

	}

}
