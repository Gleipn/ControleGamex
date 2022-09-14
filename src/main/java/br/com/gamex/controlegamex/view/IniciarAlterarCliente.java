package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.model.dao.ClienteDao;
import br.com.gamex.controlegamex.model.entidade.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IniciarAlterarCliente
 */
public class IniciarAlterarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarAlterarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("InputIdentificador"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ClienteDao cdao = new ClienteDao();
		
		Cliente c = cdao.Localizar(id);
		
		request.setAttribute("cliente", c);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
		
		//response.sendRedirect("editar_curso.jsp");
	}

}
