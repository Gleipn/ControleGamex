package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.ClienteDao;
import br.com.gamex.controlegamex.model.entidade.Cliente;

public class ClienteController {

	ClienteDao dao = new ClienteDao();
	
	public void Cadastrar(Cliente c) {
		dao.Cadastrar(c);
	}
	
	public void Alterar(Cliente c) {
		dao.Alterar(c);
	}
	
	public ArrayList<Cliente> Listar(String nomeBusca) {
		return dao.Listar(nomeBusca);
	}
	
	public Cliente Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public void Excluir(Cliente c) {
		dao.Excluir(c);
	}
	
}
