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

import com.accenture.livroCaixa.model.UsuarioModel;
import com.accenture.livroCaixa.repository.UsuarioRepository;
import com.accenture.livroCaixa.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	 @Autowired
	    private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<UsuarioModel>> GetAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetById(@PathVariable long id) {
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<UsuarioModel> GetByNome(@PathVariable String nome) {
		return usuarioRepository.findByNome(nome).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{login}")
	public ResponseEntity<UsuarioModel> GetByLogin(@PathVariable String login) {
		return usuarioRepository.findByLogin(login).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> postUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel novoUsuario = usuarioService.cadastrarUsuario(usuario);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	 @PutMapping("/alterar")
	    public ResponseEntity<UsuarioModel> putUsuario(@RequestBody UsuarioModel usuario){
	        Optional<UsuarioModel> updateUsuario = usuarioService.atualizarUsuario(usuario);
	        try {
	            return ResponseEntity.ok(updateUsuario.get());
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	 public void getId(@PathVariable long id) {
		 usuarioRepository.deleteById(id);
	 }
	

}
