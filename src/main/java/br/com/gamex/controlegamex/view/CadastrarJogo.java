package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.JogoController;
import br.com.gamex.controlegamex.model.entidade.Jogo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarJogo
 */
public class CadastrarJogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarJogo() {
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
		
		String nome = request.getParameter("inputNome");
		String categoria = request.getParameter("inputCategoria");
		String desenvolvedor = request.getParameter("inputDesenvolvedor");
		
		double valorcompra = 0.00;
		double valorvenda = 0.00;
		long estoque = 0;
		
		Jogo j = new Jogo();
		j.setNome(nome);
		j.setCategoria(categoria);
		j.setDesenvolvedor(desenvolvedor);
		j.setValorCompra(valorcompra);
		j.setValorVenda(valorvenda);
		j.setEstoque(estoque);
		
		JogoController controller = new JogoController();
		String destino = "";
		
		try {
			controller.Cadastrar(j);
			destino = "jogos.jsp";
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("erro", "Não foi possivel realizar o cadastro.");
				destino = "cadastro-jogo.jsp";
			}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
