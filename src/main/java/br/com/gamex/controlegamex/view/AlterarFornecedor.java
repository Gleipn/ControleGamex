package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.FornecedorController;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarFornecedor
 */
public class AlterarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarFornecedor() {
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
		
		String cnpj = request.getParameter("inputCnpj");
		String nome = request.getParameter("inputNome");
		String endereco = request.getParameter("inputEndereco");
		String email = request.getParameter("inputEmail");
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("inputId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Fornecedor f = new Fornecedor();
		f.setId(id);
		f.setCnpj(cnpj);
		f.setNome(nome);
		f.setEndereco(endereco);
		f.setEmail(email);
		
		FornecedorController controller = new FornecedorController();
		controller.Alterar(f);
		
		RequestDispatcher rd = request.getRequestDispatcher("fornecedores.jsp");
		rd.forward(request, response);
	}

}
