package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.ClienteDao;
import br.com.gamex.controlegamex.model.entidade.Cliente;
import br.com.gamex.controlegamex.model.entidade.Usuario;

public class ClienteController {

	ClienteDao dao = new ClienteDao();
	
	public void Cadastrar(Cliente c) {
		dao.Cadastrar(c);
	}
	
	public void Alterar(Cliente c) {
		dao.Alterar(c);
	}
	
	public void Excluir(Cliente c) {
		dao.Excluir(c);
	}
	
	public Cliente Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public ArrayList<Cliente> Listar(long limite) {
		return dao.Listar(limite);
	}
	
}
