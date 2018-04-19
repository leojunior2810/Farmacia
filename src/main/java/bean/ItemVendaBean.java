package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import dao.ItemVendaDAO;
import model.ItemVenda;

@ManagedBean(name = "MBItem")
@RequestScoped
public class ItemVendaBean extends BasicBean {

	private ItemVenda itemVenda;
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


	@PostConstruct
	public void pesquisa() {
		try {
			ItemVendaDAO dao = new ItemVendaDAO();
			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}



	public void novo() {
		try {
			itemVenda = new ItemVenda();
			ItemVendaDAO dao = new ItemVendaDAO();
			dao.incluir(itemVenda);

			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			itemVenda = itens.getRowData();

			ItemVendaDAO dao = new ItemVendaDAO();
			dao.deletar(itemVenda);

			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void alterar() {
		try {
			itemVenda = itens.getRowData();
			ItemVendaDAO dao = new ItemVendaDAO();
			dao.editar(itemVenda);

			ArrayList<ItemVenda> lista = dao.listar();
			itens = new ListDataModel<ItemVenda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
