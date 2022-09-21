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
 * Servlet implementation class CadastrarUsuario
 */
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuario() {
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
		String senha = request.getParameter("inputSenha");
		String senhaRepetida = request.getParameter("inputSenhaRepetida");
		
		String destino = "";
		
		if(senha.equals(senhaRepetida)) {
			Usuario u = new Usuario();
			u.setNome(nome);
			u.setEmail(email);
			u.setSenha(senha);
			
			UsuarioController controller = new UsuarioController();
			
			try {
			controller.Cadastrar(u);
			destino = "usuarios.jsp";
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("erro", "Não foi possivel realizar o cadastro.");
				destino = "cadastro-usuario.jsp";
			}
		} else {
			request.setAttribute("erro", "senhas não conferem");
			destino = "cadastro-usuario.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
