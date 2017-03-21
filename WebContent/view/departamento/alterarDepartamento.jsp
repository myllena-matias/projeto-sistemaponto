<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Departamento</title>
</head>
<body>

<c:import url="/view/comum/menu.jsp" />

	<hr>
	<h3>Alterar Departamento</h3>
	<hr>
	
	<form action="alterarDepartamento" method="post">
		
		<p>
			Nome do departamento: <br />
			<input type="text" name="nomeDepartamento" value="${departamento.nomeDepartamento}" style="width: 80px;" maxlength="4" />
		</p>
		
		<p>
			Descrição: <br />
			<input type="text" name="descricao" value="${departamento.descricao}" style="width: 400px;" />
		</p>
		
		<br />
		
		<p>
			<input type="reset" value="Limpar"> &nbsp; &nbsp;
			<input type="submit" value="Alterar">
		</p>
		
	</form>
	
</body>
</html>