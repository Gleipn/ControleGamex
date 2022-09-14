package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.CompraDao;
import br.com.gamex.controlegamex.model.entidade.Compra;

public class CompraController {

	CompraDao dao = new CompraDao();
	
	public void Cadastrar(Compra c) {
		dao.Cadastrar(c);
	}
	
	public ArrayList<Compra> Listar() {
		return dao.Listar();
	}
	
}
