package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.FeedbackDao;
import br.com.gamex.controlegamex.model.entidade.Feedback;

public class FeedbackController {

	FeedbackDao dao = new FeedbackDao();
	
	public void Cadastrar(Feedback f) {
		dao.Cadastrar(f);
	}
	
	public void Alterar(Feedback f) {
		dao.Alterar(f);
	}
	
	public ArrayList<Feedback> Listar(long limite) {
		return dao.Listar(limite);
	}
	
}
