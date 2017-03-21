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

	<hr><h3>Listar Departamento</h3><hr>
	
	<div style="text-align: center; color: red;"> ${ms} </div>

	<table border='1' style='width: 100%;'>
		<tr style='background-color: #E6E6E6; font-weight: bold;'>
			
			<td> CÓDIGO DO DEPARTAMENTO </td>
			<td> NOME DO DEPARTAMENTO </td>
			<td> DESCRIÇÃO </td>
			<td> QUANTIDADE DE FUNCIONÁRIOS</td>
						
		</tr>
	
		<c:forEach var="departamento" items="${listaDepartamento}">
			<tr>
				<td> ${departamento.codigo_dp} </td>
				<td> ${departamento.nomeDepartamento} </td>
				<td> ${departamento.descricao} </td>
				<td> ${departamento.qtdFunc} </td>
				<td>
				<a href='alterarDepartamento?codigo_dp=${departamento.codigo_dp}'>Alterar</a> &nbsp;
				<a href="removerDepartamento?codigo_dp=${departamento.codigo_dp}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>