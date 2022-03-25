package com.accenture.livroCaixa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.livroCaixa.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	
	public List<ClienteModel> findAllByNomeContainingIgnoreCase(String nome);
	   
	public Optional<ClienteModel> findById(Long id);
    public Optional<ClienteModel> findByCpfCnpj(Long cpfCnpj);
    public Optional<ClienteModel> findByNome(String nome);

}
