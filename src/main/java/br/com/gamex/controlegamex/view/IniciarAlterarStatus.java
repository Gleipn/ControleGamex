package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.StatusController;
import br.com.gamex.controlegamex.model.entidade.Status;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IniciarAlterarStatus
 */
public class IniciarAlterarStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarAlterarStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StatusController controller = new StatusController();
		Status s = controller.Localizar(id);
		
		request.setAttribute("status", s);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
