package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import dao.ProdutoDAO;
import model.Produto;

@ManagedBean(name = "MBProduto")
@RequestScoped
public class ProdutoBean extends BasicBean {

	private Produto produto;
	private ListDataModel<Produto> itens;


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


	public void novo() {
		try {
			produto = new Produto();
			ProdutoDAO dao = new ProdutoDAO();
			dao.incluir(produto);

			ArrayList<Produto> lista = dao.listar();
			itens = new ListDataModel<Produto>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			produto = itens.getRowData();

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
			produto = itens.getRowData();
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);

			ArrayList<Produto> lista = dao.listar();
			itens = new ListDataModel<Produto>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
