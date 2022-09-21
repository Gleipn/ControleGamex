package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.FornecedorDao;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;

public class FornecedorController {

	FornecedorDao dao = new FornecedorDao();
	
	public void Cadastrar(Fornecedor f) {
		dao.Cadastrar(f);
	}
	
	public void Alterar(Fornecedor f) {
		dao.Alterar(f);
	}
	
	public void Excluir(Fornecedor f) {
		dao.Excluir(f);
	}
	
	public Fornecedor Localizar(long id) {
		return dao.Localizar(id);
	}
	
	public ArrayList<Fornecedor> Listar(long limite) {
		return dao.Listar(limite);
	}
	
}
