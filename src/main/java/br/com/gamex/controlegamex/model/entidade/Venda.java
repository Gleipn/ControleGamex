package br.com.gamex.controlegamex.model.entidade;

public class Venda {
	
	private long id;
	private String criado_em;
	
	private Jogo jogo;
	private Cliente cliente;
	
	public Venda(long id, String criado_em, Jogo jogo, Cliente cliente) {
		super();
		this.id = id;
		this.criado_em = criado_em;
		this.jogo = jogo;
		this.cliente = cliente;
	}
	
	public Venda() {
		super();
		this.id = 0;
		this.criado_em = "";
		this.jogo = new Jogo();
		this.cliente = new Cliente();
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

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
