package br.com.gamex.controlegamex.entidade;

public class Compra {

	private long id;
	private long nota_fiscal;
	private String criado_em;
	
	private Fornecedor fornecedor;
	private Jogos jogo;
	
	public Compra(long id, long nota_fiscal, String criado_em, Fornecedor fornecedor, Jogos jogo) {
		super();
		this.id = id;
		this.nota_fiscal = nota_fiscal;
		this.criado_em = criado_em;
		this.fornecedor = fornecedor;
		this.jogo = jogo;
	}
	
	public Compra() {
		super();
		this.id = 0;
		this.nota_fiscal = 0;
		this.criado_em = "";
		this.fornecedor = new Fornecedor();
		this.jogo = new Jogos();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(long nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
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
	public Jogos getJogo() {
		return jogo;
	}
	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}
	
}
