package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Cliente;
import br.com.gamex.controlegamex.model.entidade.Compra;
import br.com.gamex.controlegamex.model.entidade.Fornecedor;
import br.com.gamex.controlegamex.model.entidade.Jogo;
import br.com.gamex.controlegamex.model.entidade.Venda;

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

	public ArrayList<Compra> Listar(long limite){
		ArrayList<Compra> lista = new ArrayList<Compra>();
		
		String sql = "select c.*, f.nome_fornecedor as fornecedor_nome, j.nome_jogo as jogo_nome from compra c "
				+ "inner join fornecedor f on f.id_fornecedor = c.fornecedor_id "
				+ "inner join jogo j on j.id_jogo = c.jogo_id "
				+ "order by c.criado_em desc limit ?";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, limite);
			
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
	
	public Compra Localizar(long id) {
		Compra c = null;
		
		String sql = "select * from compra where id_compra = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Fornecedor f = null;
			Jogo j = null;
			
			if(rs.next()) {
				c = new Compra();
				c.setId(rs.getLong("id_venda"));
				c.setCriado_em(rs.getString("criado_em"));
				
				f = new Fornecedor();
				f.setId(rs.getLong("fornecedor_id"));
				f.setCnpj(rs.getString("fornecedor_cpf"));
				f.setNome(rs.getString("fornecedor_nome"));
				f.setEndereco(rs.getString("fornecedor_endereco"));
				f.setEmail(rs.getString("fornecedor_email"));
				c.setFornecedor(f);
				
				j = new Jogo();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				j.setValorCompra(rs.getDouble("jogo_valorcompra"));
				j.setValorVenda(rs.getDouble("jogo_valorvenda"));
				j.setCategoria(rs.getString("jogo_categoria"));
				c.setJogo(j);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return c;
	}
	
}
