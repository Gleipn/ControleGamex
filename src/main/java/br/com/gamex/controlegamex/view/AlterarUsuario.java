package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.UsuarioController;
import br.com.gamex.controlegamex.model.entidade.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarUsuario
 */
public class AlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarUsuario() {
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
		String email = request.getParameter("inputEmail");
		
		long id = 0;
		try {
			id = Long.parseLong(request.getParameter("inputId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Usuario u = new Usuario();
		u.setId(id);
		u.setNome(nome);
		u.setEmail(email);
		
		UsuarioController controller = new UsuarioController();
		controller.Alterar(u);
		
		RequestDispatcher rd = request.getRequestDispatcher("usuarios.jsp");
		rd.forward(request, response);
	}

}
