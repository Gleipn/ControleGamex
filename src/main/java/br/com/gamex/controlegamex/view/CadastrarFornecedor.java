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
 * Servlet implementation class CadastrarFornecedor
 */
public class CadastrarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarFornecedor() {
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
		
		Fornecedor f = new Fornecedor();
		f.setCnpj(cnpj);
		f.setNome(nome);
		f.setEndereco(endereco);
		f.setEmail(email);
		
		String destino = "";
		FornecedorController controller = new FornecedorController();
		try {
			controller.Cadastrar(f);
			destino = "fornecedores.jsp";
		} catch(Exception e) {
			request.setAttribute("erro", "Não foi possivel realizar o cadastro.");
			destino = "cadastro-fornecedor.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
