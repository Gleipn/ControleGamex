package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.JogoDao;
import br.com.gamex.controlegamex.model.entidade.Jogo;

public class JogoController {

	JogoDao dao = new JogoDao();
	
	public void Cadastrar(Jogo j) {
		dao.Cadastrar(j);
	}
	
	public void Alterar(Jogo j) {
		dao.Alterar(j);
	}
	
	public ArrayList<Jogo> Listar(String nomeBusca) {
		return dao.Listar(nomeBusca);
	}
	
	public Jogo Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public void Excluir(Jogo j) {
		dao.Excluir(j);
	}
	
}
