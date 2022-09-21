package br.com.gamex.controlegamex.model.entidade;

public class Venda {
	
	private long id;
	private String criado_em;
	
	private Cliente cliente;
	private Jogo jogo;
	
	public Venda(long id, String criado_em, Cliente cliente, Jogo jogo) {
		super();
		this.id = id;
		this.criado_em = criado_em;
		this.cliente = cliente;
		this.jogo = jogo;
	}
	
	public Venda() {
		super();
		this.id = 0;
		this.criado_em = "";
		this.cliente = new Cliente();
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

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
}
