package br.com.caelum.tarefas.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
	
	/*
	 * Annotation para que um valor seja gravado em uma coluna diferente
	 * @Column (name = "preco_total", nullable = true, length = 50
	 */
	
	/* Chave Primária 
	 * GeneratedValue = Gerado pelo banco
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String descricao;
	
	@Column (nullable = true, length = 50)
	private double preco;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}

}
