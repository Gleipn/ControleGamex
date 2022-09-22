package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Cliente;
import br.com.gamex.controlegamex.model.entidade.Jogo;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class VendaDao extends Conexao {
	
	public void Cadastrar(Venda v) {
		
		String sql = "insert into venda (cliente_id, jogo_id) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, v.getCliente().getId());
			ps.setLong(2, v.getJogo().getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}

	public ArrayList<Venda> Listar(long limite){
		ArrayList<Venda> lista = new ArrayList<Venda>();
		
		String sql = "select v.*, c.nome_cliente as cliente_nome, j.nome_jogo as jogo_nome from venda v "
				+ "inner join cliente c on c.id_cliente = v.cliente_id "
				+ "inner join jogo j on j.id_jogo = v.jogo_id "
				+ "order by v.criado_em desc limit ?";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, limite);
			
			ResultSet rs = ps.executeQuery();
			
			Venda v = null;
			Cliente c = null;
			Jogo j = null;
			
			while(rs.next()) {
				
				
				v = new Venda();
				v.setId(rs.getLong("id_venda"));
				v.setCriado_em(rs.getString("criado_em"));
				
				c = new Cliente();
				c.setId(rs.getLong("cliente_id"));
				c.setNome(rs.getString("cliente_nome"));
				v.setCliente(c);
				
				j = new Jogo();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				v.setJogo(j);
				
				lista.add(v);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
	public ArrayList<Venda> ListarPorCliente(long idcliente, long limite){
		ArrayList<Venda> lista = new ArrayList<Venda>();
		
		String sql = "select v.*, c.nome_cliente as cliente_nome, j.nome_jogo as jogo_nome from venda v "
				+ "inner join cliente c on c.id_cliente = v.cliente_id "
				+ "inner join jogo j on j.id_jogo = v.jogo_id "
				+ "where v.cliente_id = ? order by v.criado_em desc limit ?";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, idcliente);
			ps.setLong(2, limite);
			
			ResultSet rs = ps.executeQuery();
			
			Venda v = null;
			Cliente c = null;
			Jogo j = null;
			
			while(rs.next()) {
				
				
				v = new Venda();
				v.setId(rs.getLong("id_venda"));
				v.setCriado_em(rs.getString("criado_em"));
				
				c = new Cliente();
				c.setId(rs.getLong("cliente_id"));
				c.setNome(rs.getString("cliente_nome"));
				v.setCliente(c);
				
				j = new Jogo();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				v.setJogo(j);
				
				lista.add(v);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
	public Venda Localizar(long id) {
		Venda v = null;
		
		String sql = "select * from venda where id_venda = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Cliente c = null;
			Jogo j = null;
			
			if(rs.next()) {
				v = new Venda();
				v.setId(rs.getLong("id_venda"));
				v.setCriado_em(rs.getString("criado_em"));
				
				c = new Cliente();
				c.setId(rs.getLong("cliente_id"));
				c.setCpf(rs.getString("cliente_cpf"));
				c.setNome(rs.getString("cliente_nome"));
				c.setEndereco(rs.getString("cliente_endereco"));
				c.setTelefone(rs.getString("cliente_telefone"));
				c.setEmail(rs.getString("cliente_email"));
				v.setCliente(c);
				
				j = new Jogo();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				j.setValorCompra(rs.getDouble("jogo_valorcompra"));
				j.setValorVenda(rs.getDouble("jogo_valorvenda"));
				j.setCategoria(rs.getString("jogo_categoria"));
				v.setJogo(j);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return v;
	}
}
