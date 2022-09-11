package br.com.gamex.controlegamex.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gamex.controlegamex.entidade.Compra;
import br.com.gamex.controlegamex.entidade.Status;
import br.com.gamex.controlegamex.entidade.Venda;

public class StatusDao extends Conexao {

	public boolean Cadastrar(Status s) {
		boolean ok = true;
		
		String sql = "insert into status (status, venda_id) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, s.getStatus());
			ps.setLong(2, s.getVenda().getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}

	public List<Status> Listar(){
		List<Status> lista = new ArrayList<Status>();
		
		String sql = "select s.*, v.criado_em as data_venda from status s "
				+ "inner join venda v on v.id = c.venda_id "
				+ "order by s.criado_em";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			Status s = null;
			Venda v = null;
			
			while(rs.next()) {
				
				s = new Status();
				s.setId(rs.getLong("id_status"));
				s.setCriado_em(rs.getString("criado_em"));
				
				v = new Venda();
				v.setId(rs.getLong("venda_id"));
				v.setCriado_em(rs.getString("data_venda"));
				s.setVenda(v);
				
				lista.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
}
