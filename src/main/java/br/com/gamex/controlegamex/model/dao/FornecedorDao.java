package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Fornecedor;

public class FornecedorDao extends Conexao {

	public void Cadastrar(Fornecedor f) {
		
		String sql = "insert into fornecedor (cnpj_fornecedor, nome_fornecedor, "
				+ "endereco_fornecedor, email_fornecedor) "
				+ "values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getEndereco());
			ps.setString(4, f.getEmail());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public ArrayList<Fornecedor> Listar(String nomeBusca) {
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		String sql = "select * from fornecedor where nome_fornecedor like ? "
				+ "order by nome_fornecedor";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Fornecedor f;
			while(rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("id_fornecedor"));
				f.setCnpj(rs.getString("cnpj_fornecedor"));
				f.setNome(rs.getString("nome_fornecedor"));
				f.setEndereco(rs.getString("endereco_fornecedor"));
				f.setEmail(rs.getString("email_fornecedor"));
				
				lista.add(f);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Fornecedor Localizar(long id) {
		Fornecedor f = null;
		
		String sql = "select * from fornecedor where id_fornecedor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("id_fornecedor"));
				f.setCnpj(rs.getString("cnpj_fornecedor"));
				f.setNome(rs.getString("nome_fornecedor"));
				f.setEndereco(rs.getString("endereco_fornecedor"));
				f.setEmail(rs.getString("email_fornecedor"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return f;
		
	}
	
	public void Alterar(Fornecedor f) {
		
		String sql = "update fornecedor set cnpj_fornecedor = ?, nome_fornecedor = ?,"
				+ " endereco_fornecedor = ?,"
				+ " email_fornecedor = ? where id_fornecedor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getEndereco());
			ps.setString(4, f.getEmail());
			ps.setLong(5, f.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
	public void Excluir(Fornecedor f) {
		
		String sql = "delete from fornecedor where id_fornecedor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, f.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
	
}
