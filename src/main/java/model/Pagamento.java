package model;

import java.sql.Date;

public class Pagamento {

	private int idPAG;
	private String nome;
	private double valorTotal;
	private Date dtVenda;
	private String tipoPagamento;
	private String obs;
	private int nCheque;
	private int nCartao;
	
	
	public int getIdPAG() {
		return idPAG;
	}
	public void setIdPAG(int idPAG) {
		this.idPAG = idPAG;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDtVenda() {
		return dtVenda;
	}
	public void setDtVenda(Date dtVenda) {
		this.dtVenda = dtVenda;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public int getnCheque() {
		return nCheque;
	}
	public void setnCheque(int nCheque) {
		this.nCheque = nCheque;
	}
	public int getnCartao() {
		return nCartao;
	}
	public void setnCartao(int nCartao) {
		this.nCartao = nCartao;
	}


	


}
