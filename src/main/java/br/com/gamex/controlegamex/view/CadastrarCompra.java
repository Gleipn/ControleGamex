package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.CompraController;
import br.com.gamex.controlegamex.controller.JogoController;
import br.com.gamex.controlegamex.model.entidade.Compra;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;
import br.com.gamex.controlegamex.model.entidade.Jogo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarCompra
 */
public class CadastrarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarCompra() {
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
		
		String strId_fornecedor = request.getParameter("inputFornecedor");
		String strId_jogo = request.getParameter("inputJogo");
		
		String strValorCompra = request.getParameter("inputValorCompra");
		String strValorVenda = request.getParameter("inputValorVenda");
		String strEstoque = request.getParameter("inputEstoque");
		
		long idFornecedor = 0;
		long idJogo = 0;
		try {
			idFornecedor = Long.parseLong(strId_fornecedor);
			idJogo = Long.parseLong(strId_jogo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		double valorcompra = 0.0;
		double valorvenda = 0.0;
		long estoque = 0;
		
		try {
			valorcompra = Double.parseDouble(strValorCompra);
			valorvenda = Double.parseDouble(strValorVenda);
			estoque = Long.parseLong(strEstoque);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Jogo j = new Jogo();
		j.setId(idJogo);
		j.setValorCompra(valorcompra);
		j.setValorVenda(valorvenda);
		j.setEstoque(estoque);
		
		JogoController controller = new JogoController();
		controller.RealizarCompra(j);
		
		Fornecedor f = new Fornecedor();
		f.setId(idFornecedor);
		
		Compra c = new Compra();
		c.setFornecedor(f);
		c.setJogo(j);
		
		CompraController cc = new CompraController();
		cc.Cadastrar(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("jogos.jsp");
		rd.forward(request, response);
	}

}
