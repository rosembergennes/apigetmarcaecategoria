package com.senac.tcc.meuproduto.model;
// import java.math.BigDecimal;
// import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_categoria_produto")


public class Categoria {
	

	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   private String descricao;
	   private String nome;
	
	   
	  
	public Long getId() {return id; }
	public void setId(Long id) {this.id = id; }

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) { this.descricao = descricao;}


	public String getNome() {return nome;}
	public void setNome(String nome) { this.nome = nome;}


}
