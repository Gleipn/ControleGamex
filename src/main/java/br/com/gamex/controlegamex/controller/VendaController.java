package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.VendaDao;
import br.com.gamex.controlegamex.model.entidade.Cliente;
import br.com.gamex.controlegamex.model.entidade.Usuario;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class VendaController {

	VendaDao dao = new VendaDao();
	
	public void Cadastrar(Venda v) {
		dao.Cadastrar(v);
	}
	
	public ArrayList<Venda> Listar(long limite) {
		return dao.Listar(limite);
	}
	
	public ArrayList<Venda> ListarPorCliente(long idcliente, long limite) {
		return dao.ListarPorCliente(idcliente, limite);
	}
	
	public Venda Localizar(long id) {
		return dao.Localizar(id);
	}
	
}
