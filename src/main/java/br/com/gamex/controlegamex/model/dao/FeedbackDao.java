package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Feedback;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class FeedbackDao extends Conexao {

	public boolean Cadastrar(Feedback f) {
		boolean ok = true;
		
		String sql = "insert into feedback (feedback, venda_id) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, f.getFeedback());
			ps.setLong(2, f.getVenda().getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}

	public ArrayList<Feedback> Listar(){
		ArrayList<Feedback> lista = new ArrayList<Feedback>();
		
		String sql = "select f.*, v.jogo as jogo from feedback f "
				+ "inner join venda v on v.id = f.venda_id "
				+ "order by f.criado_em";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			Feedback f = null;
			Venda v = null;
			
			while(rs.next()) {
				
				
				f = new Feedback();
				
				f.setId(rs.getLong("id_feedback"));
				f.setFeedback(rs.getString("feedback"));
				f.setCriado_em(rs.getString("data_feedback"));
				
				v = new Venda();
				v.setId(rs.getLong("venda_id"));
				v.setCriado_em(rs.getString("data_venda"));
				f.setVenda(v);
				
				lista.add(f);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
}
