package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import br.com.caelum.tarefas.modelo.*;
import br.com.caelum.tarefas.dao.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "bem-vindo";
		}
		else {
			return "redirect:loginForm";
		}
		
	} //Fim do método efetuaLogin
	
	// Método para realizar o logout
	@RequestMapping("logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "redirect:loginForm";
		
	} //Fim do método logout
	
} //Fim da classe LoginController
