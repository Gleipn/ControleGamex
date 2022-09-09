package br.com.gamex.controlegamex.entidade;

public class Usuario {

	private long cod_usuario;
	private String cpf;
	private String email;
	private String senha;
	
	public long getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
