<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bem Vindo</title>
	</head>
	<body>
		
		<h2>Bem vindo, ${usuarioLogado.login }</h2>
		<a href="listaTarefa">Clique aqui </a> para acessar a lista de Tarefas
		<br/>
		<br/>
		<a href="logout">Sair do sistema</a>
	</body>
</html>