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
	
	public void Excluir(Usuario u) {
		dao.Excluir(u);
	}
	
	public ArrayList<Usuario> Listar(long limite) {
		return dao.Listar(limite);
	}
	
	public Usuario Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public Usuario Logar(Usuario u) {
		return dao.Logar(u);
	}
	
}
