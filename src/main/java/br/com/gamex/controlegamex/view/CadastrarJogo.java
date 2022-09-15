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
 * Servlet implementation class CadastrarJogos
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
		String valor = request.getParameter("inputValor");
		String estoque = request.getParameter("inputEstoque");
		
		Jogo j = new Jogo();
		j.setNome(nome);
		j.setCategoria(categoria);
		j.setDesenvolvedor(desenvolvedor);
		j.setValor(valor);
		j.setEstoque(estoque);
		
		JogoController controller = new JogoController();
		controller.Cadastrar(j);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
