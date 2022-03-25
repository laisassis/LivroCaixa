package com.accenture.livroCaixa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.livroCaixa.model.ClienteModel;
import com.accenture.livroCaixa.repository.ClienteRepository;
import com.accenture.livroCaixa.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ClienteModel>> GetAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	@GetMapping("/id/{id}")
	private ResponseEntity<ClienteModel> getById(@PathVariable long id) {
		return clienteRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<ClienteModel> getByNome(@PathVariable String nome) {
		return clienteRepository.findByNome(nome).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteModel> postCliente(@RequestBody ClienteModel cliente) {
		ClienteModel novoCliente = clienteService.cadastrarUsuario(cliente);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	 @PutMapping("/alterar")
	    public ResponseEntity<ClienteModel> putCliente(@RequestBody ClienteModel cliente){
	        Optional<ClienteModel> updateCliente = clienteService.atualizarCliente(cliente);
	        try {
	            return ResponseEntity.ok(updateCliente.get());
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	 public void getId(@PathVariable long id) {
		 clienteRepository.deleteById(id);
	 }
	

}
