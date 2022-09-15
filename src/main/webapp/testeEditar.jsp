<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Cliente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alteração de cursos</title>
</head>
<body>
	
	<%
		Cliente clienteAlterar = (Cliente) request.getAttribute("cliente");
	%>
	<form method="post" action="AlterarCliente">
		<label>CPF:</label>
		<input type="text" name="inputCpf" value="<%= clienteAlterar.getCpf() %>"/>
		
		<label>Nome:</label>
		<input type="text" name="inputNome" value="<%= clienteAlterar.getNome() %>"/>
		
		<label>Email:</label>
		<input type="text" name="inputEmail" value="<%= clienteAlterar.getEmail() %>"/>
		
		<label>Telefone:</label>
		<input type="text" name="inputTelefone" value="<%= clienteAlterar.getTelefone() %>"/>
		
		<label>Endereco:</label>
		<input type="text" name="inputEndereco" value="<%= clienteAlterar.getEndereco() %>"/>
		
				
		<input type="hidden" name="InputIdentificador" value="<%= clienteAlterar.getId() %>" />
		
		<input type="submit" value="Alterar" />		
	</form>
</body>
</html>