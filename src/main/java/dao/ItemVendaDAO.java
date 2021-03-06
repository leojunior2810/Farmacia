package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.ItemVenda;

public class ItemVendaDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {

		if(obj instanceof ItemVenda) {
			ItemVenda i = (ItemVenda) obj;


			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO item_venda ");
			sql.append("(Qtde,ValorUni,Desconto,Obs,VENDA_idVENDA,PRODUTO_idPROD)");
			sql.append("VALUES (?,?,?,?,?,?)");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst =  conexao.prepareStatement(sql.toString());
			pst.setInt(1, i.getQtde());
			pst.setDouble(2, i.getValorUni());
			pst.setString(3, i.getDesconto());
			pst.setString(4, i.getObs());
			pst.setInt(5, i.getIdVenda());
			pst.setInt(6, i.getIdProduto());
			
			pst.executeUpdate();
			pst.close();
		}



	}

	@Override
	public void deletar(Object obj) throws SQLException {

		if(obj instanceof ItemVenda) {
			ItemVenda i = (ItemVenda) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM item_venda ");
			sql.append("WHERE idITEM_VENDA = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, i.getIdITEM_VENDA());

			pst.executeUpdate();
			pst.close();

		}

	}

	@Override
	public void editar(Object obj) throws SQLException {

		if(obj instanceof ItemVenda) {
			ItemVenda i = (ItemVenda) obj;

			String sql = "UPDATE item_venda SET Qtde = ?, ValorUni = ?, Desconto = ?, Obs = ? WHERE idITEM_VENDA = ? ";


			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, i.getQtde());
			pst.setDouble(2, i.getValorUni());
			pst.setString(3, i.getDesconto());
			pst.setString(4, i.getObs());
			pst.setInt(5, i.getIdITEM_VENDA());

			pst.executeUpdate();
			pst.close();
		}			
	}


	public ArrayList<ItemVenda> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT item_venda.*, produto.Nome as NomeProduto, venda.DataPgto as DataPgto ");
		sql.append("FROM item_venda inner join produto on item_venda.PRODUTO_idPROD=produto.idPROD ");
		sql.append(" inner join venda on item_venda.VENDA_idVENDA=venda.idVENDA");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<ItemVenda> lista = new ArrayList<ItemVenda>();

		while(rs.next()) {
			ItemVenda i = new ItemVenda();
			i.setIdITEM_VENDA(rs.getInt("idITEM_VENDA"));
			i.setQtde(rs.getInt("Qtde"));
			i.setValorUni(rs.getDouble("ValorUni"));
			i.setDesconto(rs.getString("Desconto"));
			i.setObs(rs.getString("Obs"));
			i.setNomeProduto(rs.getString("NomeProduto"));
			i.setDataPgto(rs.getString("DataPgto"));

			lista.add(i);
		}
		return lista;
	}



}

