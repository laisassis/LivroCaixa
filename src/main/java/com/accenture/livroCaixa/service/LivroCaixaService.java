package com.accenture.livroCaixa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.accenture.livroCaixa.model.LivroCaixa;
import com.accenture.livroCaixa.repository.LivroCaixaRepository;



@Service
public class LivroCaixaService {
	
	@Autowired
	private LivroCaixaRepository livroCaixaRepository;
	
	
	public LivroCaixa cadastrarLivro (LivroCaixa livroCaixa) {
		if (livroCaixaRepository.findByDescricao(livroCaixa.getDescricao()) != null) {	
			return livroCaixaRepository.save(livroCaixa);
		}else {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "É necessário ter uma descrição");
		}	
		
	}
	
	public Optional<LivroCaixa> atualizarLivro (LivroCaixa livroCaixa) {
		if (livroCaixaRepository.findByDescricao(livroCaixa.getDescricao()) != null) {	
			return Optional.of(livroCaixaRepository.save(livroCaixa));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Coloque uma descrição");
		}
	}
	
	

}
