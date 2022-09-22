package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.JogoDao;
import br.com.gamex.controlegamex.model.entidade.Jogo;

public class JogoController {

	JogoDao dao = new JogoDao();
	
	public void Cadastrar(Jogo j) {
		dao.Cadastrar(j);
	}
	
	public void RealizarCompra(Jogo j) {
		dao.RealizarCompra(j);
	}
	public void RealizarVenda(Jogo j) {
		dao.RealizarVenda(j);
	}
	public void Excluir(Jogo j) {
		dao.Excluir(j);
	}
	
	public ArrayList<Jogo> Listar(long limite) {
		return dao.Listar(limite);
	}
	public ArrayList<Jogo> ListarEstoqueBaixo(long limite) {
		return dao.ListarEstoqueBaixo(limite);
	}
	
	public Jogo Localizar(long id) {
		return dao.Localizar(id);
	}
	
}
