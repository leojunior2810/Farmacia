package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import model.ItemVenda;
import model.Produto;
import model.Venda;

@ManagedBean(name = "MBItem")
@SessionScoped
public class ItemVendaBean extends BasicBean {
	private ArrayList<Venda> vendas;
	private ArrayList<Produto> produtos;
	private ItemVenda itemVenda=new ItemVenda();
	private ListDataModel<ItemVenda> itens;


	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	public ListDataModel<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<ItemVenda> itens) {
		this.itens = itens;
	}

	public String iniciarPagina() {
		pesquisa();
		return "item.xhtml";
	}

	@PostConstruct
	public void pesquisa() {
		try {
			ItemVendaDAO dao = new ItemVendaDAO();
			ArrayList<ItemVenda> lista = dao.listar();
			VendaDAO vendasDao = new VendaDAO();
			vendas = vendasDao.listar();
			ProdutoDAO produtoDao = new ProdutoDAO();
			produtos = produtoDao.listar();

			itens = new ListDataModel<ItemVenda>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void prepararNovo() {
		itemVenda = new ItemVenda();
	}

	public void prepararExcluir() {
		itemVenda = itens.getRowData();
	}

	public void prepararAlterar() {
		itemVenda = itens.getRowData();
	}

	public void novo() {
		try {
			ItemVendaDAO dao = new ItemVendaDAO();
			dao.incluir(itemVenda);

			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void excluir() {
		try {
			ItemVendaDAO dao = new ItemVendaDAO();
			dao.deletar(itemVenda);

			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void alterar() {
		try {
			ItemVendaDAO dao = new ItemVendaDAO();
			dao.editar(itemVenda);

			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}


	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

}
