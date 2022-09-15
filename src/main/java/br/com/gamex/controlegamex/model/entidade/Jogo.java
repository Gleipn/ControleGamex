package br.com.gamex.controlegamex.model.entidade;

public class Jogo {

	private long id;
	private String nome;
	private String categoria;
	private String desenvolvedor;
	private double valor;
	private int estoque;
	private String imagem;
	private String criado_em;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getCriado_em() {
		return criado_em;
	}
	public void setCriado_em(String criado_em) {
		this.criado_em = criado_em;
	}
	
}
