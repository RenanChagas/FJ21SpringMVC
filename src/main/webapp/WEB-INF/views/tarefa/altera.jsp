<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Página para alteração</title>
	</head>
	
	<body>
	<form action="alteraTarefa" method="post">
	
		<input type="hidden" name="id" value="${tarefas.id}"/>
		
		<table>		
			<tr>
				<th>Descrição</th>
				<th>Finalizado?</th>
				<th>Data de Finalizacao</th>	
			</tr>
			
			<tr>
				<td>
					<textarea name="descricao" rows="5" cols="100">${tarefas.descricao}</textarea>
				</td>
				<td>
					<input type="checkbox" name="finalizado" value="true" ${tarefas.finalizado?'checked': ''}/>
				</td>
		
			<c:choose> 
			<c:when test="${empty tarefas.dataFinalizacao }">
				<td><input type="text" name="dataFinalizacao"/></td>
			</c:when>
			<c:otherwise>
				<td>
					<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefas.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>" />
				</td>
			</c:otherwise>
			</c:choose>
					
			</tr>
				
		</table>
	
	<input type="submit" value="Alterar">
	
	</form>	
	</body>
</html>