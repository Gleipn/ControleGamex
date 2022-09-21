package br.com.gamex.controlegamex.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.UsuarioController;
import br.com.gamex.controlegamex.model.entidade.Usuario;

/**
 * Servlet implementation class LoginUsuario
 */
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuario() {
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
		
		String email = request.getParameter("inputEmail");
		String senha = request.getParameter("inputSenha");
		
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setSenha(senha);
		
		UsuarioController controller = new UsuarioController();
		Usuario usr = controller.Logar(u);
		
		String destino = "";
		if (usr != null) {
			HttpSession sessao = request.getSession();
			
			sessao.setAttribute("usuarioLogado", usr);
			destino = "sistema-interno.jsp";
		} else {
			request.setAttribute("error", "Verifique suas credenciais");
			destino = "acesso-restrito.jsp";
		}
		
		response.sendRedirect(destino);
	}

}
