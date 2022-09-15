<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="br.com.gamex.controlegamex.controller.ClienteController" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Cliente" %>  
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%
	String nomeBusca = request.getParameter("busca");
	
	if (nomeBusca == null){
		nomeBusca = "";
	}
	
	%>
	<a href="cadastrarcurso.jsp">Cadastrar Cliente</a>
	
	<form method="post" action="testeLista.jsp">
	<p>
		<input type="text" name="busca" value="<%= nomeBusca %>" />
		<input type="submit" value="Buscar" />
	</p>
	</form>
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Ações</th>
			</tr>
		</thead>
		<tbody>
	<% 
		ClienteController controller = new ClienteController();
		ArrayList<Cliente> lista = controller.Listar(nomeBusca);
		for (Cliente c: lista) {
			System.out.println(c.getId());
	%>	
			<tr>
				<td><%= c.getNome() %></td>
				<td><%= c.getEmail() %></td>
				
				<td>
					<a href="IniciarAlterarCliente?id=<%= c.getId() %>">Alterar</a> 
					<a href="ExcluirCliente?id=<%= c.getId() %>"
					   onclick="return confirm('Deseja excluir esse registro?')">
					   Excluir
					</a> 

				</td>
			</tr>
	
	<% } %>
		</tbody>
	</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>