package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Compra;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;
import br.com.gamex.controlegamex.model.entidade.Jogo;

public class CompraDao extends Conexao {
	
	public void Cadastrar(Compra c) {
		
		String sql = "insert into compra (fornecedor_id, jogo_id) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, c.getFornecedor().getId());
			ps.setLong(2, c.getJogo().getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}

	public ArrayList<Compra> Listar(){
		ArrayList<Compra> lista = new ArrayList<Compra>();
		
		String sql = "select c.*, f.nome as fornecedor_nome, j.nome as jogo_nome from compra c "
				+ "inner join fornecedor f on f.id = c.fornecedor_id "
				+ "inner join jogos j on j.id = c.jogo_id "
				+ "order by c.criado_em";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			Compra c = null;
			Fornecedor f = null;
			Jogo j = null;
			
			while(rs.next()) {
				
				
				c = new Compra();
				c.setId(rs.getLong("id_compra"));
				c.setCriado_em(rs.getString("criado_em"));
				
				f = new Fornecedor();
				f.setId(rs.getLong("fornecedor_id"));
				f.setNome(rs.getString("fornecedor_nome"));
				c.setFornecedor(f);
				
				j = new Jogo();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				c.setJogo(j);
				
				lista.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
}
