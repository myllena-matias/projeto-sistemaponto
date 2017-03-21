<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de Ponto</title>
</head>
<body>

	<c:import url="comum/menu.jsp" />
	
	<p>
	Informe seu login e senha para acessar o Sistema de Ponto.
	</p>
	<div style="color: red;" align="center"> <h3> ${msg} </h3> </div>
	<p>
	<form action="efetuarLogin" method="post">
	Login: <br />
	<input type="text" name="login" required="required" />
	<br /> <br />
	Senha: <br />
	<input type="password" name="senha" required="required" />
	<br /><br />
	<input type="submit" value="Entrar" />
	</form>
	</p>

</body>
</html>