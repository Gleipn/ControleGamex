package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.VendaDao;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class VendaController {

	VendaDao dao = new VendaDao();
	
	public void Cadastrar(Venda v) {
		dao.Cadastrar(v);
	}
	
	public ArrayList<Venda> Listar() {
		return dao.Listar();
	}
	
}
