package com.accenture.livroCaixa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.livroCaixa.model.LivroCaixa;


@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Long> {
	
	public List<LivroCaixa>findAllByIdLivroCaixaContainingIgnoreCase(String descricao);
	public Optional<LivroCaixa> findById(long id);
	public Optional<LivroCaixa> findByDescricao(String descricao);
	

}
