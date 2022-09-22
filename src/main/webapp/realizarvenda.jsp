<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Cliente" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Jogo" %>
<%@ page import="br.com.gamex.controlegamex.controller.JogoController" %>
<%@ page import="br.com.gamex.controlegamex.controller.ClienteController" %>
<%@ page import="java.util.ArrayList" %>
<%
		Cliente c = (Cliente) session.getAttribute("clienteLogado");
		Jogo j = (Jogo) request.getAttribute("jogo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<form id="produtoform" action="CadastrarVenda" method="post">
          <input type="hidden" name="inputCliente" value="<%= c.getId() %>" />
          <input type="hidden" name="inputJogo" value="<%= j.getId() %>" />
          <input type="hidden" name="inputEstoque" value="1" />
	</form>
	<script>
	function submitForm() { 
   document.getElementById('produtoform').submit();
}
window.onload = submitForm;
	</script>
</body>
</html>
