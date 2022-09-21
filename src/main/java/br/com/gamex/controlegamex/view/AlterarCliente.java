package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.ClienteController;
import br.com.gamex.controlegamex.model.entidade.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarCliente
 */
public class AlterarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarCliente() {
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
		
		String cpf = request.getParameter("inputCpf");
		String nome = request.getParameter("inputNome");
		String endereco = request.getParameter("inputEndereco");
		String telefone = request.getParameter("inputTelefone");
		String email = request.getParameter("inputEmail");
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("inputId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Cliente c = new Cliente();
		c.setId(id);
		c.setCpf(cpf);
		c.setNome(nome);
		c.setEndereco(endereco);
		c.setTelefone(telefone);
		c.setEmail(email);
		
		ClienteController controller = new ClienteController();
		controller.Alterar(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("testeLista.jsp");
		rd.forward(request, response);
	}

}
