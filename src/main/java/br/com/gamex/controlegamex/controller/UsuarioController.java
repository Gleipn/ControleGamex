package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.UsuarioDao;
import br.com.gamex.controlegamex.model.entidade.Usuario;

public class UsuarioController {

	UsuarioDao dao = new UsuarioDao();
	
	public void Cadastrar(Usuario u) {
		dao.Cadastrar(u);
	}
	
	public void Alterar(Usuario u) {
		dao.Alterar(u);
	}
	
	public ArrayList<Usuario> Listar(String nome) {
		return dao.Listar(nome);
	}
	
	public Usuario Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public void Excluir(Usuario u) {
		dao.Excluir(u);
	}
	
}
