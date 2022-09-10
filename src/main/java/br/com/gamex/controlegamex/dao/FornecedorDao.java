package br.com.gamex.controlegamex.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gamex.controlegamex.entidade.Fornecedor;

public class FornecedorDao extends Conexao {

	public boolean Cadastrar(Fornecedor f) {
		boolean ok = true;
		
		String sql = "insert into fornecedor (cnpj, nome, endereco, email) "
				+ "values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getEndereco());
			ps.setString(4, f.getEmail());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public List<Fornecedor> Listar(String nomeBusca) {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		String sql = "select * from fornecedor where nome like ? order by nome";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Fornecedor f;
			while(rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("id"));
				f.setCnpj(rs.getString("cnpj"));
				f.setNome(rs.getString("nome"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				
				lista.add(f);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
		
	}
	
	public Fornecedor Localizar(long id) {
		Fornecedor f = null;
		
		String sql = "select * from fornecedor where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("id"));
				f.setCnpj(rs.getString("cnpj"));
				f.setNome(rs.getString("nome"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return f;
		
	}
	
	public boolean Alterar(Fornecedor f) {
		boolean ok = true;
		
		String sql = "update fornecedor set cnpj = ?, nome = ?, endereco = ?,"
				+ " email = ? where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getEndereco());
			ps.setString(4, f.getEmail());
			ps.setLong(5, f.getId());
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
		
	}
	
	public boolean Excluir(long id) {
		boolean ok  = true;
		
		String sql = "delete from fornecedor where id = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
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
