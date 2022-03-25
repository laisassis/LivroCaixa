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

import com.accenture.livroCaixa.model.LivroCaixa;
import com.accenture.livroCaixa.repository.LivroCaixaRepository;
import com.accenture.livroCaixa.service.LivroCaixaService;


@RestController
@RequestMapping("/livrocaixa")
@CrossOrigin(origins="*", allowedHeaders="*")
public class LivroCaixaController {
	
	@Autowired
	private LivroCaixaRepository livroCaixaRepository;
	
	@Autowired
	private LivroCaixaService livroCaixaService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<LivroCaixa>> GetAll() {
		return ResponseEntity.ok(livroCaixaRepository.findAll());
	}
	
	@GetMapping("/{id}")
    private ResponseEntity<LivroCaixa> getById(@PathVariable long id) {
        return livroCaixaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
	
    @PostMapping
    public ResponseEntity<LivroCaixa> postLivroCaixa(@RequestBody LivroCaixa livroCaixa) {
    	LivroCaixa novoLivro = livroCaixaService.cadastrarLivro(livroCaixa);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
 
	}
    
    @PutMapping
    public ResponseEntity<LivroCaixa> putLivroCaixa(@RequestBody LivroCaixa livroCaixa) {
	        Optional<LivroCaixa> atualizarLivro = livroCaixaService.atualizarLivro(livroCaixa);
	        try {
	            return ResponseEntity.ok(atualizarLivro.get());
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    
    }
    
    @DeleteMapping("/{id}")
    public void getId(@PathVariable long id) {
        livroCaixaRepository.deleteById(id);
    }

}
