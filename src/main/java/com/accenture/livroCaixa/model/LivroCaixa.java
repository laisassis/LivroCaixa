package com.accenture.livroCaixa.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_livroCaixa")
public class LivroCaixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id; 
	
	@Temporal(TemporalType.TIMESTAMP )
	private Date dataLancamento = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull(message = "A descrição é obrigatório")
	@Size(max = 50,  message = "A descrição deve conter no máximo 50 caracteres")
	private String descricao;
	
	@NotNull
	private String tipo; 
	
	@NotNull
	private BigDecimal valor;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	//Conexão com Clientes
	@ManyToOne
	@JsonIgnoreProperties("livroCaixa")
	private ClienteModel cliente;



	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

}
