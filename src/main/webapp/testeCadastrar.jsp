<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Cliente</title>
</head>
<body>
	<form method="post" action="CadastrarCliente">
		<label>CPF: </label>
		<input type="text" name="inputCpf" required />
		<label>Nome: </label>
		<input type="text" name="inputNome" required />
		<label>Endereco: </label>
		<input type="text" name="inputEndereco" required />
		<label>Telefone: </label>
		<input type="text" name="inputTelefone" required />
		<label>Email: </label>
		<input type="text" name="inputEmail" required />
	
		<input type="submit" />
	</form>
</body>
</html>