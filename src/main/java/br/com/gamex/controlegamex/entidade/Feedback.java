package br.com.gamex.controlegamex.entidade;

public class Feedback {

	private String feedback_cliente;
	private long cod_venda_entregue;
	
	public String getFeedback_cliente() {
		return feedback_cliente;
	}
	public void setFeedback_cliente(String feedback_cliente) {
		this.feedback_cliente = feedback_cliente;
	}
	public long getCod_venda_entregue() {
		return cod_venda_entregue;
	}
	public void setCod_venda_entregue(long cod_venda_entregue) {
		this.cod_venda_entregue = cod_venda_entregue;
	}
	
}
