package br.com.gamex.controlegamex.view;

import java.io.IOException;

import br.com.gamex.controlegamex.controller.FeedbackController;
import br.com.gamex.controlegamex.model.entidade.Feedback;
import br.com.gamex.controlegamex.model.entidade.Venda;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarFeedback
 */
public class CadastrarFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarFeedback() {
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
		
		String comentario = request.getParameter("inputComentario");
		String id_venda = request.getParameter("inputVenda");
		
		Venda v = new Venda();
		try {
			v.setId(Long.parseLong(id_venda));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Feedback f = new Feedback();
		f.setComentario(comentario);
		f.setVenda(v);
		
		FeedbackController controller = new FeedbackController();
		controller.Cadastrar(f);
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
		
	}

}
