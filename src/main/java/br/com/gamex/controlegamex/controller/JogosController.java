package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.JogosDao;
import br.com.gamex.controlegamex.model.entidade.Jogos;

public class JogosController {

	JogosDao dao = new JogosDao();
	
	public void Cadastrar(Jogos j) {
		dao.Cadastrar(j);
	}
	
	public void Alterar(Jogos j) {
		dao.Alterar(j);
	}
	
	public ArrayList<Jogos> Listar(String nome) {
		return dao.Listar(nome);
	}
	
	public Jogos Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public void Excluir(Jogos j) {
		dao.Excluir(j);
	}
	
}
