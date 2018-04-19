package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import dao.PagamentoDAO;
import model.Pagamento;

@ManagedBean(name = "MBPagamento")
@RequestScoped
public class PagamentoBean extends BasicBean {

	private Pagamento pagamento;
	private ListDataModel<Pagamento> itens;
	
	
	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public ListDataModel<Pagamento> getItens() {
		return itens;
	}


	public void setItens(ListDataModel<Pagamento> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			PagamentoDAO dao = new PagamentoDAO();
			ArrayList<Pagamento> lista = dao.listar();
			itens = new ListDataModel<Pagamento>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	
	public void novo() {
		try {
			pagamento = new Pagamento();
			PagamentoDAO dao = new PagamentoDAO();
			dao.incluir(pagamento);

			ArrayList<Pagamento> lista = dao.listar();
			itens = new ListDataModel<Pagamento>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	public void excluir() {
		try {
			pagamento = itens.getRowData();

			PagamentoDAO dao = new PagamentoDAO();
			dao.deletar(pagamento);

			ArrayList<Pagamento> lista = dao.listar();
			itens = new ListDataModel<Pagamento>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	public void alterar() {
		try {
			pagamento = itens.getRowData();
			PagamentoDAO dao = new PagamentoDAO();
			dao.editar(pagamento);

			ArrayList<Pagamento> lista = dao.listar();
			itens = new ListDataModel<Pagamento>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
