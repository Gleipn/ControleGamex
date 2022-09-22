package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.JogoController;
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
 * Servlet implementation class CadastrarVenda
 */
public class CadastrarVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarVenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String strId_jogo = request.getParameter("inputJogo");
		String strId_cliente = request.getParameter("inputCliente");
		
		String strEstoque = request.getParameter("inputEstoque");
		
		long idCliente = 0;
		long idJogo = 0;
		try {
			idJogo = Long.parseLong(strId_jogo);
			idCliente = Long.parseLong(strId_cliente);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		long estoque = 0;
		
		try {
			estoque = Long.parseLong(strEstoque);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Jogo j = new Jogo();
		j.setId(idJogo);
		j.setEstoque(estoque);
		
		JogoController controller = new JogoController();
		controller.RealizarVenda(j);
		
		Cliente c = new Cliente();
		c.setId(idCliente);
		
		Venda v = new Venda();
		v.setCliente(c);
		v.setJogo(j);
		
		VendaController vc = new VendaController();
		vc.Cadastrar(v);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
