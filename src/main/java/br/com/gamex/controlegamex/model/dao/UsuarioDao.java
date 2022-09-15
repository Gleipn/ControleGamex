package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Usuario;

public class UsuarioDao extends Conexao {
	
	public void Cadastrar(Usuario u) {
		
		String sql = "insert into usuario (cpf_usuario, nome_usuario, email_usuario, "
				+ "senha_usuario) values (?, ?, ?, md5(?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSenha());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public ArrayList<Usuario> Listar(String nomeBusca) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = "select * from usuario where nome_usuario like ? order by nome_usuario";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Usuario u;
			while(rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id_usuario"));
				u.setNome(rs.getString("nome_usuario"));
				u.setCpf(rs.getString("cpf_usuario"));
				u.setEmail(rs.getString("email_usuario"));
				
				lista.add(u);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Usuario Localizar(long id) {
		Usuario u = null;
		
		String sql = "select * from usuario where id_usuario = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id_usuario"));
				u.setNome(rs.getString("nome_usuario"));
				u.setCpf(rs.getString("cpf_usuario"));
				u.setEmail(rs.getString("email_usuario"));
				u.setCriado_em(rs.getString("criado_em"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return u;
		
	}
	
	public void Alterar(Usuario u) {
		
		String sql = "update usuario set cpf_usuario = ?, nome_usuario = ?, email_usuario = ?, "
				+ "senha_usuario = md5(?) "
				+ "where id_usuario = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getSenha());
			ps.setLong(4, u.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public void Excluir(Usuario u) {
		
		String sql = "delete from usuario where id_usuario = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, u.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
}