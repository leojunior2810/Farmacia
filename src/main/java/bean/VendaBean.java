package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.PagamentoDAO;
import dao.VendaDAO;
import model.Cliente;
import model.Funcionario;
import model.Pagamento;
import model.Venda;

@ManagedBean(name = "MBVenda")
@SessionScoped
public class VendaBean extends BasicBean {
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Pagamento> pagamentos;
	private ArrayList<Pagamento> valorVenda;
	private Venda venda = new Venda();
	private ListDataModel<Venda> itens;
	private Date dataVenda = new Date();

	
	public Date getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public ListDataModel<Venda> getItens() {
		return itens;
	}


	public void setItens(ListDataModel<Venda> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void pesquisa() {
		try {
			VendaDAO dao = new VendaDAO();
			ArrayList<Venda> lista = dao.listar();
			ClienteDAO clientesDao = new ClienteDAO();
			clientes = clientesDao.listar();
			FuncionarioDAO funcionariosDao = new FuncionarioDAO();
			funcionarios = funcionariosDao.listar();
			PagamentoDAO pagamentosDao = new PagamentoDAO();
			pagamentos = pagamentosDao.listar();
			valorVenda = pagamentosDao.listar();
			
			itens = new ListDataModel<Venda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	public void prepararNovo() {
		venda = new Venda();
	}
	
	public void prepararExcluir() {
		venda = itens.getRowData();
	}

	public void prepararAlterar() {
		venda = itens.getRowData();
	}

	
	public void novo() {
		try {
			VendaDAO dao = new VendaDAO();
			venda.setDataVenda(new java.sql.Date(dataVenda.getTime()));
			dao.incluir(venda);

			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public void excluir() {
		try {
			VendaDAO dao = new VendaDAO();
			dao.deletar(venda);

			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}


	public void alterar() {
		try {
			VendaDAO dao = new VendaDAO();
			dao.editar(venda);

			ArrayList<Venda> lista = dao.listar();
			itens = new ListDataModel<Venda>(lista);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}


	public void setPagamentos(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}


	public ArrayList<Pagamento> getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(ArrayList<Pagamento> valorVenda) {
		this.valorVenda = valorVenda;
	}

}
