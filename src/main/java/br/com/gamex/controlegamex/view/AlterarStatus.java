package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.StatusController;
import br.com.gamex.controlegamex.model.entidade.Status;
import br.com.gamex.controlegamex.model.entidade.Venda;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarStatus
 */
public class AlterarStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarStatus() {
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
		
		String situacao = request.getParameter("inputSituacao");
		String id_venda = request.getParameter("inputVenda");
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("InputIdentificador"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Venda v = new Venda();
		try {
			v.setId(Long.parseLong(id_venda));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Status s = new Status();
		s.setSituacao(situacao);
		s.setVenda(v);
		
		StatusController controller = new StatusController();
		controller.Alterar(s);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}