package br.com.caelum.tarefas.modelo;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Usuario {

	private Long id;
	
	@NotNull @Size(min=5)
	private String login;
	
	private String nome;
	private String email;
	
	@NotNull @Size(min=5)
	private String senha;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
}
