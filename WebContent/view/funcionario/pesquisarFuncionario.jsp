<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de Ponto</title>
</head>
<body>

<c:import url="/view/comum/menu.jsp" />

	<div style="color: red;" align="center"> <h3> ${msg} </h3> </div>

	<hr>
	<h3>Pesquisar Funcionário</h3>
	<hr>
	
	<table border='1' style='width: 100%;'>
		<tr style='background-color: #E6E6E6; font-weight: bold;'>
			<td> ID </td>
			<td> NOME </td>
			<td> LOGIN </td>
			<td> E-MAIL </td>
			<td> CARGO</td>
			<td> AÇÕES </td>
		</tr>
	
	<c:forEach var="funcionario" items="${listaFuncionario}">
		<tr>
	    	<td> ${funcionario.id} </td>
	    	<td> ${funcionario.nome} </td>
	    	<td> ${funcionario.login} </td>
	    	<td> ${funcionario.email} </td>
	    	<td> ${funcionario.nomeCargo} </td>
	    	<td>
	    		<a href='exibirAlterarFuncionario?id=${funcionario.id}'>Editar</a> &nbsp;
	    		<a href='removerFuncionario?id=${funcionario.id}'>Remover</a>
	    	</td>
	    </tr>
	</c:forEach>
	</table>

</body>
</html>