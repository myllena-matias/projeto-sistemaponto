<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Incluir Funcionário</title>
</head>
<body>
	<c:import url="/view/comum/menu.jsp" />
	
	<hr>
	<h3>Incluir Funcionário</h3>
	<hr>
	
	<form action="incluirFuncionario" method="post">
	<fieldset>
		<legend>Dados cadastrais</legend>
		
			<div class="form-group">
			<p>	<label for="nome">Nome completo</label><br />
				<input type="text" class="form-control" id="nome" name="nome" style="width: 400px;" autofocus required/>
			</p>
			</div>
		
		<div class="form-group">
		<p>	<label for="cargo">Cargo</label><br />
		<select name="cargo" id="cargo" class="form-control" required>
			<option value="sel">Selecione</option>
			<option value="adm">Administradora</option>
			<option value="atd">Atendente</option>
			<option value="sup">Supervisora</option>
		</select>
		</p>
		</div>
		
		<div class="form-group">
		<p>	<label for="email">E-mail</label><br />
			<div class="input-group">
			<span class="input-group-addon">@</span>
			<input type="email" class="form-control" id="email" name="email" style="width: 400px;" placeholder="email@exemplo.com" required/>
		</p>
		</div>
		</div>
		
	<form:errors path="funcionario.login" cssStyle="color:red" />
		
		<div class="form-group">
		<p><label for="login">Login</label><br />
			<input type="text" class="form-control" id="login" name="login" placeholder="Criar o login" required/>
		</p>
		</div>
		
	<form:errors path="funcionario.senha" cssStyle="color:red" />
		
		<div class="form-group">
		<p><label for="senha">Senha</label><br />
			<input type="password" class="form-control" id="senha" name="senha" placeholder="Criar a senha" required/>
		</p>
		</div>
		
		<div class="form-group">
		<p><label for="file">Foto do funcionário</label><br />
			<input type="file" class="form-control" id="file" name="file" required>
		</p><br />
		</div>
		
		<p>
			<input type="reset" value="Limpar"> &nbsp; &nbsp;
			<button type="submit" class="btn btn-primary">
			<span class="glyphicon glyphicon-thumbs-up"></span>
				Confirmar cadastro
			</button>
		</p>
		</fieldset>	
	</form>
	
</body>
</html>