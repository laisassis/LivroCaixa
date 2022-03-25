package com.accenture.livroCaixa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.livroCaixa.model.LivroCaixaModel;

@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixaModel, Long> {
	
	public List<LivroCaixaModel>findAllByDescricaoContainingIgnoreCase(String descricao);

}
