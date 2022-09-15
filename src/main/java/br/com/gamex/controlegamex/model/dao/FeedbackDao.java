package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Feedback;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class FeedbackDao extends Conexao {

	public void Cadastrar(Feedback f) {
		
		String sql = "insert into feedback (feedback, venda_id) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, f.getFeedback());
			ps.setLong(2, f.getVenda().getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}

	public ArrayList<Feedback> Listar(){
		ArrayList<Feedback> lista = new ArrayList<Feedback>();
		
		String sql = "select f.*, v.jogo as jogo_nome from feedback f "
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
				f.setCriado_em(rs.getString("criado_em"));
				
				v = new Venda();
				v.setId(rs.getLong("venda_id"));
				v.setCriado_em(rs.getString("criado_em"));
				f.setVenda(v);
				
				lista.add(f);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
}
