package model;

import java.sql.Date;

public class Venda {

	private int idVENDA;
	private Date dataVenda;
	private String dataVenc;
	private String dataPgto;
	private String obs;
	private double iof;
	private double icms;
	private double ipi;
	


	public int getIdVENDA() {
		return idVENDA;
	}

	public void setIdVENDA(int idVENDA) {
		this.idVENDA = idVENDA;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}


	public String getDataVenc() {
		return dataVenc;
	}


	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}

	public String getDataPgto() {
		return dataPgto;
	}

	public void setDataPgto(String dataPgto) {
		this.dataPgto = dataPgto;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public double getIof() {
		return iof;
	}

	public void setIof(double iof) {
		this.iof = iof;
	}

	public double getIcms() {
		return icms;
	}

	public void setIcms(double icms) {
		this.icms = icms;
	}

	public double getIpi() {
		return ipi;
	}

	public void setIpi(double ipi) {
		this.ipi = ipi;
	}


	public String toString() {
		String saida = idVENDA + "-" + dataVenda + "-" + dataVenc + "-" + dataPgto + "-" + obs + "-" + iof + "-" +
				icms + "-" + ipi;
			return saida;
	}
	
	

	
	
}
