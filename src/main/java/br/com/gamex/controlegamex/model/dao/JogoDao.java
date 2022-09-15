package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Jogo;

public class JogoDao extends Conexao {
	
	public void Cadastrar(Jogo j) {
		
		String sql = "insert into jogos (nome_jogo, categoria_jogo, desenvolvedor_jogo, "
				+ "valor_jogo, estoque_jogo) "
				+ "values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, j.getNome());
			ps.setString(2, j.getCategoria());
			ps.setString(3, j.getDesenvolvedor());
			ps.setString(4, j.getValor());
			ps.setString(5, j.getEstoque());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public ArrayList<Jogo> Listar(String nomeBusca) {
		ArrayList<Jogo> lista = new ArrayList<Jogo>();
		
		String sql = "select * from jogos where nome_jogo like ? order by nome_jogo";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Jogo j;
			while(rs.next()) {
				j = new Jogo();
				j.setNome(rs.getString("nome_jogo"));
				j.setCategoria(rs.getString("categoria_jogo"));
				j.setDesenvolvedor(rs.getString("desenvolvedor_jogo"));
				j.setValor(rs.getString("valor_jogo"));
				j.setEstoque(rs.getString("estoque_jogo"));
				
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
		
		String sql = "select * from jogos where id_jogo = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				j = new Jogo();
				j.setNome(rs.getString("nome_jogo"));
				j.setCategoria(rs.getString("categoria_jogo"));
				j.setDesenvolvedor(rs.getString("desenvolvedor_jogo"));
				j.setValor(rs.getString("valor_jogo"));
				j.setEstoque(rs.getString("estoque_jogo"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return j;
		
	}
	
	public void Alterar(Jogo j) {
		
		String sql = "update jogos set nome_jogo = ?, categoria_jogo = ?, "
				+ "desenvolvedor_jogo = ?, valor_jogo = ?, "
				+ "estoque_jogo = ? where id_jogo = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, j.getNome());
			ps.setString(2, j.getCategoria());
			ps.setString(3, j.getDesenvolvedor());
			ps.setString(4, j.getValor());
			ps.setString(5, j.getEstoque());
			ps.setLong(6, j.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public void Excluir(Jogo j) {
		
		String sql = "delete from jogos where id_jogo = ?";
		
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
