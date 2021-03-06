package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	
	private Long id;
	
	@NotNull @Size(min=5)
	private String descricao;
	
	private boolean finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;
	
	public Long getId(){
		return this.id;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public boolean getFinalizado(){
		return this.finalizado;
	}
	
	public Calendar getDataFinalizacao(){
		return this.dataFinalizacao;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public void setFinalizado(boolean finalizado){
		this.finalizado = finalizado;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao){
		this.dataFinalizacao = dataFinalizacao;
	}

}
