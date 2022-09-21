package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.CompraController;
import br.com.gamex.controlegamex.model.entidade.Compra;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;
import br.com.gamex.controlegamex.model.entidade.Jogo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarCompra
 */
public class AlterarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarCompra() {
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
		
		String id_fornecedor = request.getParameter("inputFornecedor");
		String id_jogo = request.getParameter("inputJogo");
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("InputIdentificador"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Fornecedor f = new Fornecedor();
		try {
			f.setId(Long.parseLong(id_fornecedor));
		} catch(Exception e) {
			e.printStackTrace();
		}
		Jogo j = new Jogo();
		try {
			j.setId(Long.parseLong(id_jogo));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Compra c = new Compra();
		c.setFornecedor(f);
		c.setJogo(j);
		
		CompraController controller = new CompraController();
		controller.Alterar(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
