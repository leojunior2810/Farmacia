package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import dao.ProdutoDAO;
import model.Produto;

@ManagedBean(name = "MBProduto")
@SessionScoped
public class ProdutoBean extends BasicBean {

	private Produto produto;
	private ListDataModel<Produto> itens;
	private Date dataProduto = new Date();



	public Date getDataProduto() {
		return dataProduto;
	}


	public void setDataProduto(Date dataProduto) {
		this.dataProduto = dataProduto;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public ListDataModel<Produto> getItens() {
		return itens;
	}


	public void setItens(ListDataModel<Produto> itens) {
		this.itens = itens;
	}


	@PostConstruct
	public void pesquisa() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			ArrayList<Produto> lista = dao.listar();
			itens = new ListDataModel<Produto>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	public void prepararNovo() {
		produto = new Produto();
	}
	
	public void prepararExcluir() {
		produto = itens.getRowData();
	}

	public void prepararAlterar() {
		produto = itens.getRowData();
	}
	
	
	public void novo() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			produto.setDataProd(new java.sql.Date(dataProduto.getTime()));
			dao.incluir(produto);

			ArrayList<Produto> lista = dao.listar();
			itens = new ListDataModel<Produto>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.deletar(produto);

			ArrayList<Produto> lista = dao.listar();
			itens = new ListDataModel<Produto>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void alterar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);

			ArrayList<Produto> lista = dao.listar();
			itens = new ListDataModel<Produto>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
