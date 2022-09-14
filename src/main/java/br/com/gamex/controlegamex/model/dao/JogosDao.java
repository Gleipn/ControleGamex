package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Jogos;

public class JogosDao extends Conexao {
	
	public boolean Cadastrar(Jogos j) {
		boolean ok = true;
		
		String sql = "insert into jogos (nome, categoria, desenvolvedor, valor, estoque) "
				+ "values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, j.getNome());
			ps.setString(2, j.getCategoria());
			ps.setString(3, j.getDesenvolvedor());
			ps.setString(4, j.getValor());
			ps.setString(5, j.getEstoque());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public ArrayList<Jogos> Listar(String nomeBusca) {
		ArrayList<Jogos> lista = new ArrayList<Jogos>();
		
		String sql = "select * from jogos where nome like ? order by nome";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Jogos j;
			while(rs.next()) {
				j = new Jogos();
				j.setNome(rs.getString("nome"));
				j.setCategoria(rs.getString("categoria"));
				j.setDesenvolvedor(rs.getString("desenvolvedor"));
				j.setValor(rs.getString("valor"));
				j.setEstoque(rs.getString("estoque"));
				
				lista.add(j);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Jogos Localizar(long id) {
		Jogos j = null;
		
		String sql = "select * from jogos where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				j = new Jogos();
				j.setNome(rs.getString("nome"));
				j.setCategoria(rs.getString("categoria"));
				j.setDesenvolvedor(rs.getString("desenvolvedor"));
				j.setValor(rs.getString("valor"));
				j.setEstoque(rs.getString("estoque"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return j;
		
	}
	
	public boolean Alterar(Jogos j) {
		boolean ok = true;
		
		String sql = "update jogos set nome = ?, categoria = ?, desenvolvedor = ?, valor = ?, "
				+ "estoque = ? where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, j.getNome());
			ps.setString(2, j.getCategoria());
			ps.setString(3, j.getDesenvolvedor());
			ps.setString(4, j.getValor());
			ps.setString(5, j.getEstoque());
			ps.setLong(6, j.getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public boolean Excluir(Jogos j) {
		boolean ok  = true;
		
		String sql = "delete from jogos where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, j.getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}
	
}
