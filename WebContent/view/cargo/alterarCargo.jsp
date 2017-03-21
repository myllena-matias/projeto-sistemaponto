<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Cargo</title>
</head>
<body>

<c:import url="/view/comum/menu.jsp" />

	<hr>
	<h3>Alterar Cargo</h3>
	<hr>
	
	<form action="alterarCargo" method="post">
		
		<p>
			Nome do cargo: <br />
			<input type="text" name="nomeCargo" value="${cargo.nomeCargo}" style="width: 80px;" maxlength="4" />
		</p>
		
		<p>
			Descrição: <br />
			<input type="text" name="descricao" value="${cargo.descricao}" style="width: 400px;" />
		</p>
		
		<br />
		
		<p>
			<input type="reset" value="Limpar"> &nbsp; &nbsp;
			<input type="submit" value="Alterar">
		</p>
		
	</form>
	
</body>
</html>