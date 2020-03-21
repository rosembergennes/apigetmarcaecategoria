package com.senac.tcc.meuproduto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="tb_marca_produto")

public class MarcaProduto {

	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   private String nome;
	   private String site;
	   private BigDecimal valor;
	   private LocalDateTime datacadastro;
	   
	   
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDateTime getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(LocalDateTime datacadastro) {
		this.datacadastro = datacadastro;
	}
	public Long getId() {return id; }
	public void setId(Long id) {this.id = id; }

	public String getNome() {return nome;}
	public void setNome(String nome) { this.nome = nome;}

	public String getSite() {return site;}
	public void setSite(String site) {this.site = site; }

	
}
