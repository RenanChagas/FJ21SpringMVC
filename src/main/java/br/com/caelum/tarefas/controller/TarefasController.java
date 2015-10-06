package br.com.caelum.tarefas.controller;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import br.com.caelum.tarefas.modelo.*;
import br.com.caelum.tarefas.dao.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TarefasController {
	
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		
		if(result.hasErrors()){
			return "tarefa/formulario";
		}
		
		TarefaDAO dao = new TarefaDAO();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefa")
	public String lista(Model model){
		TarefaDAO dao = new TarefaDAO();
		model.addAttribute("tarefas", dao.getListaTarefa());
		return "tarefa/lista";
	}
	
	/*
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa){
		TarefaDAO dao = new TarefaDAO();
		dao.remove(tarefa);
		return "redirect:listaTarefa";	
	}
	*/
	
	@RequestMapping("removeTarefa")
	public void remove(Tarefa tarefa, HttpServletResponse response){
		TarefaDAO dao = new TarefaDAO();
		dao.remove(tarefa);
		response.setStatus(200);
	}
	
	
	@RequestMapping("alteraVisualizar")
	public String alteraVisualizar(Tarefa tarefa, Model model){
		TarefaDAO dao = new TarefaDAO();
		model.addAttribute("tarefas", dao.getVisualizarTarefa(tarefa));
		return "tarefa/altera";
	}
	
	@RequestMapping("alteraTarefa")
	public String alteraTarefa(Tarefa tarefa){
		TarefaDAO dao = new TarefaDAO();
		dao.altera(tarefa);
		return "redirect:listaTarefa";
	}
	
	@RequestMapping("finalizaTarefa")
	public void finalizaTarefa(Long id, HttpServletResponse response){
		TarefaDAO dao = new TarefaDAO();
		dao.finalizaTarefa(id);
		response.setStatus(200);
	}
	
}
