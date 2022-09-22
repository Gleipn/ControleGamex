<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    	if (session.getAttribute("usuarioLogado") == null){
    		RequestDispatcher rd = request.getRequestDispatcher("acesso-restrito.jsp");
    		rd.forward(request, response);
    	}
    
    %>