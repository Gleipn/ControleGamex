package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.model.dao.ClienteDao;
import br.com.gamex.controlegamex.model.entidade.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluirCliente
 */
public class ExcluirCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirCliente() {
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
			id = Long.parseLong(request.getParameter("inputIdentificador"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Cliente c = new Cliente();
		c.setId(id);
		
		ClienteDao cdao = new ClienteDao();
		cdao.Excluir(c);
		
		response.sendRedirect("");
	}

}
