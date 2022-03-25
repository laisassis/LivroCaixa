package com.accenture.livroCaixa.controller;

import java.util.List;

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

import com.accenture.livroCaixa.model.LivroCaixaModel;
import com.accenture.livroCaixa.repository.LivroCaixaRepository;

@RestController
@RequestMapping("/livrocaixa")
@CrossOrigin(origins="*", allowedHeaders="*")
public class LivroCaixaController {
	
	@Autowired
	private LivroCaixaRepository livroCaixaRepository;
	
	@GetMapping("/{id}")
	private ResponseEntity<LivroCaixaModel> getById(@PathVariable long id) {
		return livroCaixaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/all")
	private ResponseEntity<List<LivroCaixaModel>> getAll() {
		return ResponseEntity.ok(livroCaixaRepository.findAll());
	}
	
	 @PostMapping("/cadastrar")
	    public ResponseEntity<LivroCaixaModel> postLivro (@RequestBody LivroCaixaModel livroCaixaModel) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(livroCaixaRepository.save(livroCaixaModel));
	    }
	 
	 @PutMapping("/alterar")
	    public ResponseEntity<LivroCaixaModel> putLivro (@RequestBody LivroCaixaModel livroCaixaModel) {
	        return ResponseEntity.status(HttpStatus.OK).body(livroCaixaRepository.save(livroCaixaModel));
	    }
	 
	 @DeleteMapping("/{id}")
	 public void getId(@PathVariable long id) {
		 livroCaixaRepository.deleteById(id);
	 }

}
