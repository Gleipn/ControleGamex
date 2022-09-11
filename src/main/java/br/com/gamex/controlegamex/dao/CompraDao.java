package br.com.gamex.controlegamex.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gamex.controlegamex.entidade.Compra;
import br.com.gamex.controlegamex.entidade.Fornecedor;
import br.com.gamex.controlegamex.entidade.Jogos;

public class CompraDao extends Conexao {
	
	public boolean Cadastrar(Compra c) {
		boolean ok = true;
		
		String sql = "insert into compra (nota_fiscal, fornecedor_id, jogo_id) "
				+ "values (?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, c.getNota_fiscal());
			ps.setLong(2, c.getFornecedor().getId());
			ps.setLong(3, c.getJogo().getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}

	public List<Compra> Listar(){
		List<Compra> lista = new ArrayList<Compra>();
		
		String sql = "select c.*, f.nome as fornecedor, j.nome as jogo from compra c "
				+ "inner join fornecedor f on f.id = c.fornecedor_id "
				+ "inner join jogos j on j.id = c.jogo_id "
				+ "order by c.criado_em";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			Compra c = null;
			Fornecedor f = null;
			Jogos j = null;
			
			while(rs.next()) {
				
				
				c = new Compra();
				c.setId(rs.getLong("id_compra"));
				c.setNota_fiscal(rs.getLong("nota_fiscal"));
				c.setCriado_em(rs.getString("data_compra"));
				
				f = new Fornecedor();
				f.setId(rs.getLong("fornecedor_id"));
				f.setNome(rs.getString("fornecedor_nome"));
				c.setFornecedor(f);
				
				j = new Jogos();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				c.setJogo(j);
				
				lista.add(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
}
