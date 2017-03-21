<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Funcionario</title>
</head>
<body>

	<c:import url="/view/comum/menu.jsp" />

	<hr>
	<h3>Alterar Funcionario</h3>
	<hr>
	
	<form action="alterarFuncionario" method="post">
	
		<input type="hidden" name="id" value="${funcionario.id}">
		
		<p>
			Nome: <br />
			<input type="text" name="nome" style="width: 80px;" value="${funcionario.nome}" />
		</p>
		
		<p>
			E-mail: <br />
			<input type="text" name="email" style="width: 400px;" value="${funcionario.email}" />
		</p>
		
		<p>
			Login: <br />
			<input type="text" name="login" value="${funcionario.login}" />
		</p>
		
		<p>
			Senha: <br />
			<input type="password" name="senha" value="${funcionario.senha}" />
		</p>
		
			
		<br />
		
		<p>
			<input type="reset" value="Limpar"> &nbsp; &nbsp;
			<input type="submit" value="Inserir">
		</p>
		
	</form>

</body>
</html>