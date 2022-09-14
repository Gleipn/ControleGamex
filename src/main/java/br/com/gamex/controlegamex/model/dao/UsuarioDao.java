package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Usuario;

public class UsuarioDao extends Conexao {
	
	public boolean Cadastrar(Usuario u) {
		boolean ok = true;
		
		String sql = "insert into usuario (cpf, nome, email, senha) values (?, ?, ?, md5(?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSenha());
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public ArrayList<Usuario> Listar(String nomeBusca) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = "select * from usuario where nome like ? order by nome";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Usuario u;
			while(rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNome(rs.getString("nome"));
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				
				lista.add(u);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Usuario Localizar(long id) {
		Usuario u = null;
		
		String sql = "select * from usuario where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNome(rs.getString("nome"));
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				u.setCriado_em(rs.getString("criado_em"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return u;
		
	}
	
	public boolean Alterar(Usuario u) {
		boolean ok = true;
		
		String sql = "update usuario set cpf = ?, nome = ?, email = ?, senha = md5(?) "
				+ "where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getSenha());
			ps.setLong(4, u.getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public boolean Excluir(Usuario u) {
		boolean ok  = true;
		
		String sql = "delete from usuario where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, u.getId());
			
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