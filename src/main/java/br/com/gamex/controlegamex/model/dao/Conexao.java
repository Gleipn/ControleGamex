package br.com.gamex.controlegamex.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String caminho = "jdbc:mysql://localhost:3306/gamex"; //Caminho da base de dados
	private String usuario = "root"; //Usuario do banco de dados
	private String senha = ""; //Senha do banco de dados

	private Connection conn = null;

	public Connection criarConexao() {
		try {
			//Class.forName("com.mysql.jdbc.Driver"); Driver antigo
			Class.forName("com.mysql.cj.jdbc.Driver"); //Novo Driver
			conn = DriverManager.getConnection(caminho, usuario, senha);
			//System.out.println("Conectado com sucesso");
		} catch (ClassNotFoundException e) {
			//System.out.println("Nao encontrou o Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			//System.out.println("Erro ao acessar o banco de dados");
			e.printStackTrace();
		}
		return conn;
	}
	
	public void fecharConexao() {
		try {
			conn.close();
			//System.out.println("Conexao fechada");
		} catch (SQLException e) {
			//System.out.println("Deu problema");
			e.printStackTrace();
		}
	}
	
}