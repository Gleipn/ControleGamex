package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Cliente;

public class ClienteDao extends Conexao {

	public boolean Cadastrar(Cliente c) {
		boolean ok = true;
		
		String sql = "insert into cliente (cpf_cliente, nome_cliente, endereco_cliente, "
				+ "telefone_cliente, email_cliente) "
				+ "values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getTelefone());
			ps.setString(5, c.getEmail());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public ArrayList<Cliente> Listar(String nomeBusca) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		String sql = "select * from cliente where nome like ? order by nome";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				
				lista.add(c);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Cliente Localizar(long id) {
		Cliente c = null;
		
		String sql = "select * from cliente where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return c;
		
	}
	
	public boolean Alterar(Cliente c) {
		boolean ok = true;
		
		String sql = "update cliente set cpf_cliente = ?, nome_cliente = ?, "
				+ "endereco_cliente = ?, telefone_cliente = ?, email_cliente = ? where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getTelefone());
			ps.setString(5, c.getEmail());
			ps.setLong(6, c.getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public boolean Excluir(Cliente c) {
		boolean ok  = true;
		
		String sql = "delete from cliente where id_cliente = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, c.getId());
			
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