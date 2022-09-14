package br.com.gamex.controlegamex.model.entidade;

public class Status {

	private long id;
	private String status;
	private String criado_em;
	
	private Venda venda;

	public Status(long id, String status, String criado_em, Venda venda) {
		super();
		this.id = id;
		this.status = status;
		this.criado_em = criado_em;
		this.venda = venda;
	}
	
	public Status() {
		super();
		this.id = 0;
		this.status = "";
		this.criado_em = "";
		this.venda = new Venda();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(String criado_em) {
		this.criado_em = criado_em;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
}
