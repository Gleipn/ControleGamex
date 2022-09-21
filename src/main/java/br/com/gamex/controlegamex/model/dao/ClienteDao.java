package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Cliente;

public class ClienteDao extends Conexao {

	public void Cadastrar(Cliente c) {
		
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
			
		} catch(SQLException e) {
			//System.out.println("Deu problema no insert");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public ArrayList<Cliente> Listar(long limite) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		
		String sql = "select * from cliente order by criado_em desc limit ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, limite);
			
			ResultSet rs = ps.executeQuery();
			
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id_cliente"));
				c.setCpf(rs.getString("cpf_cliente"));
				c.setNome(rs.getString("nome_cliente"));
				c.setEndereco(rs.getString("endereco_cliente"));
				c.setTelefone(rs.getString("telefone_cliente"));
				c.setEmail(rs.getString("email_cliente"));
				c.setCriado_em(rs.getString("criado_em"));
				
				lista.add(c);
				
				
			}
		} catch(SQLException e) { 
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Cliente Localizar(long id) {
		Cliente c = null;
		
		String sql = "select * from cliente where id_cliente = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id_cliente"));
				c.setCpf(rs.getString("cpf_cliente"));
				c.setNome(rs.getString("nome_cliente"));
				c.setEndereco(rs.getString("endereco_cliente"));
				c.setTelefone(rs.getString("telefone_cliente"));
				c.setEmail(rs.getString("email_cliente"));
				
			}
			
		} catch(SQLException e) { 
			//System.out.println("Erro no Localizar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return c;
		
	}
	
	public void Alterar(Cliente c) {
		
		String sql = "update cliente set cpf_cliente = ?, nome_cliente = ?, "
				+ "endereco_cliente = ?, telefone_cliente = ?, email_cliente = ? where id_cliente = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getTelefone());
			ps.setString(5, c.getEmail());
			ps.setLong(6, c.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			//System.out.println("Erro no Update");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public void Excluir(Cliente c) {
		
		String sql = "delete from cliente where id_cliente = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, c.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			//System.out.println("Erro na exclusao");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
}