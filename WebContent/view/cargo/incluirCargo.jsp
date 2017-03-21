<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Incluir Cargo</title>
</head>
<body>

	<c:import url="/view/comum/menu.jsp" />

	<hr><h3>Incluir Cargo</h3><hr>
	
	<div style="text-align: center; color: red;"> ${msg} </div>
		
	<form action="incluirCargo" method="post" enctype="multipart/form-data">
	
	<form:errors path="cargo.nomeCargo" cssStyle="color:red" />
		
		<input type="hidden" name="acao" value="incluir">
		
		<p>
			Nome do cargo: <br />
			<input type="text" name="nomeCargo" />
		</p>
		
	<form:errors path="cargo.descricao" cssStyle="color:red" />
		
		<p>
			Descrição: <br />
			<input type="text" name="descricao" />
		</p>
		
		<p>
			Quantidade de funcionários: <br />
			<input type="text" name="qtdFunc" />
		</p>
		
		<p>
			<input type="reset" value="Limpar"> &nbsp; &nbsp;
			<input type="submit" value="Inserir">
		</p>
		
	</form>
	
</body>
</html>