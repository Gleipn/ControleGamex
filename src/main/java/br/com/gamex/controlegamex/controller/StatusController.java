package br.com.gamex.controlegamex.controller;

import java.util.ArrayList;

import br.com.gamex.controlegamex.model.dao.StatusDao;
import br.com.gamex.controlegamex.model.entidade.Status;

public class StatusController {

	StatusDao dao = new StatusDao();
	
	public void Cadastrar(Status s) {
		dao.Cadastrar(s);
	}
	
	public ArrayList<Status> Listar() {
		return dao.Listar();
	}
	
}
