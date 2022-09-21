package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.CompraDao;
import br.com.gamex.controlegamex.model.entidade.Compra;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;
import br.com.gamex.controlegamex.model.entidade.Usuario;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class CompraController {

	CompraDao dao = new CompraDao();
	
	public void Cadastrar(Compra c) {
		dao.Cadastrar(c);
	}
	
	public ArrayList<Compra> Listar(long limite) {
		return dao.Listar(limite);
	}
	
	public Compra Localizar(long id) {
		return dao.Localizar(id);
	}
}
