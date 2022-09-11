package br.com.gamex.controlegamex.entidade;

public class Feedback {

	private long id;
	private String feedback;
	private String criado_em;
	
	private Venda venda;

	public Feedback(long id, String feedback, String criado_em, Venda venda) {
		super();
		this.id = id;
		this.feedback = feedback;
		this.criado_em = criado_em;
		this.venda = venda;
	}
	
	public Feedback() {
		super();
		this.id = 0;
		this.feedback = "";
		this.criado_em = "";
		this.venda = new Venda();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
