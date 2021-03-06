package com.accenture.livroCaixa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_clientes")
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP )
	private Date dataCadastro =  new java.sql.Date(System.currentTimeMillis());
	
	@NotNull(message = "O Nome é obrigatório")
	private String nome;
	
	@NotNull(message = "O CPF/CNPJ é obrigatório")
	private long cpfCnpj;
	
	@NotNull(message = "O logadouro é obrigatório")
	@NotBlank(message = "O logadouro não pode ser vazio")
	private String logadouro;
	
	@NotNull(message = "A cidade é obrigatória")
	private String cidade;
	
	@NotNull(message = "UF é obrigatório Ex: SP")
	@Size(min = 02, max = 02 )
	private String uf;
	
	@NotNull(message = "O Cep é obrigatório")
	private String cep;
	

	private long telefone;
	
	@Email(message = "Deve ser um email")
	private String email;
	
	
	/*Método contrutor
	
	public ClienteModel(long id, Date dataCadastro, String nome, long cpfCnpj, String logadouro, String cidade, String uf,
			String cep, long telefone, String email ) {
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.logadouro = logadouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		
	}*/
	
	@OneToMany(mappedBy = "clienteModel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("clienteModel")
	private List<LivroCaixaModel> livroCaixaModel;


	public List<LivroCaixaModel> getLivroCaixaModel() {
		return livroCaixaModel;
	}

	public void setLivroCaixaModel(List<LivroCaixaModel> livroCaixaModel) {
		this.livroCaixaModel = livroCaixaModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
