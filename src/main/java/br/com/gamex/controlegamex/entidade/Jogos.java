package br.com.gamex.controlegamex.entidade;

public class Jogos {

	private long codigo;
	private String nome_jogo;
	private String categoria;
	private String desenvolvedor;
	private double valor;
	private int estoque;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome_jogo() {
		return nome_jogo;
	}
	public void setNome_jogo(String nome_jogo) {
		this.nome_jogo = nome_jogo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDesenvolvedor() {
		return desenvolvedor;
	}
	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
}
