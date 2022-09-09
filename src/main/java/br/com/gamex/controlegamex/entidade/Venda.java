package br.com.gamex.controlegamex.entidade;

public class Venda {

	private long codigo_venda;
	private String data;
	private long cod_jogo;
	private long cpf_cliente;
	
	public long getCodigo_venda() {
		return codigo_venda;
	}
	public void setCodigo_venda(long codigo_venda) {
		this.codigo_venda = codigo_venda;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getCod_jogo() {
		return cod_jogo;
	}
	public void setCod_jogo(long cod_jogo) {
		this.cod_jogo = cod_jogo;
	}
	public long getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(long cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	
}
