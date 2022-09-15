package br.com.gamex.controlegamex.model.entidade;

public class Compra {

	private long id;
	private String criado_em;
	
	private Fornecedor fornecedor;
	private Jogo jogo;
	
	public Compra(long id, String criado_em, Fornecedor fornecedor, Jogo jogo) {
		super();
		this.id = id;
		this.criado_em = criado_em;
		this.fornecedor = fornecedor;
		this.jogo = jogo;
	}
	
	public Compra() {
		super();
		this.id = 0;
		this.criado_em = "";
		this.fornecedor = new Fornecedor();
		this.jogo = new Jogo();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCriado_em() {
		return criado_em;
	}
	public void setCriado_em(String criado_em) {
		this.criado_em = criado_em;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
}
