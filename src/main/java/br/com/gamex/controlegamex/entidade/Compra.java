package br.com.gamex.controlegamex.entidade;

public class Compra {

	private long nota_fiscal;
	private String data;
	private long cnpj_fornecedor;
	private long cod_jogo;
	
	public long getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(long nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}
	public void setCnpj_fornecedor(long cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}
	public long getCod_jogo() {
		return cod_jogo;
	}
	public void setCod_jogo(long cod_jogo) {
		this.cod_jogo = cod_jogo;
	}
	
}
