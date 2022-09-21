package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.VendaController;
import br.com.gamex.controlegamex.model.entidade.Cliente;
import br.com.gamex.controlegamex.model.entidade.Jogo;
import br.com.gamex.controlegamex.model.entidade.Venda;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarVenda
 */
public class AlterarVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarVenda() {
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
		
		String id_cliente = request.getParameter("inputCliente");
		String id_jogo = request.getParameter("inputJogo");
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("InputIdentificador"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Cliente c = new Cliente();
		try {
			c.setId(Long.parseLong(id_cliente));
		} catch(Exception e) {
			e.printStackTrace();
		}
		Jogo j = new Jogo();
		try {
			j.setId(Long.parseLong(id_jogo));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Venda v = new Venda();
		v.setCliente(c);
		v.setJogo(j);
		
		VendaController controller = new VendaController();
		controller.Alterar(v);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
