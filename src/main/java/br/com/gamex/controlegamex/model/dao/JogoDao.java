package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Jogo;

public class JogoDao extends Conexao {
	
	public void Cadastrar(Jogo j) {
		
		String sql = "insert into jogo (nome_jogo, categoria_jogo, desenvolvedor_jogo) "
				+ "values (?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, j.getNome());
			ps.setString(2, j.getCategoria());
			ps.setString(3, j.getDesenvolvedor());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public ArrayList<Jogo> Listar(long limite) {
		ArrayList<Jogo> lista = new ArrayList<Jogo>();
		
		String sql = "select * from jogo order by criado_em desc limit ? ";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, limite);
			
			ResultSet rs = ps.executeQuery();
			
			Jogo j;
			while(rs.next()) {
				j = new Jogo();
				j.setId(rs.getLong("id_jogo"));
				j.setNome(rs.getString("nome_jogo"));
				j.setCategoria(rs.getString("categoria_jogo"));
				j.setDesenvolvedor(rs.getString("desenvolvedor_jogo"));
				j.setValorCompra(rs.getDouble("valorcompra_jogo"));
				j.setValorVenda(rs.getDouble("valorvenda_jogo"));
				j.setEstoque(rs.getLong("estoque_jogo"));
				j.setImagem(rs.getString("imagem_jogo"));
				j.setCriado_em(rs.getString("criado_em"));
				
				lista.add(j);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public ArrayList<Jogo> ListarEstoqueBaixo(long limite) {
		ArrayList<Jogo> lista = new ArrayList<Jogo>();
		
		String sql = "select * from jogo where estoque_jogo between 1 and 10 order by estoque_jogo limit ? ";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, limite);
			
			ResultSet rs = ps.executeQuery();
			
			Jogo j;
			while(rs.next()) {
				j = new Jogo();
				j.setId(rs.getLong("id_jogo"));
				j.setNome(rs.getString("nome_jogo"));
				j.setCategoria(rs.getString("categoria_jogo"));
				j.setDesenvolvedor(rs.getString("desenvolvedor_jogo"));
				j.setValorCompra(rs.getDouble("valorcompra_jogo"));
				j.setValorVenda(rs.getDouble("valorvenda_jogo"));
				j.setEstoque(rs.getLong("estoque_jogo"));
				j.setImagem(rs.getString("imagem_jogo"));
				j.setCriado_em(rs.getString("criado_em"));
				
				lista.add(j);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Jogo Localizar(long id) {
		Jogo j = null;
		
		String sql = "select * from jogo where id_jogo = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				j = new Jogo();
				j.setId(rs.getLong("id_jogo"));
				j.setNome(rs.getString("nome_jogo"));
				j.setCategoria(rs.getString("categoria_jogo"));
				j.setDesenvolvedor(rs.getString("desenvolvedor_jogo"));
				j.setValorCompra(rs.getDouble("valorcompra_jogo"));
				j.setValorVenda(rs.getDouble("valorvenda_jogo"));
				j.setEstoque(rs.getLong("estoque_jogo"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return j;
		
	}
	
	public void RealizarCompra(Jogo j) {
		
		String sql = "update jogo set valorcompra_jogo = ?, valorvenda_jogo = ?, estoque_jogo =  estoque_jogo "
				+ "+ ? where id_jogo = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setDouble(1, j.getValorCompra());
			ps.setDouble(2, j.getValorVenda());
			ps.setLong(3, j.getEstoque());
			ps.setLong(4, j.getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public void RealizarVenda(Jogo j) {
		
		String sql = "update jogo set estoque_jogo = estoque_jogo - ? where id_jogo = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, j.getEstoque());
			ps.setLong(2, j.getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public void Excluir(Jogo j) {
		
		String sql = "delete from jogo where id_jogo = ? ";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, j.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
}
