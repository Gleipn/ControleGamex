package br.com.gamex.controlegamex.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gamex.controlegamex.model.entidade.Cliente;
import br.com.gamex.controlegamex.model.entidade.Jogos;
import br.com.gamex.controlegamex.model.entidade.Venda;

public class VendaDao extends Conexao {
	
	public void Cadastrar(Venda v) {
		
		String sql = "insert into venda (jogo_id, cliente_id) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, v.getJogo().getId());
			ps.setLong(2, v.getCliente().getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			System.out.println("Deu problema no insert");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}

	public ArrayList<Venda> Listar(){
		ArrayList<Venda> lista = new ArrayList<Venda>();
		
		String sql = "select v.*, c.nome as cliente_nome, j.nome as jogo_nome from Venda v "
				+ "inner join cliente c on c.id = v.cliente_id "
				+ "inner join jogos j on j.id = v.jogo_id "
				+ "order by v.criado_em";
				
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			Venda v = null;
			Cliente c = null;
			Jogos j = null;
			
			while(rs.next()) {
				
				
				v = new Venda();
				v.setId(rs.getLong("venda_id"));
				v.setCriado_em(rs.getString("criado_em"));
				
				c = new Cliente();
				c.setId(rs.getLong("cliente_id"));
				c.setNome(rs.getString("cliente_nome"));
				v.setCliente(c);
				
				j = new Jogos();
				j.setId(rs.getLong("jogo_id"));
				j.setNome(rs.getString("jogo_nome"));
				v.setJogo(j);
				
				lista.add(v);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no Listar");
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
}