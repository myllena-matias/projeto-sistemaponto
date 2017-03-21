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

	<hr><h3>Listar Cargo</h3><hr>
	
	<div style="text-align: center; color: red;"> ${msg} </div>

	<table border='1' style='width: 100%;'>
		<tr style='background-color: #E6E6E6; font-weight: bold;'>
			
			<td> CÓDIGO DO CARGO </td>
			<td> NOME DO CARGO </td>
			<td> DESCRIÇÃO </td>
			<td> QUANTIDADE DE FUNCIONÁRIOS</td>
		</tr>
	
		<c:forEach var="cargo" items="${listaCargo}">
			<tr>
				
				<td> ${cargo.codigo_cg} </td>
				<td> ${cargo.nomeCargo} </td>
				<td> ${cargo.descricao} </td>
				<td> ${cargo.qtdFunc} </td>
				<td> <img alt="" src="view/img/${cargo.imagem}" style="width: 30%;"> </td>
				<td>
				<a href='alterarCargo?id=${cargo.codigo_cg}'>Alterar</a> &nbsp;
				<a href="removerCargo?id=${cargo.codigo_cg}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>